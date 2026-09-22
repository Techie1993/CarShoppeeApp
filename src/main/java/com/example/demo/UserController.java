package com.example.demo;

import java.io.IOException;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.cars.CarEntity;
import com.example.cars.CarImageService;
import com.example.cars.CarImages;
import com.example.cars.CarService;
import com.example.chats.ChatMessage;
import com.example.chats.ChatService;
import com.example.contacts.ContactService;
import com.example.contacts.contact;
import com.example.garage.GarageEntity;
import com.example.garage.GarageRepository;
import com.example.garage.GarageService;
import com.example.payments.PaymentEntity;
import com.example.payments.PaymentService;
import com.example.sellers.SellerService;
import com.example.sellers.SellersInfo;
import com.example.service.BookService;
import com.example.service.BookingServiceEntity;
import com.example.service.BookingServiceRepository;

import javax.servlet.http.HttpServletResponse;


@Controller
public class UserController {

	@Autowired
	private UserService userve;

	@Autowired
	private SellerService sell;

	@Autowired
	private CarService cserv;

	@Autowired
	private GarageService gserv;
	
	@Autowired
	private ContactService conserv;
	
	@Autowired
	private ChatService chatserv;
	
	@Autowired
	private CarImageService images;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private JWTService jwtService;
	
	
	@Autowired
	private PaymentService payservice;
	
	
	
	 
	   
	
	@GetMapping("/home")
	public String Home() {
		return "home";
	}

	// Logic for Open Registration page

	@GetMapping("/register")
	public String OpenReg(Model model) {
		model.addAttribute("register", new Registration());
		return "register";

	}

	@PostMapping("/register")
	public String SubmitReg(@ModelAttribute("register") Registration register,
			@RequestParam(value = "profileImage", required = false) MultipartFile image,
			RedirectAttributes redirectattributes) throws IOException {

		if (image != null && !image.isEmpty()) {
			register.setImage(image.getBytes());
		}

		Registration saved = userve.SaveUser(register);

		if (saved != null) {
			redirectattributes.addFlashAttribute("success", "User registered successfully!");
		} else {
			redirectattributes.addFlashAttribute("error", "Registration Failed!");
		}

		return "redirect:/register";
	}
	
	
	// Logics for Login

	@GetMapping("/login")
	public String OpenLogin(Model model) {
		model.addAttribute("log", new Registration());
		return "login";
	}

	@PostMapping("/login")
	public String subLogin(@ModelAttribute("log") Registration register, Model model, HttpSession session) {

		Registration validUser = userve.Login(register.getUemail(), register.getUpass());

		if (validUser != null) {

			// JWT Token Generate
			String token = jwtService.generateToken(validUser.getUemail());
			System.out.println("Token is:" + token);

			// Session मध्ये Store करा
			session.setAttribute("jwtToken", token);
			session.setAttribute("uid", validUser.getUid());
			session.setAttribute("username", validUser.getUemail());
			 System.out.println("Timeout: " + session.getMaxInactiveInterval());

			return "redirect:/navigate";
		} else {

			model.addAttribute("error", "Invalid Credentials");
			return "login";
		}
	}
	
	
	  // Logic for navigation page

		@GetMapping("/navigate")
		public String Navigation() {
			return "navigation";
		}
	
	

	// Logic for Add car page
	@GetMapping("/cars/new")
	public String AddCars() {
		return "addcars";
	}

	// Logic for Add seller page
	@GetMapping("/seller")
	public String showForm(Model model) {
		model.addAttribute("seller", new SellersInfo());
		return "seller";
	}

	// Logic for Saving Seller Data
	@PostMapping("/seller")
	public String submitSeller(@ModelAttribute SellersInfo sinfo, RedirectAttributes redirectattributes) {

		try {

			if (sinfo.getImageFile() != null && !sinfo.getImageFile().isEmpty()) {
				sinfo.setImage(sinfo.getImageFile().getBytes());
			}

			sell.Save(sinfo);

			redirectattributes.addFlashAttribute("success", "Seller registered successfully!");

		} catch (Exception e) {
			e.printStackTrace();
			redirectattributes.addFlashAttribute("error", e.getMessage());
		}

		return "redirect:/seller";
	}
	
	// Logic for searching sellers Data..
		@GetMapping("/searchSeller")
		public String searchSeller(@RequestParam String keyword, Model model) {

		    List<SellersInfo> sellers = sell.searchByKeyword(keyword);

		    model.addAttribute("sellers", sellers);
		    model.addAttribute("keyword", keyword);

		    return "enlistedsellers";
		}
		
		
		
