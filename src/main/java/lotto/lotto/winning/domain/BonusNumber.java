package lotto.lotto.winning.domain;

import lotto.util.Convertor;

public class BonusNumber {
    private final int number;
    private BonusNumber(int number) {
        this.number = number;
    }
    public static BonusNumber of(String input) {
        int number = Convertor.stringToInt(input);
        return new BonusNumber(number);
    }
    public int getNumber() {
        return number;
    }
    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
