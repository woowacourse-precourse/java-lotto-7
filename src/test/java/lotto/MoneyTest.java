package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

import lotto.model.Money;

public class MoneyTest {

    @Test
    void 입력이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money("숫자"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_1000의_배수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money("1005"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_양수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money("-1000"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상_입력_테스트() {
        assertSimpleTest(() -> {
            Money money = new Money("1000");
            assertThat(money.getMoney()).isEqualTo(1000);
        });
    }
}
