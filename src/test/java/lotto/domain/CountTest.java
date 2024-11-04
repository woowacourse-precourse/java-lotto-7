package lotto.domain;

import static lotto.exception.ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT;
import static lotto.exception.ErrorMessage.INVALID_PURCHASE_MIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CountTest {
    @Test
    @DisplayName("from - 1000 단위로 들어오지 않으면 예외가 발생한다.")
    void failMakeCountWhenInvalidUnit() {
        // given
        int money = 13232;
        // when & then
        assertThatThrownBy(() -> Count.from(money))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1000, -10000})
    @DisplayName("from - 1개 미만을 살 경우 예외가 발생한다.")
    void failMakeCountWhenInvalidCount(int money) {
        assertThatThrownBy(() -> Count.from(money))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_PURCHASE_MIN.getMessage());
    }

    @Test
    @DisplayName("from - 정상적인 입력에 대해서는 개수를 정확히 센다")
    void successCount() {
        // given
        int money = 10000;
        // when
        Count count = Count.from(money);
        int purchasedCount = count.getCount();
        // then
        assertThat(purchasedCount).isEqualTo(10);
    }
}

