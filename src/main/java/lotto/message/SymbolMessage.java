package lotto.message;

public enum SymbolMessage implements Message {

    SYMBOL_BASIC_DELIMITER(", "),
    SYMBOL_NEW_LINE("\n")
    ;

    private final String message;

    SymbolMessage(String message) {
        this.message = message;
    }

    @Override
    public String message() {
        return message;
    }
}
