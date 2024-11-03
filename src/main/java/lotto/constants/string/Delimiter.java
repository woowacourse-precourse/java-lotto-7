package lotto.constants.string;

import lotto.constants.Constants;

public enum Delimiter implements Constants<String> {

    DEFAULT(",");

    private final String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String getInstance() {
        return delimiter;
    }
}
