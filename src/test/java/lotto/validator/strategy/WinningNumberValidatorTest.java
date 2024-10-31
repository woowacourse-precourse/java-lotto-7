package lotto.validator.strategy;

import lotto.validator.InputValidator;
import lotto.validator.factory.InputValidatorStrategyFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.validator.type.InputType.WINNING_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

@DisplayName("[유닛 테스트] - 당첨 번호 형식 검증")
class WinningNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "1,2,3,4,5,a", "1 2 3 4 5 6"})
    @DisplayName("당첨 번호 형식 검증 - 당첨 번호 형식이 올바르지 않을 경우 에외 발생")
    void invalidWinningNumberFormat_validate_throwException(String inputWinningNumber) {
        //given
        InputValidatorStrategyFactory inputValidatorStrategyFactory = new InputValidatorStrategyFactory();
        InputValidator inputValidator = inputValidatorStrategyFactory.getValidator(WINNING_NUMBER);

        //when
        Throwable throwable = catchThrowable(() -> inputValidator.validate(inputWinningNumber));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("[ERROR] 당첨 번호 형식이 올바르지 않습니다.");
    }
}