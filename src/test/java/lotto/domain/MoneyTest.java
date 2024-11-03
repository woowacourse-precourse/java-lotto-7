package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @Test
    void 구입_금액이_올바른_단위일_경우_Money_객체를_생성할_수_있다() {
        // given
        int validAmount = 3_000;

        // when
        Money money = Money.from(validAmount);

        // then
        assertThat(money).isInstanceOf(Money.class);
    }

    @Test
    void 구입_금액이_잘못된_단위일_경우_Money_객체_생성에_실패한다() {
        // given
        int invalidAmount = 1_500;

        // when & then
        assertThatThrownBy(() -> Money.from(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1_000, -1_500})
    void 구입_금액이_1000원_단위의_양의_정수가_아닌_경우_Money_객체_생성에_실패한다() {
        // given
        int negativeAmount = -1_000;

        // when & then
        assertThatThrownBy(() -> Money.from(negativeAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NEGATIVE_AMOUNT_NOT_ALLOWED.getMessage());
    }
}