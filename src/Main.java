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
		
		// Json builder
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println(blockchainJson);
	}

}
