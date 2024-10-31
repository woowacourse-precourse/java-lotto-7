package lotto;

public class Bonus extends LottoNumber {

    private final int number;

    public Bonus(int number) {
        validateBound(number);
        this.number = number;
    }
}
