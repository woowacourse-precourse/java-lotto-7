package lotto;

import lotto.model.BonusNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @Test
    void 예외_메시지_테스트_1부터_45까지_숫자만_입력() {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber(46);
        });

        Assertions.assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }
}
