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
    @DisplayName("음수로 Money를 생성하면 예외가 발생한다.")
    void should_ThrowException_When_GivenNegativeValue() {
        // given
        String value = "-1000";
        // when, then
        Assertions.assertThatThrownBy(() -> new Money(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainExceptionMessage.INVALID_MONEY_VALUE.getMessage());
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

    @Test
    @DisplayName("Money를 더하면 값을 더한 Money를 반환한다.")
    void should_ReturnMoneyWithAddedValue_When_AddMoney() {
        // given
        Money money = new Money("1000");
        // when
        Money addedMoney = money.add(1000);
        // then
        Assertions.assertThat(addedMoney).isEqualTo(new Money("2000"));
    }

    @Test
    @DisplayName("Money를 뺄 때 0원 미만이 되면 예외가 발생한다.")
    void should_ThrowException_When_SubtractMoney() {
        // given
        Money money = new Money("1000");
        // when, then
        Assertions.assertThatThrownBy(() -> money.minus(2000))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(DomainExceptionMessage.INVALID_MONEY_VALUE.getMessage());
    }

    @Test
    @DisplayName("Moeny를 빼면 뺀 값을 지닌 Money를 반환한다.")
    void should_ReturnMoneyWithSubtractedValue_When_SubtractMoney() {
        // given
        Money money = new Money("2000");
        // when
        Money subtractedMoney = money.minus(1000);
        // then
        Assertions.assertThat(subtractedMoney).isEqualTo(new Money("1000"));
    }
}