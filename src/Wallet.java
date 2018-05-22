import java.security.*;
import java.security.spec.ECGenParameterSpec;

/**
 * This class functions like a wallet for cryptocurrency.
 * 
 * @author Tim Stelter
 * @version v52218
 */
public class Wallet {

	private PrivateKey privateKey;
	private PublicKey publicKey;
	
	/**
	 * Constructor for the Wallet Class.
	 */
	public Wallet() {
		generateKeyPair();
	}
	
	/**
	 * Generates a public and private key pair based on Elliptic-curve cryptograhpy.
	 * https://en.wikipedia.org/wiki/Elliptic-curve_cryptography
	 */
	public void generateKeyPair() {
		try {
			// Setup
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");  // What do these parameters mean?
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			
			// Elliptic-curve KeyPir spec
			ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
			
			// Initialize the key generator and generate a KeyPair
			keyGen.initialize(ecSpec, random);
			KeyPair keyPair = keyGen.generateKeyPair();
			
			// Set the public and private keys from the keyPair
			privateKey = keyPair.getPrivate();
			publicKey = keyPair.getPublic();
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Get the private key.
	 * @return The private key for the wallet.
	 */
	public PrivateKey getPrivateKey() {
		return privateKey;
	}
	
	/**
	 * Get the public key.
	 * @return The public key for the wallet.
	 */
	public PublicKey getPublicKey() {
		return publicKey;
	}
	
}
