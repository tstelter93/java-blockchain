
/**
 * Program entry point.
 * 
 * @author Tim Stelter
 * @version v51618
 *
 */
public class Main {

	public static void main(String[] args) {
		Block firstBlock = new Block("First block", "0");
		System.out.println("Hash for block 1 : " + firstBlock.getHash());
		
		Block secondBlock = new Block("Second block", firstBlock.getHash());
		System.out.println("Hash for block 2 : " + secondBlock.getHash());
		
		Block thirdBlock = new Block("Third block", secondBlock.getHash());
		System.out.println("Hash for block 3 : " + thirdBlock.getHash());
	}

}
