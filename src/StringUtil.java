import java.security.MessageDigest;

/**
 * The StringUtil class is a helper class that generates a signature hash.
 * 
 * @author Tim stelter
 * @version v51618
 * 
 */
public class StringUtil {
	
	/**
	 * This method applies a hash function to a given str.
	 * @param str 
	 * @return a new hex string
	 */
	public static String applySha(String str) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(str.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			String hex = "";
			for(int i =0; i < hash.length; i++) {
				hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
					hexString.append(hex);
			}
			return hexString.toString();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
