package lotto.value;

public record LottoNumber(Integer number) {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    public LottoNumber {
        if (number < MIN_VALUE || MAX_VALUE < number) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1~45입니다.");
        }
    }

}
