import java.util.Random;

public class State {

    //Name of the state for output
    public String name;

    //Array for all the states in the Markov chain
    //Index 0 is Sunny
    //Index 1 is Cloudy
    //Index 2 is Rainy
    public State[] nextStates;

    //Array for probability
    public int[] nextStatesAppearances;

    //Constructor for the state
    //Initializes array
    public State(String name){
        this.name = name;
        this.nextStates = new State[3];
        this.nextStatesAppearances = new int[3];
    }

    //Get the next state based on probability stored in the array
    public State getNextState(){
        //Generate a random number in range of the total combined sum of the appearances in the array
        Random random = new Random();
        int next = random.nextInt(getArrayTotal(nextStatesAppearances)) + 1;

        //Compare if the value is smaller than the 0 index value, select that state if true
        //If previous returns false, then subtract the value from the 0 index and compare it with the 1 index
        //Return the third state if previous two check both return false
        if(next <= nextStatesAppearances[0]){
            return nextStates[0];
        }
        else{
            next -= nextStatesAppearances[0];
            if(next <= nextStatesAppearances[1]){
                return nextStates[1];
            }
            else{
                return nextStates[2];
            }
        }
    }

    //Helper methods
    //Get the total sum of the numbers in an array
    private int getArrayTotal(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

}
