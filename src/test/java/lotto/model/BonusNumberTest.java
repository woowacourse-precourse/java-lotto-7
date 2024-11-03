package lotto.model;

import lotto.model.BonusNumber;
import lotto.model.exception.DomainExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호를 가지고 BonusNumber 객체를 생성할 수 있다.")
    void should_CreateBonusNumber_When_GivenNumber() {
        // given
        String number = "1";
        // when
        BonusNumber bonusNumber = new BonusNumber(number);
        // then
        Assertions.assertThat(bonusNumber).isNotNull();
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외를 발생한다.")
    void should_ThrowException_When_BonusNumberIsNotNumber() {
        // given
        String number = "a";
        // when, then
        Assertions.assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 범위에 맞지 않는 값을 지닌 경우 예외를 발생한다..")
    @ValueSource(strings = {"0", "46"})
    void should_ThrowException_When_BonusNumberIsNotInRange(String number) {
        // when, then
        Assertions.assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainExceptionMessage.INVALID_BONUS_NUMBER_VALUE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호는 다른 번호와 일치하는지 확인할 수 있다.")
    void should_MatchBonusNumber_When_GivenNumber() {
        // given
        String number = "1";
        BonusNumber bonusNumber = new BonusNumber(number);
        // when
        boolean match = bonusNumber.match(1);
        // then
        Assertions.assertThat(match).isTrue();
    }

}