		// Logic for Showing Enlisted Sellers
		@GetMapping("/enlistedsellers")
		public String EnlistedSellers(Model model) {

			List<SellersInfo> enlisted = sell.getAllSellers();

			model.addAttribute("sellers", enlisted);

			return "enlistedsellers";
		}
		
		
		@GetMapping("/deleteseller")
		public String DelSellerById(@RequestParam int sid) {
			sell.deleteById(sid);
			return "redirect:/enlistedsellers";
		}
		
		
		// Logic for viewing seller details
		 @GetMapping("/sellerdetails/{id}")
			public String viewSellerDetails(@PathVariable int id, Model model) {

			    SellersInfo selldata = sell.getById(id);
			    
			    model.addAttribute("seller", selldata);
			    return "viewsellers";   
			}
		  
		// Logic for showing up the profile images of seller
			@GetMapping("/sellerImage/{id}")
			public void getSellerImage(@PathVariable int id, HttpServletResponse response) throws IOException {

			    SellersInfo seller = sell.getById(id);

			    if (seller != null && seller.getImage() != null) {

			        response.setContentType("image/jpeg");
			        response.getOutputStream().write(seller.getImage());
			        response.getOutputStream().close();
			    }
			}
		
		
	// Logic for Review Page
	@GetMapping("/trust")
	public String TruestedUser() {
		return "trustedusers";
	}

	// Logic for Saving Car Data and images

	@PostMapping("/cars")
	public String saveCar(CarEntity car, @RequestParam("carImages") MultipartFile[] files) throws IOException {

		cserv.saveCar(car, files);

		return "redirect:/cars/new";
	}

	// Logic for Enlisted Cars
	@GetMapping("/enlisted")
	public String EnlistedCars(Model model) {

		List<CarEntity> cars = cserv.getAllCars();

		model.addAttribute("cars", cars);

		return "enlistedcars";
	}

	 
	// Logic for search cars as per company
	@GetMapping("/search")
	public String searchByKeys(@RequestParam String keyword, Model model) {

	      List<CarEntity> cars = cserv.searchByKeyword(keyword);

	      model.addAttribute("cars", cars);
	      //model.addAttribute("keyword", keyword);

	      return "enlistedcars";
	  }
	  
	
	// Logic for deleting cars by ID
	
	@GetMapping("/deletecars")
	public String DelById(@RequestParam("carid") int carid) {
	    cserv.deleteById(carid);
	    return "redirect:/enlisted";
	}
	  

	// Logic for Review Page
	@GetMapping("/garage")
	public String OpenGarage() {
		return "garage";
	}

	// Logic for Saving Garage Data
	@PostMapping("/garage")
	public String SaveGarage(@ModelAttribute GarageEntity garage,
			@RequestParam(value = "addressFile", required = false) MultipartFile addressProof,
			@RequestParam(value = "garageImages", required = false) MultipartFile[] files) throws IOException {

		if (addressProof != null && !addressProof.isEmpty()) {
			garage.setAddressProof(addressProof.getBytes());
		}

		gserv.save(garage, files);

		return "redirect:/garage";
	}
	
	
	// Logic for searching Garages
	 @GetMapping("/searchGarage")
	  public String searchByKeyword(@RequestParam String keyword, Model model) {

	      List<GarageEntity> garages =gserv.searchByKeyword(keyword); 

	      model.addAttribute("garages", garages);
	      //model.addAttribute("keyword", keyword);

	      return "pgarage";
	  }
	 
	 @GetMapping("/deletegarage")
		public String DelGarageById(@RequestParam("gid") int gid) {
		     gserv.deleteById(gid);
		    return "redirect:/pgarage";
		}
	 
	 
	 @GetMapping("/garagedetails/{id}")
		public String viewGarageDetails(@PathVariable int id, Model model) {

		    GarageEntity garage = gserv.getById(id);
		    
		    model.addAttribute("garage", garage);
		    return "viewgarages";   
		}
	  
	

	@GetMapping("/rti")
	public String RTI() {
		return "RTI";
	}

	
	// Logic for opening MyAccount page..
	
	@GetMapping("/myaccount")
	public String myAccount(HttpSession session, Model model) {

	    Integer uid = (Integer) session.getAttribute("uid");

	    if(uid == null) {
	        return "redirect:/login";
	    }

	    Registration user = userve.getUserById(uid);

	    model.addAttribute("user", user);

	    return "myaccount";
	}

	// Logic for showing up the profile images 
	@GetMapping("/profileImage/{id}")
	public void getProfileImage(@PathVariable int id, HttpServletResponse response) throws IOException {

	    Registration user = userve.findByUid(id);

	    if (user != null && user.getImage() != null) {

	        response.setContentType("image/jpeg");
	        response.getOutputStream().write(user.getImage());
	        response.getOutputStream().close();
	    }
	}
	
	
	// Logic for Showing Enlisted Garages
	@GetMapping("/pgarage")
	public String EnlistedGarages(Model model) {

		List<GarageEntity> garages = gserv.getAllGarages();

		model.addAttribute("garages", garages);

		return "pgarage";
	}
	
	
	
	
	// Logic for openeing Edit profile page
	@GetMapping("/editprofile/{id}")
	public String EditProfile(@PathVariable int id, Model model) {

	    Registration reg = userve.findByUid(id);

	    Editing edit = new Editing();

	    edit.setEid(reg.getUid());
	    edit.setNewname(reg.getUname());
	    edit.setNewemail(reg.getUemail());
	   edit.setNewmob(reg.getUmob());
	    edit.setNewcity(reg.getUcity());
	    edit.setNewstate(reg.getUstate());
	    edit.setNewpass(reg.getUpass());

	    model.addAttribute("editing", edit);

	    return "editprofile";
	}
	
	
	
