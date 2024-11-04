package lotto.model;

import lotto.exception.LottoGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MoneyTest {

    @Test
    @DisplayName("0원 미만일 경울 예외 발생")
    void of() {
        assertThatThrownBy(() -> Money.of(-100))
                .isInstanceOf(LottoGameException.class)
                .hasMessage("[ERROR] 금액은 0 이상이어야 합니다.");

    }

    @Test
    @DisplayName("구매 가능한 로또 개수를 반환한다.")
    void getPossibleLottoCount() {
        Money money = Money.of(3000);

        int result = money.getPossibleLottoCount();

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("수익률을 반환한다.")
    void getRateOfReturn() {
        // given
        Money money = Money.of(3000);

        // when
        double result = money.getRateOfReturn(30000);

        // then
        assertThat(result).isEqualTo(1000.0);
    }

}