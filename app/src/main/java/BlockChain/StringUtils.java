package BlockChain;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {
    //Applies Sha256 to a string and returns the result.

    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // applied sha to are input
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {

                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);

            }
            return hexString.toString();


        } catch (Exception exception){
            throw new RuntimeException(exception);
        }
    }


}
