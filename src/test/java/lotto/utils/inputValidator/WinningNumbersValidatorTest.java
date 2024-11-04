package lotto.utils.inputValidator;

import static lotto.constants.LottoTicket.LOWER_BOUND;
import static lotto.constants.LottoTicket.NUMBERS_PER_LOTTO;
import static lotto.constants.LottoTicket.UPPER_BOUND;
import static lotto.exception.ErrorMessages.EMPTY_INPUT;
import static lotto.exception.ErrorMessages.NUMBER_COUNT_MISMATCH;
import static lotto.exception.ErrorMessages.OUT_OF_RANGE;
import static lotto.utils.fixture.InputFixture.VALID_RAW_WINNING_NUMBERS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("[Utils] WinningNumbersValidator")
public class WinningNumbersValidatorTest {
    private final PositiveIntValidator positiveIntValidator = new PositiveIntValidator();
    private final LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();
    private final WinningNumbersValidator winningNumbersValidator = new WinningNumbersValidator(positiveIntValidator, lottoNumberValidator);

    @Nested
    @DisplayName("[validateNotEmpty] 입력한 값이 비어있지 않은 지 검증한다")
    class ValidateNotEmptyTest {

        @Test
        @DisplayName("[Pass] 정상적인 조건의 입력값은 아무런 행동도 하지 않는다.")
        void Given_ValidInput_When_ValidateNotEmpty_Then_DoNothing(){
            //given
            final String VALID_INPUT = VALID_RAW_WINNING_NUMBERS.getInput();

            //when & then
            assertDoesNotThrow(()-> winningNumbersValidator.validate(VALID_INPUT));
        }

        @ParameterizedTest
        @ValueSource(strings = {""," ","\t","\n"}) //given
        @DisplayName("[Exception] 빈 입력값이 들어오는 경우 예외를 던진다")
        void Given_EmptyInput_When_ValidateNotEmpty_Then_ThrowException(String invalidInput){

            //when & then
            assertThatThrownBy(()-> winningNumbersValidator.validate(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(EMPTY_INPUT.getMessage());
        }
    }


    @Nested
    @DisplayName("[validateLottoFormat] 입력한 값이 로또 당첨번호 입력 형식에 맞는 지 검증한다")
    class ValidateLottoFormatTest {

        @Test
        @DisplayName("[Pass] 정상적인 조건의 입력값은 아무런 행동도 하지 않는다.")
        void Given_ValidInput_When_ValidateLottoFormat_Then_DoNothing(){
            //given
            final String VALID_INPUT = VALID_RAW_WINNING_NUMBERS.getInput();

            //when & then
            assertDoesNotThrow(()-> winningNumbersValidator.validate(VALID_INPUT));
        }

        @ParameterizedTest
        @ValueSource(strings = {"r,s,1,2,3,4", "-1,-3,2,3,4,10","10000000000,ddd,aaa,vv,cc,dd","1.152,-3.215,10,11,12,13"}) //given
        @DisplayName("[Exception] 입력한 값 중 양의 정수가 아닌 것이 있다면 예외를 던진다.")
        void Given_NotPositiveInt_When_ValidateLottoFormat_Then_ThrowException(String invalidInput){

            //when & then
            assertThatThrownBy(()-> winningNumbersValidator.validate(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,2000,6,46","1000,20000000,3,4,5"}) //given
        @DisplayName("[Exception] 입력한 숫자 중 로또 번호의 범위를 넘어가는 숫자가 있으면 예외를 던진다.")
        void Given_OutOfBoundary_When_ValidateLottoFormat_Then_ThrowException(String invalidInput){

            //when & then
            assertThatThrownBy(()-> winningNumbersValidator.validate(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.format(OUT_OF_RANGE.getMessage(),LOWER_BOUND.getValue(),UPPER_BOUND.getValue()));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,6,7","1,2,3,4,5"}) //given
        @DisplayName("[Exception] 로또 번호 갯수와 숫자 갯수가 일치 하지 않으면 예외를 던지다.")
        void Given_EmptyInput_When_ValidateLottoFormat_Then_ThrowException(String invalidInput){

            //when & then
            assertThatThrownBy(()-> winningNumbersValidator.validate(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.format(NUMBER_COUNT_MISMATCH.getMessage(),NUMBERS_PER_LOTTO.getValue()));
        }
    }
}
