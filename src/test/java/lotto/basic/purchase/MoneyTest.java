package lotto.basic.purchase;

import lotto.purchase.domain.Money;
import lotto.view.InputViewImpl;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MoneyTest {

    @Test
    void 입력_테스트() {
        // given
        InputViewImpl inputView = new InputViewImpl();
        Money expectInput = new Money("14000");

        // when
        System.setIn(new ByteArrayInputStream(String.valueOf(expectInput.value())
                .getBytes()));
        Money actualInput = inputView.getMoney();

        // then
        assertThat(expectInput.value())
                .isEqualTo(actualInput.value());
    }

    @Test
    void 음수_테스트() {
        // given
        String errorInput = "-1000";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money(errorInput));
    }

    @Test
    void 단위_테스트() {
        // given
        String errorInput = "1100";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money(errorInput));
    }
}
