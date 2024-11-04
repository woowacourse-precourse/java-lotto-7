package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceTest {
    private static final int MIN_PRICE = 1_000;
    private static final int MAX_PRICE = Integer.MAX_VALUE;

    private static final String priceRangeErrorMessage = "[ERROR] 구입금액은 " + MIN_PRICE + "원 이상, " + MAX_PRICE + "원 이하의 숫자만 입력 가능합니다.";
    private static final String remainderErrorMessage = "[ERROR] 구입금액은 " + MIN_PRICE + "원으로 나누어 떨어져야 합니다.";

    @DisplayName("구입금액 생성 후 값 출력이 정상적이다.")
    @Test
    void 번호_생성_후_값_출력() {
        Price priceInteger = new Price(3000);
        Price priceString = new Price("3000");

        Assertions.assertThat(priceInteger.value()).isEqualTo(3000);
        Assertions.assertThat(priceString.value()).isEqualTo(3000);
    }

    @DisplayName("구입금액에 특수문자가 입력되면 예외가 발생한다.")
    @Test
    void 구입금액에_특수문자가_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Price("!"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);

        assertThatThrownBy(() -> new Price("!23"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);

        assertThatThrownBy(() -> new Price("2!3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);

        assertThatThrownBy(() -> new Price("23!"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);
    }

    @DisplayName("구입금액에 문자가 입력되면 예외가 발생한다.")
    @Test
    void 구입금액에_문자가_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Price("abc"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);

        assertThatThrownBy(() -> new Price("a1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);

        assertThatThrownBy(() -> new Price("1a"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);

        assertThatThrownBy(() -> new Price("a1b"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);
    }

    @DisplayName("번호에 공백이 입력되면 예외가 발생한다.")
    @Test
    void 구입금액에_공백이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Price(" "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);

        assertThatThrownBy(() -> new Price("\n"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);

        assertThatThrownBy(() -> new Price(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);
    }

    @DisplayName("번호에 공백을 포함한 숫자가 입력되면 예외가 발생한다.")
    @Test
    void 구입금액에_공백을_포함한_숫자가_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Price(" 1200"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);

        assertThatThrownBy(() -> new Price("1200 "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);

        assertThatThrownBy(() -> new Price("1 200"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);
    }

    @DisplayName("범위를 초과한 금액이 입력되면 예외가 발생한다.")
    @Test
    void 범위를_초과한_금액이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Price("0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);

        assertThatThrownBy(() -> new Price("-1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);

        assertThatThrownBy(() -> new Price("1000000000000"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(priceRangeErrorMessage);
    }

    @DisplayName("최소 금액으로 나누어지지 않는 금액이 입력되면 예외가 발생한다.")
    @Test
    void 나누어지지_않는_금액이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Price("11111"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(remainderErrorMessage);
    }
}