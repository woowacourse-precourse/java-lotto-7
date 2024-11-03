package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoApplicationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class MoneyTest {

    @Test
    void _0보다_작은_금액은_생성할_수_없다() {
        // when & then
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 0보다 작을 수 없습니다.");
    }

    @CsvSource(textBlock = """
            999,1000,false
            1000,1000,true
            """)
    @ParameterizedTest
    void 잔액이_충분한지_확인할_수_있다(int amount, int price, boolean expected) {
        // when
        Money money = new Money(amount);

        // then
        boolean enoughToBuy = money.isEnoughToBuy(price);

        assertThat(enoughToBuy).isEqualTo(expected);
    }

    @Test
    void 잔액을_초과한_금액을_차감할_수_없다() {
        // given
        Money money = new Money(1000);

        // when & then
        assertThatThrownBy(() -> money.deduct(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잔액이 충분하지 않습니다.");
    }

}
