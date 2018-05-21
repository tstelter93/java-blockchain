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
	private int nonce;
	
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
				Integer.toString(nonce) +
				data);
		
		return calculatedHash;
	}
	
	/**
	 * This method mines a block given a difficulty of the block.
	 * @param difficulty the difficult of the block to be mined (the number of zeros they must solve for)
	 */
	public void mineBlock(int difficulty) {
		String str = new String(new char[difficulty]).replace('\0', '0');
		
		while(!hash.substring(0, difficulty).equals(str)) {
			nonce++;
			hash = calculateHash();
		}
		System.out.println("Block mined! : " + hash);
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
