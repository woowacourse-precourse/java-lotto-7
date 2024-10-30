package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {

    @DisplayName("로또 구입 금액이 null일 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_null일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Price.from(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액에 문자가 포함될 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액에_문자가_포함될_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Price.from("3000.14"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Price.from("300 0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Price.from(" "))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Price.from("*"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Price.from("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
