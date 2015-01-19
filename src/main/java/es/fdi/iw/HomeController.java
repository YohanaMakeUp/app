package es.fdi.iw;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import es.fdi.iw.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Intercepts login requests generated by the header; then continues to load normal page
	 */
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model, HttpSession session) {
		String formLogin = request.getParameter("login");
		String formPass = request.getParameter("pass");
		String formSource = request.getParameter("source");
		logger.info("Login attempt from '{}' while visiting '{}'", formLogin, formSource);

		// validate request
		boolean error = false;
		if (formLogin == null || formLogin.length() < 4 || formPass == null || formPass.length() < 4) {
			error = true;
		} else {
			// check password here; if errors, set 'error' to true...
		}

		// output
		if (error) {
			model.addAttribute("loginError", "error en usuario o contraseña");
		} else {
			session.setAttribute("user", new User(formLogin, "admin".equals(formLogin) ? "admin" : "user"));
		}

		return "redirect:" + formSource;
	}


	  Logout (also returns to home view).

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("User '{}' logged out", session.getAttribute("user"));
		session.invalidate();
		return "redirect:/";
	}

	/**
	 * Toggles debug mode

	@RequestMapping(value = "/debug", method = RequestMethod.GET)
	public String debug(HttpSession session, HttpServletRequest request) {
		String formDebug = request.getParameter("debug");
		logger.info("Setting debug to {}", formDebug);
		session.setAttribute("debug", 
				"true".equals(formDebug) ? "true" : "false");
		return "redirect:/";
	}



	/**
	 * A not-very-dynamic view that shows an "about us".

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Locale locale, Model model) {
		logger.info("User is looking up 'about us'");
		return "about";
	}	*/


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Home");

		/*
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		 */

		return "index";
	}	

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Home");



		return "index";
	}	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/bio", method = RequestMethod.GET)
	public String bio(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Bio");

		return "bio";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/cinema", method = RequestMethod.GET)
	public String cinema(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Cinema");

		return "cinema";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/citas", method = RequestMethod.GET)
	public String citas(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Citas");

		return "citas";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/contacto", method = RequestMethod.GET)
	public String contacto(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Contacto");

		return "contacto";
	}

	@RequestMapping(value = "/contacto", method = RequestMethod.POST)
	public String contacto(HttpServletRequest request, Model model, HttpSession session) {	
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String apellido = request.getParameter("apellido");
		String asunto = request.getParameter("asunto");

		if (nombre == null || email == null || apellido == null || asunto == null) {

			model.addAttribute("Error", "Rellene todos los campos");

		} else {



		}


		return "contacto";
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/galleryCelebrities", method = RequestMethod.GET)
	public String galleryCelebrities(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Celebrities");

		return "galleryCelebrities";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/galleryEditorial", method = RequestMethod.GET)
	public String galleryEditorial(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Editorial");

		return "galleryEditorial";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/galleryEventos", method = RequestMethod.GET)
	public String galleryEventos(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Eventos");

		return "galleryEventos";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/galleryModaBelleza", method = RequestMethod.GET)
	public String galleryModaBelleza(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Moda y Belleza");

		return "galleryModaBelleza";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/galleryNovias", method = RequestMethod.GET)
	public String galleryNovias(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Novias");

		return "galleryNovias";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/galleryProduccion", method = RequestMethod.GET)
	public String galleryProduccion(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);

		return "galleryProduccion";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/logIn", method = RequestMethod.GET)
	public String logIn(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Log In");

		return "logIn";
	}

	@RequestMapping(value = "/logIn", method = RequestMethod.POST)
	@Transactional
	public String login(HttpServletRequest request, Model model, HttpSession session) {

		String formLogin = request.getParameter("name");
		String formPass = request.getParameter("password");


		User u = null;

		try {

			u = (User) entityManager.createNamedQuery("userByLogin").setParameter("loginParam", formLogin).getSingleResult();
	
		} catch (NoResultException e) {

			model.addAttribute("error", "Usuario no encontrado");

		}

		if(u != null){

			if (!formPass.equals(u.getPassword())) {

				model.addAttribute("loginError", "error en usuario o contrasena");

			}else{

				session.setAttribute("user", u);

			}

		}

		return "logIn";
	}


	private boolean noEstaRepe(String alias) {
		return entityManager.createNamedQuery("userByLogin")
				.setParameter("loginParam", alias)
				.getResultList().size() == 0;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	@Transactional
	public String registro(HttpServletRequest request, Model model, HttpSession session) {	

		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("email");
		String nombreUsuario = request.getParameter("nombreUsuario");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");

		if (!noEstaRepe(nombreUsuario)) {

			model.addAttribute("error", "El alias introducido ya existe");

		}else if (nombre == "" || apellidos == "" || email == "" || nombreUsuario == "" || password1 == "" || password2 == "") {

			model.addAttribute("error", "Rellene todos los campos");


		}else if(password1.length() < 4){

			model.addAttribute("error", "Longitud de la password demasiado corta (min 4 caracteres)");


		}else if (!password1.equals(password2) ){

			model.addAttribute("error", "No coinciden las passwords");


		}else{


			User user = new User( nombre, apellidos, email , nombreUsuario, password1, "user");
			entityManager.persist(user);


		}


		return "registro";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("User '{}' logged out", session.getAttribute("user"));
		session.invalidate();
		return "redirect:/";
	}



	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String registro(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Registro");



		return "registro";
	}
}
