package lotto.domain.converter;

public class Converter {

    public int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
        }
    }
}
