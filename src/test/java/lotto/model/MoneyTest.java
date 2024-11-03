package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import lotto.model.exception.DomainExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("유효한 값으로 Money를 생성할 수 있다.")
    void should_CreateMoney_When_GivenValidValue() {
        // given
        String value = "1000";
        // when
        Money money = new Money(value);
        // then
        Assertions.assertThat(money).isNotNull();
    }

    @Test
    @DisplayName("같은 값을 가진 Money는 같은 객체이다.")
    void should_BeSameObject_When_SameValue() {
        // given
        String value = "1000";
        // when
        Money money1 = new Money(value);
        Money money2 = new Money(value);
        //then
        Assertions.assertThat(money1).isEqualTo(money2);
    }

    @Test
    @DisplayName("다른 값을 가진 Money는 다른 객체이다.")
    void should_NotBeSameObject_When_DifferentValue() {
        // given
        String value1 = "1000";
        String value2 = "2000";
        // when
        Money money1 = new Money(value1);
        Money money2 = new Money(value2);
        //then
        Assertions.assertThat(money1).isNotEqualTo(money2);
    }

    @Test
    @DisplayName("숫자가 아닌 값으로 Money를 생성하면 예외가 발생한다.")
    void should_ThrowException_When_GivenInvalidFormat() {
        // given
        String value = "1000wooteco";
        // when, then
       Assertions.assertThatThrownBy(() -> new Money(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainExceptionMessage.INVALID_MONEY_FORMAT.getMessage());
    }

    @Test
    @DisplayName("1000원 단위가 아닌 값으로 Money를 생성하면 예외가 발생한다.")
    void should_ThrowException_When_GivenInvalidValue() {
        // given
        String value = "1500";
        // when, then
        Assertions.assertThatThrownBy(() -> new Money(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainExceptionMessage.INVALID_MONEY_UNIT.getMessage());
    }
}