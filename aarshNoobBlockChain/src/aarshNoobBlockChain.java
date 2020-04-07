import java.util.ArrayList;

public class aarshNoobBlockChain {

	public static ArrayList<block> mineChain = new ArrayList<block>();
	public static int difficulty = 6;
	public static int i=0; //declared it for while loop
	
	public static void main(String args[]) {
		
		newBlock(new block("This is IFT 520: Advance Information Security","0"));
	
		newBlock(new block("Arizona State University",mineChain.get(mineChain.size()-1).hashCode));
	
		newBlock(new block("Aarsh Pandit",mineChain.get(mineChain.size()-1).hashCode));
	
		newBlock(new block("Jim Helm",mineChain.get(mineChain.size()-1).hashCode));	
	
		
		if(chainValidation() == true ) {
			System.out.println("\nBlockchain is Valid" );
		}
		else {
			System.out.println("\nBlockchain is not Valid" );

		}

		String blockchainJson = stringUtil.getJson(mineChain);
		System.out.println("\nThe Aarsh' block chain: ");
		System.out.println(blockchainJson);
		System.out.println("-----------------------------------------------------------------------------------------------------");
	}
public static Boolean chainValidation() {
 	block cBlock;  //current block
	block preBlock; //previous block
	String targetHash = new String(new char[difficulty]).replace('\0', '0');


//while(i < mineChain.size())
//...Tried the while (exit control loop here) but didnt work out. as it is exit control loop...
	
	
	
	//......The following for loop checks the current and previous hashCode are equal or not...
	
	for(int i = 1; i < mineChain.size() ; i++) {
			cBlock = mineChain.get(i);
		preBlock = mineChain.get(i-1);
	
		if(!cBlock.hashCode.equals(cBlock.calculateHashCode()) ){
			System.out.println("Current Hashes not equal");			
			return false;
		}
	
		if(!preBlock.hashCode.equals(cBlock.preHashCode) ) {
			System.out.println("Previous Hashes not equal");
			return false;
		}
		//check if hash is solved
		if(!cBlock.hashCode.substring( 0, difficulty).equals(targetHash)) {
			System.out.println("This block hasn't been mined");
			return false;
		}
		
	}
	return true;	
	
}

public static void newBlock(block newBlockParam) {
	newBlockParam.mineChainBlock(difficulty);
	mineChain.add(newBlockParam);
}
}

