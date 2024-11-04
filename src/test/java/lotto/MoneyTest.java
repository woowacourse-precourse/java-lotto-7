package lotto;

import lotto.model.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    void divideByThousand_예외_메시지_테스트_1000원_단위로_입력() {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Money(1001);
        });

        Assertions.assertEquals("[ERROR] 1000원 단위의 금액을 입력해 주세요.", exception.getMessage());
    }

}
