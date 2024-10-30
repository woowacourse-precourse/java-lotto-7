package lotto;

public class LottoNumber {
    private static final String REQUEST_1_TO_45_NUMBER = "1부터 45 사이의 수를 입력해주세요.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    private void checkLottoNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(REQUEST_1_TO_45_NUMBER);
        }
    }

    
}
