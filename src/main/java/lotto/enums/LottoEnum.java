package lotto.enums;

public enum LottoEnum {
    MIN_LOTTO_RANGE(1),
    MAX_LOTTO_RANGE(45),
    WINNING_NUMBER_COUNT(6);

    int number;

    LottoEnum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}