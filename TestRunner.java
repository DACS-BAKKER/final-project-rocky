import java.io.IOException;

public class TestRunner {

    public static void main(String[] args) throws IOException {
        MarkovChain markovChain = new MarkovChain();
        markovChain.generateTestChain(20);
    }

}
