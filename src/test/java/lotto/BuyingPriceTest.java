package lotto;

import lotto.domain.BuyingPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class BuyingPriceTest {

    @DisplayName("구매 금액이 빈 문자열이면 예외가 발생한다")
    @Test
    void 구매_금액이_빈_문자열이면_예외가_발생한다() {
        assertThatThrownBy(() -> new BuyingPrice(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매 금액을 입력해주세요");
    }

    @DisplayName("구매 금액에 숫자가 아닌 문자가 포함되어 있으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1000a", "a1000", "1,000", "1000원", " 1000", "1000 ", "-1000"})
    void 구매_금액에_숫자가_아닌_문자가_포함되어_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new BuyingPrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 숫자만 가능합니다");
    }

    @DisplayName("구매 금액이 0이면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"0"})
    void 구매_금액이_0이면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new BuyingPrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매 금액은 0보다 커야 합니다");
    }

    @DisplayName("구매 금액이 1000원 단위가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1500", "2100", "1999", "10500"})
    void 구매_금액이_1000원_단위가_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new BuyingPrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매는 1,000원 단위로 가능합니다");
    }

    @DisplayName("올바른 구매 금액은 정상적으로 생성된다")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "5000", "10000"})
    void 올바른_구매_금액은_정상적으로_생성된다(String input) {
        BuyingPrice buyingPrice = new BuyingPrice(input);
        assertThat(buyingPrice.getPrice()).isEqualTo(Integer.parseInt(input));
    }
}
