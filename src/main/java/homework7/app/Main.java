package homework7.app;

public class Main {
    public static void main(String[] args) {
        getOutput(Corrector.handleData(DataProvider.getData()));
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
