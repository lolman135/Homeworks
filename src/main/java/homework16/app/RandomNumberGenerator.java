package homework16.app;

public class RandomNumberGenerator {

    public static int generateRandomNumber(int minVal, int maxVal){
        return (int) (Math.random() * (maxVal - minVal + 1)) + minVal;
    }
}
