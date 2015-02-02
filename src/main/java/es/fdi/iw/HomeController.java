package es.fdi.iw;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import es.fdi.iw.model.Fecha;
import es.fdi.iw.model.FragBio;
import es.fdi.iw.model.FragIndex;
import es.fdi.iw.model.User;


/**
 * Controlador de las vistas
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@PersistenceContext
	private EntityManager entityManager;


	/**
	 * Acceso a la vista inicial, te devuelve la pagina index.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {	

		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Home");

		File f2 = ContextInitializer.getFolder("index");

		model.addAttribute("fotos", f2.list());

		File f3 = ContextInitializer.getFolder("thumbs");

		model.addAttribute("fotosT", f3.list());

		
		if(entityManager.createNamedQuery("dameTexto").getResultList().size() != 0){

			FragIndex f = (FragIndex) entityManager.createNamedQuery("dameTexto").getSingleResult();

			model.addAttribute("titulo", f);
			model.addAttribute("texto", f);
		}

		return "index";
	}	



	/**
	 * Acceso a la vista index, te devuelve la pagina index, aqui se piden los textos de la BBDD.
	 */
	@Transactional
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Home");
		
		File f2 = ContextInitializer.getFolder("index");

		model.addAttribute("fotos", f2.list());
		
		
		File f3 = ContextInitializer.getFolder("thumbs");

		model.addAttribute("fotosT", f3.list());

		if(entityManager.createNamedQuery("dameTexto").getResultList().size() != 0){

			FragIndex f = (FragIndex) entityManager.createNamedQuery("dameTexto").getSingleResult();

			model.addAttribute("titulo", f);
			model.addAttribute("texto", f);
		}

		return "index";
	}	


	/**
	 * Post vista inicial index, te devuelve la pagina index.
	 * Pide los textos de la BBDD. Coge los textos modificados de la vista
	 * y si los campos no son nulos cambia su valor anterior por el nuevo introducido por el Admin.
	 */
	@Transactional
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String index(HttpServletRequest request, Model model, HttpSession session) {	

		String titulo = request.getParameter("nuevoTituloIndex");
		String texto= request.getParameter("nuevoTituloIndexDos");


		if(entityManager.createNamedQuery("dameTexto").getResultList().size() != 0){

			FragIndex f = (FragIndex) entityManager.createNamedQuery("dameTexto").getSingleResult();

			model.addAttribute("titulo", f);
			model.addAttribute("texto", f);
		}

		FragIndex f = (FragIndex) entityManager.createNamedQuery("dameTexto").getSingleResult();

		if (texto != null && titulo !=null) {

			f.setTitulo(titulo);
			f.setTexto(texto);
			entityManager.persist(f);

		}
		else{ 

			if (titulo != null) {

				f.setTitulo(titulo);
				entityManager.persist(f);
			}

			if (texto != null) {

				f.setTexto(texto);
				entityManager.persist(f);
			}
		}

		return "index";
	}	




	/**
	 * Muestra la vista foto celebrities, pide las fotos que hay en su carpeta correspondiente en data.
	 */
	@RequestMapping(value = "/galleryCelebrities", method = RequestMethod.GET)
	public String galleryCelebrities(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Celebrities");
		//leemos los archivos que esten contenidos en la carpeta editorial...
		File f = ContextInitializer.getFolder("celebrities");

		model.addAttribute("fotos", f.list());
		return "galleryCelebrities";
	}



	/**
	 * Muestra la vista foto editorial, pide las fotos que hay en su carpeta correspondiente en data.
	 */
	@RequestMapping(value = "/galleryEditorial", method = RequestMethod.GET)
	public String galleryEditorial(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Editorial");
		// leemos los archivos que esten contenidos en la carpeta editorial...
		File f = ContextInitializer.getFolder("editorial");

		model.addAttribute("fotos", f.list());
		return "galleryEditorial";
	}


	/**
	 * Muestra la vista foto eventos, pide las fotos que hay en su carpeta correspondiente en data.
	 */
	@RequestMapping(value = "/galleryEventos", method = RequestMethod.GET)
	public String galleryEventos(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Eventos");
		// leemos los archivos que esten contenidos en la carpeta editorial...
		File f = ContextInitializer.getFolder("eventos");

		model.addAttribute("fotos", f.list());
		return "galleryEventos";
	}


	/**
	 * Muestra la vista foto moda belleza, pide las fotos que hay en su carpeta correspondiente en data.
	 */
	@RequestMapping(value = "/galleryModaBelleza", method = RequestMethod.GET)
	public String galleryModaBelleza(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Moda y Belleza");
		// leemos los archivos que esten contenidos en la carpeta editorial...
		File f = ContextInitializer.getFolder("modaBelleza");

		model.addAttribute("fotos", f.list());
		return "galleryModaBelleza";
	}


	/**
	 * Muestra la vista foto novias, pide las fotos que hay en su carpeta correspondiente en data.
	 */
	@RequestMapping(value = "/galleryNovias", method = RequestMethod.GET)
	public String galleryNovias(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Novias");
		// leemos los archivos que esten contenidos en la carpeta editorial...
		File f = ContextInitializer.getFolder("novias");

		model.addAttribute("fotos", f.list());
		return "galleryNovias";
	}


	/**
	 * Muestra la vista foto produccion, pide las fotos que hay en su carpeta correspondiente en data.
	 */
	@RequestMapping(value = "/galleryProduccion", method = RequestMethod.GET)
	public String galleryProduccion(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		// leemos los archivos que esten contenidos en la carpeta editorial...
		File f = ContextInitializer.getFolder("produccion");

		model.addAttribute("fotos", f.list());
		return "galleryProduccion";
	}



	/**
	 * Muestra la vista cinema.
	 */
	@RequestMapping(value = "/cinema", method = RequestMethod.GET)
	public String cinema(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Cinema");

		return "cinema";
	}


	/**
	 * Muestra la vista bio, pide el texto del titulo y la descripcion de la base de datos para mostrarlo,
	 * pide la foto correspondiente que hay en su carpeta en data.
	 */
	@RequestMapping(value = "/bio", method = RequestMethod.GET)
	public String bio(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Bio");

		// leemos los archivos que esten contenidos en la carpeta editorial...
		File foto = ContextInitializer.getFolder("bio");

		model.addAttribute("fotos", foto.list());

		if(entityManager.createNamedQuery("dameTextoBio").getResultList().size() != 0){

			FragBio f = (FragBio) entityManager.createNamedQuery("dameTextoBio").getSingleResult();

			model.addAttribute("titulo", f);
			model.addAttribute("texto", f);
		}

		return "bio";
	}


	/**
	 * Post de la vista bio, pide el texto del titulo y la descripcion de la base de datos para mostrarlo,
	 * coge el texto introducido por el admin para modificarlo y en caso de que no sea nulo, modifica el de la BBDD
	 * por el nuevo introducido.
	 * Pide la foto correspondiente que hay en su carpeta en data.
	 */
	@Transactional
	@RequestMapping(value = "/bio", method = RequestMethod.POST)
	public String bio(HttpServletRequest request, Model model, HttpSession session) {	

		String titulo = request.getParameter("nuevoTitulo");
		String texto= request.getParameter("nuevaDescripcion");

		if(entityManager.createNamedQuery("dameTextoBio").getResultList().size() != 0){

			FragBio f = (FragBio) entityManager.createNamedQuery("dameTextoBio").getSingleResult();

			model.addAttribute("titulo", f);
			model.addAttribute("texto", f);
		}

		FragBio f = (FragBio) entityManager.createNamedQuery("dameTextoBio").getSingleResult();

		if (texto != null && titulo !=null) {

			f.setTitulo(titulo);
			f.setTexto(texto);
			entityManager.persist(f);
		}
		else{ 

			if (titulo != null) {

				f.setTitulo(titulo);
				entityManager.persist(f);
			}

			if (texto != null) {

				f.setTexto(texto);
				entityManager.persist(f);
			}
		}

		return "bio";
	}	


	/**
	 * Muestra la vista contacto.
	 */
	@RequestMapping(value = "/contacto", method = RequestMethod.GET)
	public String contacto(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Contacto");

		return "contacto";
	}

	/**
	 * Post de contacto. Pide el contenido de los campos, si son nulos muestra un error.
	 */
	@RequestMapping(value = "/contacto", method = RequestMethod.POST)
	public String contacto(HttpServletRequest request, Model model, HttpSession session) {	
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String apellido = request.getParameter("apellido");
		String asunto = request.getParameter("asunto");

		if (nombre == null || email == null || apellido == null || asunto == null) {

			model.addAttribute("Error", "Rellene todos los campos");
		} 
		else {

		}

		return "contacto";
	}


	/**
	 * Muestra la vista citas y coge de la BBDD todas las citas y las manda a la vista en una variable (citas).
	 */
	@RequestMapping(value = "/citas", method = RequestMethod.GET)
	public String citas(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Citas");

		@SuppressWarnings("unchecked")
		ArrayList<Fecha> listaCitas = (ArrayList<Fecha>) entityManager.createNamedQuery("dameFechas").getResultList();			

		if (listaCitas.size() != 0) {

			model.addAttribute("citas", listaCitas);
		}

		return "citas";
	}


	/**
	 * Post de la vista citas. Coge la fechas de la web, las parsea, mira que no este ese rango
	 * ya reservado, es decir, que no se solapan fechas y en tal caso las almacena en la BBDD, 
	 * en caso negativo muestra un mensaje de error.
	 * Muestra las fechas para que los usuarios puedan ver cuales estan ocupadas.
	 */
	@Transactional
	@RequestMapping(value = "/citas", method = RequestMethod.POST)
	public String citas(HttpServletRequest request, Model model, HttpSession session) {	

		String fechaIni = request.getParameter("from");
		String fechaFin = request.getParameter("to");

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date parsed = null;
		Date parsed2 = null;

		try {

			parsed = format.parse(fechaIni);
			parsed2 = format.parse(fechaFin);
		} 
		catch (ParseException e) {

			e.printStackTrace();
		}

		Fecha f = new Fecha(new java.sql.Date(parsed.getTime()), new java.sql.Date(parsed2.getTime()), (User) session.getAttribute("user"));

		if (entityManager.createNamedQuery("fechasQueSolapan").setParameter("fechaInicialCita", new java.sql.Date(parsed.getTime())).setParameter("fechaFinalCita", new java.sql.Date(parsed2.getTime())).getResultList().size() == 0) {

			entityManager.persist(f);
		}
		else{

			model.addAttribute("errorFecha", "La fecha que intenta solicitar no se encuentra disponible");	
		}

		@SuppressWarnings("unchecked")
		ArrayList<Fecha> listaCitas = (ArrayList<Fecha>) entityManager.createNamedQuery("dameFechas").getResultList();			

		if (listaCitas.size() != 0) {

			model.addAttribute("citas", listaCitas);
		}

		return "citas";
	}


	/**
	 * Se emplea en el scrip de citas para eliminar con el boton x una cita.
	 */
	@RequestMapping(value = "/delFecha", method = RequestMethod.POST)
	@ResponseBody
	@Transactional // needed to allow DB change
	public ResponseEntity<String> removeDates(@RequestParam("id") int id,
			@RequestParam("csrf") String token, HttpSession session) {

		//		if (! isTokenValid(session, token)) {
		//			return new ResponseEntity<String>("Error: no such user or bad auth", HttpStatus.FORBIDDEN);
		//		} else 

		if (entityManager.createNamedQuery("delFecha").setParameter("idParam", id).executeUpdate() == 1) {

			return new ResponseEntity<String>("Ok: date " + id + " removed", HttpStatus.OK);
		} 
		else {

			return new ResponseEntity<String>("Error: no such user", HttpStatus.BAD_REQUEST);
		}
	}


	/**
	 * Checks the anti-csrf token for a session against a value
	 * Se emplea en el metodo de arriba, para el boton x de fecha, es algo de seguridad, pero no estamos
	 * seguros de lo que hace por eso no lo ponemos.
	 */
	static boolean isTokenValid(HttpSession session, String token) {
		Object t=session.getAttribute("csrf_token");
		return (t != null) && t.equals(token);
	}


	/**
	 * Muestra la vista registro.
	 */
	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String registro(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Registro");


		return "registro";
	}


	/**
	 * Post de la vista registro. Coge los datos de la web, si el nombre de usuario no existe ya,
	 * si no hay campos vaccio (nulos), si el pasword tiene mas de 4 caracteres y coincide con su comprobacion,
	 * se crea un nuevo usuario, se inserta en la BBD y se inicia sesion con el. Se redigire a index.
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
		User user = null;

		if (!noEstaRepe(nombreUsuario)) {

			model.addAttribute("error", "El alias introducido ya existe");
			return "registro";

		}else if (nombre == "" || apellidos == "" || email == "" || nombreUsuario == "" || password1 == "" || password2 == "") {

			model.addAttribute("error", "Rellene todos los campos");
			return "registro";

		}else if(password1.length() < 4){

			model.addAttribute("error", "Longitud de la password demasiado corta (min 4 caracteres)");
			return "registro";

		}else if (!password1.equals(password2) ){

			model.addAttribute("error", "No coinciden las passwords");
			return "registro";
		}
		else{
			//Si el nombre de usuario es (yohanaAdmin) se crea un administrador
			//se hace por comodidad.
			if (nombreUsuario.equalsIgnoreCase("yohanaAdmin")) {
				
				user = new User( nombre, apellidos, email , nombreUsuario, password1, "Admin");		
			} 
			else {
				
				user = new User( nombre, apellidos, email , nombreUsuario, password1, "user");	
			}

			entityManager.persist(user);
			session.setAttribute("user", user);
			return "redirect:/";
		}

		
	}

	/**
	 * Comprueba que el nombre de usuario no exista ya, se usa en registro.
	 */
	private boolean noEstaRepe(String alias) {

		return entityManager.createNamedQuery("userByLogin").setParameter("loginParam", alias).getResultList().size() == 0;
	}


	/**
	 * Muestra la vista logIn.
	 */
	@RequestMapping(value = "/logIn", method = RequestMethod.GET)
	public String logIn(Locale locale, Model model) {	
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("pageTitle", "Log In");

		return "logIn";
	}


	/**
	 * Post de la vista logIn. Coge los datos de la pagina, busca si el usuario existe, en caso afirmativo,
	 * mira si la contraseña coincide y en tal caso crea la sesion.Si algo falla muestra error. Redirige a index.
	 */
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

			if (!u.isPassValid(formPass)) {

				model.addAttribute("error", "Error en usuario o contrasena");
				return "logIn";
			}
			else{

				session.setAttribute("user", u);
				return "redirect:/";
			}
		}
		else{
			
			return "logIn";
		}

		
	}


	/**
	 * Muestra la vista logOut. Cierra la sesion. Redirige a index.
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("User '{}' logged out", session.getAttribute("user"));
		session.invalidate();

		return "redirect:/";
	}


	/**
	 * Método empleado para subir las fotos a la web
	 * @param id of user 
	 * @param photo to upload
	 * @return
	 */
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public @ResponseBody String handleFileUpload(@RequestParam("photo") MultipartFile photo,@RequestParam("id") String id){

		if (!photo.isEmpty()) {

			try {

				byte[] bytes = photo.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(ContextInitializer.getFile("user", id)));

				stream.write(bytes);
				stream.close();
				return "You successfully uploaded " + id + " into " + ContextInitializer.getFile("user", id).getAbsolutePath() + "!";
			} 
			catch (Exception e) {

				return "You failed to upload " + id + " => " + e.getMessage();
			}
		} 
		else {

			return "You failed to upload a photo for " + id + " because the file was empty.";
		}
	}


	/**
	 * Returns a users' photo
	 * @param id id of user to get photo from
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/photo", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] userPhoto(@RequestParam("folder") String folder, @RequestParam("id") String id) throws IOException {
		File f = ContextInitializer.getFile(folder, id);
		InputStream in = null;

		if (f.exists()) {

			in = new BufferedInputStream(new FileInputStream(f));
		}
		else {

			in = new BufferedInputStream(this.getClass().getClassLoader().getResourceAsStream("unknown-user.jpg"));
		}

		return IOUtils.toByteArray(in);
	}


}
