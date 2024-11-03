package lotto.util;

public class NumberParserFactory {

    public NumberParser createNumberParser() {
        NumberConverter numberConverter = new DefaultNumberConverter();
        return new NumberParserWithComma(numberConverter);
    }
}
