import edu.princeton.cs.algs4.StdIn;

import java.io.IOException;

public class MarkovChainRunner {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Weather Generator 2.1.0");
        MarkovChain weather = new MarkovChain("weather_training.txt");

        System.out.println("Please select a weather to start forecast");
        System.out.println("1) Sunny");
        System.out.println("2) Cloudy");
        System.out.println("3) Rainy");
        int option = StdIn.readInt() - 1;

        System.out.println("Please enter the number of days for forecast");
        int days = StdIn.readInt();

        weather.predict(option, days);
    }

}
