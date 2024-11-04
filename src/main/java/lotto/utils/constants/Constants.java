package lotto.utils.constants;

public enum Constants {
    DELIMITER(",");

    private final String delimiter;

    Constants(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
