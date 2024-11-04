package lotto.parser;

public enum ParserConfig {

    DEFAULT(",");

    private final String delimiter;

    ParserConfig(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
