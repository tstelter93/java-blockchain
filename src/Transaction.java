import java.security.*;
import java.util.ArrayList;

/**
 * 
 * @author Tim Stelter
 *
 */
public class Transaction {

	private String transactionId;
	private PublicKey sender;
	private PublicKey reciepient;
	private float value;
	private byte[] signature;
	
	private ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
	private ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();
	
	private static int sequence = 0;
	
	/**
	 * Constructor
	 * @param from
	 * @param to
	 * @param value
	 * @param inputs
	 */
	public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs) {
		this.sender = from;
		this.reciepient = to;
		this.value = value;
		this.inputs = inputs;
	}
	
	// Need to understand this code before uncommenting it.
	// This Calculates the transaction hash (which will be used as its Id)
//	private String calulateHash() {
//		sequence++; //increase the sequence to avoid 2 identical transactions having the same hash
//		return StringUtil.applySha256(
//				StringUtil.getStringFromKey(sender) +
//				StringUtil.getStringFromKey(reciepient) +
//				Float.toString(value) + sequence
//				);
//	}
	
}
