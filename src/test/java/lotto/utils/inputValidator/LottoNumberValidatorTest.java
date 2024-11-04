package lotto.utils.inputValidator;

import static lotto.constants.LottoTicket.LOWER_BOUND;
import static lotto.constants.LottoTicket.UPPER_BOUND;
import static lotto.exception.ErrorMessages.OUT_OF_RANGE;
import static lotto.utils.fixture.InputFixture.VALID_RAW_BONUS_NUMBER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("[Utils] LottoNumberValidator")
public class LottoNumberValidatorTest {
    private final LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

    @Nested
    @DisplayName("[validate] 입력된 양의 정수가 로또 번호 범위 내에 있는 지 검증한다")
    class ValidateBoundaryTest{
        @Test
        @DisplayName("[Pass] 정상적인 조건의 입력값은 아무런 행동도 하지 않는다.")
        void Given_ValidInput_When_ValidateBoundary_Then_DoNothing(){
            //given
            final int VALID_INPUT = Integer.parseInt(VALID_RAW_BONUS_NUMBER.getInput());

            //when & then
            assertDoesNotThrow(()-> lottoNumberValidator.validate(VALID_INPUT));
        }

        @ParameterizedTest
        @ValueSource(ints = {56,20000,1000}) //given
        @DisplayName("[Exception] 로또 번호 범위를 벗어난다면 예외를 던진다.")
        void Given_NotPositiveInt_When_ValidateBoundary_Then_ThrowException(int invalidInput){

            //when & then
            assertThatThrownBy(()-> lottoNumberValidator.validate(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.format(OUT_OF_RANGE.getMessage(),LOWER_BOUND.getValue(),UPPER_BOUND.getValue()));
        }


    }

}
