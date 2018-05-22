import java.security.*;

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
