import java.util.Date;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
    String data;
    String hash;
    String preHash;
    long timestamp;
    Block next;

    Block(String data,String preHash){
        this.data = data;
        this.preHash = preHash;
        this.timestamp = new Date().getTime();
        this.hash = getSHA(this.data+this.timestamp+this.preHash);
        this.next = null;
    }

    public String getSHA(String input) {

        try {


            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] messageDigest = md.digest(input.getBytes());


            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown"
                    + " for incorrect algorithm: " + e);

            return null;
        }
    }

}
