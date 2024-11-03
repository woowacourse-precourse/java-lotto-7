package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("유효한 값으로 Money를 생성할 수 있다.")
    void should_CreateMoney_When_GivenValidValue() {
        // given
        int value = 1000;
        // when
        Money money = new Money(value);
        // then
        Assertions.assertThat(money).isNotNull();
    }

}