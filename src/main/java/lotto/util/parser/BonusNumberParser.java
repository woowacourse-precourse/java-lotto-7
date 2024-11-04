package lotto.util.parser;

public class BonusNumberParser {
    public static int toIntStringBonusNumberParser(String bonusNumber) throws IllegalArgumentException {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력 가능합니다.");
        }
    }
}