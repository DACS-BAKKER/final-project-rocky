import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MarkovChain {

    private State sunny;
    private State cloudy;
    private State rainy;

    //Constructor that creates a Markov chain from a file
    public MarkovChain(String filename) throws IOException {
        //Set up the States
        this.sunny = new State("Sunny");
        this.cloudy = new State("Cloudy");
        this.rainy = new State("Rainy");

        //Sunny at index 0
        //Cloudy at index 1
        //Rainy at index 2
        sunny.nextStates[0] = sunny;
        sunny.nextStates[1] = cloudy;
        sunny.nextStates[2] = rainy;
        cloudy.nextStates[0] = sunny;
        cloudy.nextStates[1] = cloudy;
        cloudy.nextStates[2] = rainy;
        rainy.nextStates[0] = sunny;
        rainy.nextStates[1] = cloudy;
        rainy.nextStates[2] = rainy;

        //Reading weather data from text file
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String data = reader.readLine();
        reader.close();

        //Finish initialization of the states by reading the data with a tokenizer
        StringTokenizer tokens = new StringTokenizer(data);
        String previous = tokens.nextToken();
        String current = tokens.nextToken();
        while(tokens.hasMoreTokens()){
            if(previous.equals("S")){

                if(current.equals("S")){
                    sunny.nextStatesAppearances[0] = sunny.nextStatesAppearances[0] + 1;
                }
                else if(current.equals("C")){
                    sunny.nextStatesAppearances[1] = sunny.nextStatesAppearances[1] + 1;
                }
                else if(current.equals("R")){
                    sunny.nextStatesAppearances[2] = sunny.nextStatesAppearances[2] + 1;
                }

                previous = current;
                current = tokens.nextToken();
            }
            else if(previous.equals("C")){

                if(current.equals("S")){
                    cloudy.nextStatesAppearances[0] = cloudy.nextStatesAppearances[0] + 1;
                }
                else if(current.equals("C")){
                    cloudy.nextStatesAppearances[1] = cloudy.nextStatesAppearances[1] + 1;
                }
                else if(current.equals("R")){
                    cloudy.nextStatesAppearances[2] = cloudy.nextStatesAppearances[2] + 1;
                }

                previous = current;
                current = tokens.nextToken();
            }
            else if(previous.equals("R")){

                if(current.equals("S")){
                    rainy.nextStatesAppearances[0] = rainy.nextStatesAppearances[0] + 1;
                }
                else if(current.equals("C")){
                    rainy.nextStatesAppearances[1] = rainy.nextStatesAppearances[1] + 1;
                }
                else if(current.equals("R")){
                    rainy.nextStatesAppearances[2] = rainy.nextStatesAppearances[2] + 1;
                }

                previous = current;
                current = tokens.nextToken();
            }
        }
    }

    //Generate a chain of weather
    //Sunny first is 0
    //Cloudy first is 1
    //Rainy first is 2
    public void predict(int first, int days){
        //Select starting State
        //Initialized to sunny to prevent errors in the for loop
        State current = sunny;
        if(first == 1){
            current = cloudy;
        }
        else if(first == 2){
            current = rainy;
        }

        //Generate chain for the specified length
        for(int i = 0; i < days; i++){
            System.out.print(current.name + " ");
            current = current.getNextState();
        }
    }

}
