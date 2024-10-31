package lotto;

public class Parser {
    public static int parseAmount(String input) {
        Validator.validateAmount(input);
        return Integer.parseInt(input);
    }
}