import javax.xml.crypto.Data;
import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private String data; // are data is going to be a simple message
    private long timeStamp; // number of milliseconds since 1970

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculatedHash();
    }


    public String calculatedHash()
    {
        String calculatedhash =StringUtils.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        data
        );
        return calculatedhash;
    }
}
