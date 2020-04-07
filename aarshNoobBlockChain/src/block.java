
import java.util.Date;

public class block {
	public String hashCode;
	public String preHashCode;
	public String data;
	private long timeStamp;
	private int nonce;
	
	//constructor for block
	public block(String data,String preHashCode) {
			this.data = data;
			this.preHashCode = preHashCode;
			this.timeStamp = new Date().getTime();	
			this.hashCode = calculateHashCode();
	}
	//following function for calculating the hash.
public String calculateHashCode() {
		String calculatedHashCode = stringUtil.applySHA256( 
				preHashCode +
				Long.toString(timeStamp) +
				Integer.toString(nonce) + 
				data 
				);
		return calculatedHashCode;	
}

public void mineChainBlock(int difficulty) {
	String target = stringUtil.getDifString(difficulty); //Create a string with difficulty * "0" 

	while(!hashCode.substring( 0, difficulty).equals(target)) {
		nonce ++;
		hashCode = calculateHashCode();
	
	}
	System.out.println("Block No Mined!!! : " + hashCode);

}
}






