import java.util.Random;

public class Entity {

    public String word;
    public LinkedList nextWord;

    public Entity(String word){
        this.word = word;
        this.nextWord = new LinkedList();
    }

    public int getNextWord(){
        Random random = new Random();
        return nextWord.get(random.nextInt(nextWord.size()));
    }

}
