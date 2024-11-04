package lotto.domain;

public class Bonus {

    private static final String SHOULD_INTEGER_MESSAGE = "[ERROR] 보너스 넘버를 숫자로 입력해주세요.";

    private final int number;

    public Bonus(String rawBonusNumber) {
        int bonusNumber = toInt(rawBonusNumber);
        this.number = bonusNumber;
    }

    private int toInt(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(SHOULD_INTEGER_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }
}
