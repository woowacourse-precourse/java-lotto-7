package lotto;

public class Application {
    public static void main(String[] args) {

        IOController ioController = new IOController();
        Validator validator = new Validator();
        Parser parser = new Parser();

        Executor executor = new Executor(ioController, validator, parser);
        executor.run();
    }
}
