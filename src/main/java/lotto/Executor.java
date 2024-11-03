package lotto;

public class Executor {
    IOController ioController;
    Validator validator;
    Parser parser;

    Executor(IOController ioController, Validator validator, Parser parser) {
        this.ioController = ioController;
        this.validator = validator;
        this.parser = parser;
    }
}
