package lotto.utils.inputValidator;

import static lotto.exception.ErrorMessages.BONUS_NUMBER_DUPLICATION;
import static lotto.utils.fixture.InputFixture.VALID_RAW_BONUS_NUMBER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import lotto.utils.inputValidator.comparison.BonusNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("[Utils] BonusNumberValidaotr")
public class BonusNumberValidatorTest {
    private final PositiveIntValidator positiveIntValidator = new PositiveIntValidator();
    private final LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();
    private final BonusNumberValidator bonusNumberValidator = new BonusNumberValidator(positiveIntValidator, lottoNumberValidator);


    @Nested
    @DisplayName("[validateWithComparison] 기존의 당첨 번호와 비교하며 보너스 번호가 유효한 지  검증한다 ")
    class ValidateWithComparison {
        @Test
        @DisplayName("[Pass] 정상적인 조건의 입력값은 아무런 행동도 하지 않는다.")
        void Given_ValidInput_When_ValidateWithComparison_Then_DoNothing(){
            //given
            final String VALID_INPUT = VALID_RAW_BONUS_NUMBER.getInput();
            final List<Integer> VALID_WINNING_NUMBERS = Arrays.asList(1,2,3,4,5,6);

            //when & then
            assertDoesNotThrow(()-> bonusNumberValidator.validateWithComparison(VALID_INPUT, VALID_WINNING_NUMBERS));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1","3","5"}) //given
        @DisplayName("[Exception] 당첨 번호와 보너스 번호가 중복되는 경우 예외를 던진다.")
        void Given_Duplication_When_ValidateWithComparison_Then_ThrowException(String invalidInput){
            //given
            final String INVALID_INPUT = invalidInput;
            final List<Integer> VALID_WINNING_NUMBERS = Arrays.asList(1,2,3,4,5,6);


            //when & then
            assertThatThrownBy(()-> bonusNumberValidator.validateWithComparison(INVALID_INPUT, VALID_WINNING_NUMBERS))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.format(BONUS_NUMBER_DUPLICATION.getMessage(), Integer.parseInt(INVALID_INPUT)));
        }


    }
}
