package lotto.validator.strategy;

import lotto.util.converter.WinningNumberConverter;
import lotto.validator.InputValidator;
import lotto.validator.factory.InputValidatorStrategyFactory;
import lotto.validator.type.InputType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.validator.type.InputType.BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

@DisplayName("[유닛 테스트] - 보너스 번호 형식 검증")
class BonusNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "", "1a", "0", "46"})
    @DisplayName("보너스 번호 형식 검증 - 보너스 번호 형식이 올바르지 않은 경우 예외 발생")
    void invalidBonusNumberFormat_validate_throwException(String inputBonusNumber) {
        //given
        InputValidatorStrategyFactory inputValidatorStrategyFactory = new InputValidatorStrategyFactory();
        InputValidator inputValidator = inputValidatorStrategyFactory.getValidator(BONUS_NUMBER);

        //when
        Throwable throwable = catchThrowable(() -> inputValidator.validate(inputBonusNumber));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("[ERROR] 보너스 번호 형식이 올바르지 않습니다.");
    }
}