	// Logic for Updating profile
	
	@PostMapping("/editprofile/{id}")
	public String updateUser(@PathVariable int id,
	                         @ModelAttribute("editing") Editing edit,
	                         @RequestParam("profileImage") MultipartFile file)
	                         throws IOException {

	    Registration update = userve.findByUid(id);

	    if(update == null) {
	        return "redirect:/login";
	    }

	    update.setUname(edit.getNewname());
	    update.setUemail(edit.getNewemail());
	    update.setUmob(edit.getNewmob());
	    update.setUpass(edit.getNewpass());
	    update.setUcity(edit.getNewcity());
	    update.setUstate(edit.getNewstate());


	    // Image update
	    if(!file.isEmpty()) {
	        update.setImage(file.getBytes());
	    }


	    userve.SaveUser(update);

	    return "redirect:/editprofile/" + id;
	}
	
	
	@PostMapping("/contacts")
	public String SaveContact(@ModelAttribute contact con) {
		
		System.out.println(con.getEmail());
		System.out.println(con.getName());
		
		contact saved=conserv.SaveContact(con);
		return "home";
	}
	
	
	// Logic for Opening Chat Box

	@GetMapping("/send")
	public String chatPage(Model model, HttpSession session) {

		Registration user = (Registration) session.getAttribute("user");

		model.addAttribute("user", user);

		return "chat";
	}
	
	
	// Logic for Saving Chats into DB
	
	@PostMapping("/chat/send")
	public String SendChats(@ModelAttribute ChatMessage chats,
	                        HttpSession session) {

	    Registration user = (Registration) session.getAttribute("user");
	    
	    System.out.println("User from session:"+user);
	    System.out.println("Chats from"+chats.getMessage());

	    if(user != null) {

	        
	        chats.setRegistration(user);
	       
	        System.out.println("REGISTRATION AFTER SET : " + chats.getRegistration());
	        System.out.println("SENDER AFTER SET : " + chats.getSender());
	        
	        chats.setSender(user.getUname());  

	    }

	    chatserv.SaveMsg(chats);

	    return "redirect:/navigate";
	}
	
	
	
	@GetMapping("/details/{id}")
	public String viewDetails(@PathVariable int id, Model model) {

	    CarEntity car = cserv.getById(id);
	    
	    model.addAttribute("car", car);
	    return "viewdetails";   
	}
	
	
	@GetMapping("/car/image/{id}")
	public ResponseEntity<byte[]> getCarImage(@PathVariable Integer id) {

		CarImages carImage = images.getByImageId(id);

		if (carImage == null) {

			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(carImage.getContentType()))
				.body(carImage.getImage());

	}
	    
	  // Logic for opening Booking service page
	  @GetMapping("/bookings")
	  public String BookingService(Model model) {
		  List<GarageEntity> garages = gserv.getAllGarages();

	        model.addAttribute("garages", garages);
		  return "bookings";
	  }
	    
	   
	 // Logic for  saving Bookings into DB
	  
	  @PostMapping("/bookingservice")
		public String SubmitReg(@ModelAttribute("bookings")  BookingServiceEntity book, RedirectAttributes redirectattributes) {
			BookingServiceEntity status =bookService.BookUser(book);

			if (status != null) {
				redirectattributes.addFlashAttribute("success", "Booking done!");
			} else {
				redirectattributes.addFlashAttribute("error", "Registration Failed!");
			}
			return "redirect:/bookings";
		}

	  
	  
	  // Logic for Opening service history page
	  
	  @GetMapping("/servicehistory")
	  public String ServiceHistory() {
		  
		  return "servicehistory";
	  }
	  
		
	// Logic for Opening Payment page

	@GetMapping("/payment")
	public String OpenPayment() {

		return "payments";
	}
	  
	// Logic for opening Credit Card Page
	@PostMapping("/mode")
	public String paymentPage(@RequestParam("pay") String paymentMode) {

	    if (paymentMode.equals("credit")) {
	        return "creditcard";
	    }

	    if (paymentMode.equals("debit")) {
	        return "debitcard";
	    }

	    if (paymentMode.equals("upi")) {
	        return "upi";
	    }

	    return "redirect:/payments";
	}
	
	  
	  
	    
}
