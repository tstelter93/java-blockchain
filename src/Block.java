import java.util.Date;

/**
 * The Block class is used to generate block objects that 
 * encapsulate private data, a prior hash, and a timestamp.
 * 
 * @author Tim Stelter
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
	}
	
}
