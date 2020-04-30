import java.util.Random;

public class MarkovChain {

    public Entity[] storageArray;

    public MarkovChain(){
        storageArray = new Entity[4];
        storageArray[0] = new Entity("Sunny");
        storageArray[0].nextWord.add(1);
        storageArray[0].nextWord.add(2);
        storageArray[1] = new Entity("Cloudy");
        storageArray[1].nextWord.add(0);
        storageArray[1].nextWord.add(3);
        storageArray[2] = new Entity("Rain");
        storageArray[2].nextWord.add(0);
        storageArray[2].nextWord.add(1);
        storageArray[3] = new Entity("Snow");
        storageArray[3].nextWord.add(2);
        storageArray[3].nextWord.add(3);
    }

    public void generateTestChain(int length){
        int currentIndex = 0;
        for(int i = 0; i < length; i++){
            System.out.println(storageArray[currentIndex].word);
            currentIndex = storageArray[currentIndex].getNextWord();
        }
    }
}
