package lotto.model;

public class LottoBonusNumber {
    private final int number;

    public LottoBonusNumber(String number) {
        this.number = parseNumber(number);
        validate();
    }

    public int getNumber() {
        return number;
    }

    private void validate() {
        if (isOutOfRangeNumber()) {
            throw new IllegalArgumentException("1 ~ 45 사이의 중복되지 않은 자연수이어야 합니다.");
        }
    }

    private boolean isOutOfRangeNumber() {
        if (number < 1 || number > 45) {
            return true;
        }
        return false;
    }

    private Integer parseNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1 ~ 45 사이의 중복되지 않은 자연수이어야 합니다.");
        }
    }
}
