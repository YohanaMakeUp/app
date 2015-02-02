package es.fdi.iw.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@NamedQueries({
	@NamedQuery(name="userByLogin",
			query="select u from User u where u.alias = :loginParam"),

			@NamedQuery(name="dameTodo",
			query="select u from User u")
})

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Version
	private int version;

	private String role;

	private String alias;

	private String email;

	private String nombre;

	private String apellidos;

	private String hashedAndSalted;
	
	private String salt;


	@OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
	private List<Fecha> fechas;

	public User() {}

	public User(String nombre, String apellidos,String email ,String alias, String password, String role) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.role = role;
		this.alias = alias;
		this.email = email;
		
		Random r = new Random();
		
		// generate new, random salt; build hashedAndSalted
		byte[] saltBytes = new byte[16];
		r.nextBytes(saltBytes);
		this.salt = byteArrayToHexString(saltBytes);
		this.hashedAndSalted = generateHashedAndSalted(password, this.salt);

	}

	public boolean isPassValid(String pass) {
		return generateHashedAndSalted(pass, this.salt).equals(hashedAndSalted);		
	}
	
	/**
	 * Generate a hashed&salted hex-string from a user's pass and salt
	 * @param pass to use; no length-limit!
	 * @param salt to use
	 * @return a string to store in the BD that does not reveal the password even
	 * if the DB is compromised. Note that brute-force is possible, but it will
	 * have to be targeted (ie.: use the same salt)
	 */
	public static String generateHashedAndSalted(String pass, String salt) {
		byte[] saltBytes = hexStringToByteArray(salt);
		byte[] passBytes = pass.getBytes();
		byte[] toHash = new byte[saltBytes.length + passBytes.length];
		System.arraycopy(passBytes, 0, toHash, 0, passBytes.length);
		System.arraycopy(saltBytes, 0, toHash, passBytes.length, saltBytes.length);
		return byteArrayToHexString(hash(toHash));
	}	

	/**
	 * Converts a byte array to a hex string
	 * @param b converts a byte array to a hex string; nice for storing
	 * @return the corresponding hex string
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<b.length; i++) {
			sb.append(Integer.toString((b[i]&0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
	
	/**
	 * Converts a hex string to a byte array
	 * @param hex string to convert
	 * @return equivalent byte array
	 */
	public static byte[] hexStringToByteArray(String hex) {
		byte[] r = new byte[hex.length()/2];
		for (int i=0; i<r.length; i++) {
			String h = hex.substring(i*2, (i+1)*2);
			r[i] = (byte)Integer.parseInt(h, 16);
		}
		return r;
	}
	
	/**
	 * Returns the SHA-1 of a byte array
	 * @return
	 */
	public static byte[] hash(byte[] bytes) {
		MessageDigest md = null;
	    try {
	        md = MessageDigest.getInstance("SHA-1");
	    } catch(NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } 
	    return md.digest(bytes);
	}

	
	public String getHashedAndSalted() {
		return hashedAndSalted;
	}

	public void setHashedAndSalted(String hashedAndSalted) {
		this.hashedAndSalted = hashedAndSalted;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public List<Fecha> getFechas() {
		return fechas;
	}

	public void setFechas(List<Fecha> fechas) {
		this.fechas = fechas;
	}

	public String getRole() {
		return role;
	}

	public String getNombreUsuario() {
		return alias;
	}

	public Integer getId() {
		return id;
	}

	public void Integer(Integer id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.alias = nombreUsuario;
	}



}
