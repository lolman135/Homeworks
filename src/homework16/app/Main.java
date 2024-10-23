package homework16.app;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    private static String testString = "Omnis immundus spiritus";

    public static void main(String[] args) {

        MathOperation add = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a+b;
            }
        };
        System.out.println(add.operate(3, 12));

        StringManipulator manipulator = str -> str.toUpperCase();
        String changedString = manipulator.convertToUpperCase(testString);
        System.out.println(changedString);

        Function<String, Integer> upperCaseCounter = StringListProcessor::countUpperCase;
        System.out.println(upperCaseCounter.apply(changedString));//Here you can insert other String

        Supplier<Integer> randomInteger = () -> RandomNumberGenerator.generateRandomNumber(1, 100);
        System.out.println(randomInteger.get());
    }
}
