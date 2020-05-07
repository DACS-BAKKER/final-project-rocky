import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class DataReader {

    public String source;
    public String[] uniqueWords;
    public LinkedList[] appearances;

    public DataReader(String filename) throws IOException {
        //Reading the data file into a string
        source = "";
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String currentLine = reader.readLine();
        while(currentLine != null){
            source += currentLine + " ";
            currentLine = reader.readLine();
        }
        reader.close();

        //Count unique words
        String unique = " ";
        int uniqueWordCount = 0;
        StringTokenizer tokens = new StringTokenizer(source, " \t\n\r\f,.:;?!()[]'\"");
        String currentToken = tokens.nextToken();
        while(tokens.hasMoreTokens()){
            if(unique.indexOf(" " + currentToken + " ") == -1){
                unique += currentToken + " ";
                uniqueWordCount++;
            }
            currentToken = tokens.nextToken();
        }

        //Prepare arrays for Markov chain
        this.uniqueWords = new String[uniqueWordCount];
        int uniqueIndex = 0;

        String previous = "";
        String current = "";

        tokens = new StringTokenizer(source, " \t\n\r\f,.:;?!()[]'\"");
        currentToken = tokens.nextToken();
        while(tokens.hasMoreTokens()){
            if(!contains(uniqueWords, currentToken)){
                uniqueWords[uniqueIndex] = currentToken;
                uniqueIndex++;
            }
        }

        System.out.println(uniqueWords.toString());
    }

    private boolean contains(String[] arr, String str){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null && arr[i].equals(str)){
                return true;
            }
        }
        return false;
    }

}
