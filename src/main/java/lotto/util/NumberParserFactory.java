package lotto.util;

public class NumberParserFactory {

    public NumberParserWithComma createNumberParser() {
        NumberConverter numberConverter = new NumberConverter();
        return new NumberParserWithComma(numberConverter);
    }
}
