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

    @Test
    @DisplayName("같은 값을 가진 Money는 같은 객체이다.")
    void should_BeSameObject_When_SameValue() {
        // given
        int value = 1000;
        // when
        Money money1 = new Money(value);
        Money money2 = new Money(value);
        //then
        Assertions.assertThat(money1).isEqualTo(money2);
    }
}