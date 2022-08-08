package BlockChain;

import java.util.ArrayList;

import BlockChain.Block;
import com.google.gson.*;

public class NoobChain {

    public static int difficulty = 1;

    public static ArrayList<Block> blockChain = new ArrayList<>();

    public static void main(String[] args) {
        // adds the block chain to the lists

        blockChain.add(new Block("Hi im the first block", "0"));
        System.out.println("Trying to Mine block 1... ");
        blockChain.get(0).mineBlock(difficulty);

        blockChain.add(new Block("Yo im the second block",blockChain.get(blockChain.size()-1).hash));
        System.out.println("Trying to Mine block 2... ");
        blockChain.get(1).mineBlock(difficulty);

        blockChain.add(new Block("Hey im the third block",blockChain.get(blockChain.size()-1).hash));
        System.out.println("Trying to Mine block 3... ");
        blockChain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is Valid: " + isChainValid());



        String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println(blockChainJson);

    }

    public static Boolean isChainValid()
    {
        Block currentBlock;
        Block previousBlock;

        // Loop through the blockChain to check hashes
        for (int i = 1; i < blockChain.size(); i++) {
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i - 1);

            // compare registered hash and caculate hash
            if(!currentBlock.hash.equals(currentBlock.calculatedHash()) ){
                System.out.println("Current hashes are not equal");
                return false;
            }
            //compare if previous  and the register hash
            if(!previousBlock.hash.equals(currentBlock.calculatedHash()) ){
                System.out.println("Previous hashed are not equal");
                return false;
            }

        }
        return true;
    }

}
