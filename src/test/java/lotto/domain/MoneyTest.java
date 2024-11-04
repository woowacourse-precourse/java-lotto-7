package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    @DisplayName("Money 객체 생성 성공 - 유효한 금액")
    void success_createMoney() {
        // given
        int amount = 5000;

        // when
        Money money = new Money(amount);

        // then
        assertThat(money.amount()).isEqualTo(amount);
    }

    @Test
    @DisplayName("Money 객체 생성 실패 - 음수 금액")
    void fail_createMoney_negativeAmount() {
        // given
        int amount = -1000;

        // when & then
        assertThatThrownBy(() -> new Money(amount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 돈은 양의 정수만 가능합니다.");
    }

    @Test
    @DisplayName("Money 객체 생성 실패 - 1000원 단위가 아닐 때")
    void fail_createMoney_notMultipleOfThousand() {
        // given
        int amount = 1500;

        // when & then
        assertThatThrownBy(() -> new Money(amount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 돈은 1000원 단위로 입력해주세요.");
    }
}
