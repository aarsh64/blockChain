import java.security.MessageDigest;
import com.google.gson.GsonBuilder;

public class stringUtil {
		public static String applySHA256(String input) {
			try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			
			byte[] hashCode = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hex16String = new StringBuffer();
			for (int i = 0; i< hashCode.length; i++) {
					String hex = Integer.toHexString(0xff & hashCode[i]);
					if(hex.length() == 1) hex16String.append('0');
					hex16String.append(hex);
				
			}
			return hex16String.toString();
			}
			catch(Exception e){
				System.out.println("ERROR!!!");
				throw new RuntimeException(e);
			}
		}
		
		public static String getJson(Object o) {
				return new GsonBuilder().setPrettyPrinting().create().toJson(o);
		}
		
		public static String getDifString(int difficulty) {
			return new String(new char[difficulty]).replace('\0', '0');
		}
}
