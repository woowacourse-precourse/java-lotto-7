package lotto;

public class LottoNumber {

    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;

    // 에러 메시지 상수 처리
    private final static String ERROR_MESSAGE = "[ERROR] 로또 번호는 %d부터 %d사이의 숫자여야 합니다.";
    void validateBound(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, MIN_NUMBER, MAX_NUMBER));
        }
    }
}
