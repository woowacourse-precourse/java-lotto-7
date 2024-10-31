package lotto;

public class LottoNumber {
    private static final int MINIMUM_NUMBER_RANGE = 1;
    private static final int MAXIMUM_NUMBER_RANGE = 45;
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        validateRange(number);
    }

    private void validateRange(int number) {
        if(number > MAXIMUM_NUMBER_RANGE || number < MINIMUM_NUMBER_RANGE){
            throw new IllegalArgumentException("[ERROR] 로또 번호 범위(1~45)에 맞지 않는 숫자입니다.");
        }
    }
}
