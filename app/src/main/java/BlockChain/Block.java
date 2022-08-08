package BlockChain;

import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private String data; // are data is going to be a simple message
    private long timeStamp; // number of milliseconds since 1970
    private int coins;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculatedHash();
    }


    public String calculatedHash()
    {
        return StringUtils.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        data
        );
    }

    public void mineBlock(int difficulty) {
        String target = new String( new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while(!hash.substring(0,difficulty).equals(target)) {
            coins++;
            hash = calculatedHash();

        }
        System.out.println("block Mined!!!! : " + hash);
    }
}
