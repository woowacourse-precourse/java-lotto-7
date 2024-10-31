package lotto.util;

public class LottoUtils {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public static void validateNumberRange(Integer bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalStateException("[ERROR] 로또 번호는 당첨 번호와 중복되지 않는 1 ~ 45 사이의 정수를 입력해주세요.");
        }
    }
}
