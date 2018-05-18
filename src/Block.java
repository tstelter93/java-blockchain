import java.util.Date;

/**
 * The Block class is used to generate block objects that 
 * encapsulate private data, a prior hash, and a timestamp.
 * 
 * @author Tim Stelter
 * @version v51618
 * 
 */
public class Block {

	private String hash;
	private String previousHash;
	private String data;
	private long timeStamp;
	
	/**
	 * Block constructor
	 * @param data data that is encapsulated in a given block.
	 * @param previousHash previous hash of a prior block in the blockchain.
	 */
	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}
	
	/**
	 * This method generates a hash
	 * @return a hash value
	 */
	public String calculateHash() {
		String calculatedHash = StringUtil.applySha(
				previousHash +
				Long.toString(timeStamp) +
				data);
		
		return calculatedHash;
	}
	
	/**
	 * Getter for the the hash.
	 * @return returns the hash value.
	 */
	public String getHash() {
		return hash;
	}
	
	/**
	 * Getter for previous hash value.
	 * @return Returns the previous hash.
	 */
	public String getPrevHash() {
		return previousHash;
	}
}
