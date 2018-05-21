import java.util.ArrayList;
import com.google.gson.*;

/**
 * Program entry point.
 * 
 * @author Tim Stelter
 * @version v51618
 *
 */
public class Main {

	/*Protected class BlockChain*/
	protected static ArrayList<Block> blockchain = new ArrayList<Block>();
	
	public static final int DIFFICULTY = 5;
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		// Create blocks and add to arraylist
		Block firstBlock = new Block("First block", "0");
		blockchain.add(firstBlock);
		
		Block secondBlock = new Block("Second block", firstBlock.getHash());
		blockchain.add(secondBlock);
		
		Block thirdBlock = new Block("Third block", secondBlock.getHash());
		blockchain.add(thirdBlock);
		
		//Mining the blockchain
		for(int i = 0; i < blockchain.size(); i++) {
			System.out.println("Trying to mine block " + (i + 1) + "... ");
			blockchain.get(i).mineBlock(DIFFICULTY);
		}
		
		System.out.print("\nBlockchain is Valid: " + isChainValid());
		
		// Json builder
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
	}
	
	/**
	 * This method tests if the chain is valid.
	 * @return returns true if stored hash is equal to registered (calculated) hash 
	 */
	public static Boolean isChainValid() {
		
		Block currentBlock;
		Block previousBlock;
		String hashTarget = new String(new char[DIFFICULTY]).replace('\0', '0');
		
		// start variable i at 1 to avoid array out of bounds
		for(int i = 1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i - 1);
			
			// Compare the current blocks stored hash value with a its registered calculated hash
			if(!currentBlock.getHash().equals(currentBlock.calculateHash())) {
				System.out.println("Current hash does not equal.");
				return false;
			}
			
			// comparing previous hash with registered previous hash
			if(!previousBlock.getHash().equals(currentBlock.getPrevHash())) {
				System.out.println("Previous hash does not equal.");
				return false;
			}
			
			// checking if hash is solved
			if(!currentBlock.getHash().substring(0, DIFFICULTY).equals(hashTarget)) {
				System.out.println("Current hash does not equal.");
				return false;
			}
		}
		
		return true;
	}

}
