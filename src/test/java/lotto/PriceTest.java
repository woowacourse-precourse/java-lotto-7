package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceTest {

    @DisplayName("로또 구입 금액을 정상적으로 저장한다.")
    @Test
    void 로또_구입_금액을_정상적으로_저장한다() {
        String input = "1000";

        Price price = Price.from(input);

        assertEquals(1000, price.getValue());
    }

    @DisplayName("로또 구입 금액이 null일 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_null일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Price.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("로또 구입 금액에 문자가 포함될 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액에_문자가_포함될_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Price.from("3000.14"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");

        assertThatThrownBy(() -> Price.from("300 0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");

        assertThatThrownBy(() -> Price.from(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");

        assertThatThrownBy(() -> Price.from("*"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");

        assertThatThrownBy(() -> Price.from("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_천원으로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Price.from("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");

        assertThatThrownBy(() -> Price.from("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("로또 구입 금액이 100,000원을 초과할 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_십만원을_초과할_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Price.from("2000001000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}
