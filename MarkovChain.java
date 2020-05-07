import java.util.Random;
import java.util.StringTokenizer;

public class MarkovChain {

    public String source;
    public String[] uniqueWords;
    public LinkedList[] appearances;

    public MarkovChain(){
        source = "Cloudy Cloudy Cloudy Cloudy Sunny Cloudy Cloudy Cloudy Sunny Cloudy Cloudy Sunny Cloudy Cloudy Cloudy Cloudy Sunny Cloudy Cloudy Sunny Sunny Sunny Cloudy Sunny Cloudy Cloudy Cloudy Cloudy Sunny Cloudy Cloudy Cloudy Cloudy Cloudy Cloudy Sunny Cloudy Cloudy Cloudy Cloudy Cloudy Cloudy Sunny Cloudy Sunny Cloudy Cloudy Sunny Rainy Sunny Cloudy Sunny Sunny Sunny Cloudy Cloudy Cloudy Cloudy Cloudy Sunny Sunny Cloudy Cloudy Sunny Cloudy Sunny Sunny Sunny Cloudy Sunny Cloudy Cloudy Cloudy Sunny Sunny Cloudy Sunny Cloudy Cloudy Sunny Sunny Rainy Cloudy Cloudy Sunny Sunny Rainy Cloudy Rainy Cloudy Cloudy Sunny Cloudy Cloudy Cloudy Sunny Sunny Cloudy Cloudy Cloudy Cloudy Cloudy Rainy Cloudy Cloudy Cloudy Cloudy Cloudy Sunny Sunny Rainy Cloudy Cloudy Rainy Sunny Rainy Rainy Cloudy Cloudy Cloudy";
        uniqueWords = new String[]{"Sunny", "Cloudy", "Rainy"};
        appearances = new LinkedList[3];

        //Load sequence into appearances
        for(int i = 0; i < appearances.length; i++){
            appearances[i] = new LinkedList();
        }

        String previousToken = "";
        String currentToken = "";

        StringTokenizer tokens = new StringTokenizer(source);
        previousToken = tokens.nextToken();
        currentToken = tokens.nextToken();
        while(tokens.hasMoreTokens()){
            appearances[indexInArray(uniqueWords, previousToken)].add(currentToken);
            previousToken = currentToken;
            currentToken = tokens.nextToken();
        }
    }

    public void generateTestChain(int length){
        Random random = new Random();
        int currentIndex = random.nextInt(uniqueWords.length);
        String result = uniqueWords[currentIndex] + " ";
        for(int i = 0; i < length; i++){
            int appearanceIndex = random.nextInt(appearances[currentIndex].size());
            result += appearances[currentIndex].get(appearanceIndex) + " ";
            currentIndex = indexInArray(uniqueWords, appearances[currentIndex].get(appearanceIndex));
        }
        System.out.println(result);
    }

    public int indexInArray(String[] arr, String str){
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(str)){
                return i;
            }
        }
        return -1;
    }
}
