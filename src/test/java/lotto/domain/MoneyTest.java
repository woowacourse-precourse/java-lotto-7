package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 정상적으로_머니_클래스_생성() {
        // given
        Integer amount = 8000;

        // when
        Money money = new Money(amount);

        // then
        assertThat(money.getAmount()).isEqualTo(8000);
        assertThat(money.getLottoCount()).isEqualTo(8);
    }

    @Test
    void 예외_머니_값이_null일_경우() {
        // given
        Integer amount = null;

        // when & then
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잘못된 번호 값입니다.");
    }

    @Test
    void 예외_머니가_1000원보다_작을_경우() {
        // given
        Integer amount = 800;

        // when & then
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액이 1,000원보다 작을 수 없습니다.");
    }

    @Test
    void 예외_머니가_1000원_단위가_아닐_경우() {
        // given
        Integer amount = 1800;

        // when & then
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액을 1,000원 단위로 입력해주시길 바랍니다.");
    }
}