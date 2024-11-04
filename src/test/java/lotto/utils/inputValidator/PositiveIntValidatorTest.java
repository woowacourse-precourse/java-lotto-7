package lotto.utils.inputValidator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.exception.ErrorMessages.EMPTY_INPUT;
import static lotto.exception.ErrorMessages.NOT_INT;
import static lotto.exception.ErrorMessages.NOT_NUMBER;
import static lotto.exception.ErrorMessages.NOT_POSITIVE_INT;
import static lotto.utils.fixture.InputFixture.VALID_RAW_BONUS_NUMBER;
import static lotto.utils.fixture.InputFixture.VALID_RAW_PURCHASE_AMOUNT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("[Utils] PositiveIntValidator ")
public class PositiveIntValidatorTest {
    private final PositiveIntValidator positiveIntValidator = new PositiveIntValidator();

    @Nested
    @DisplayName("[validateNotEmpty] 입력값이 비어있지는 않은 지 검증한다")
    class ValidateNotEmptyTest {

        @Test
        @DisplayName("[Pass] 정상적인 조건의 입력값은 아무런 행동도 하지 않는다.")
        void Given_ValidInput_When_ValidateNotEmpty_Then_DoNothing(){
            //given
            final String VALID_INPUT = VALID_RAW_PURCHASE_AMOUNT.getInput();

            //when & then
            assertDoesNotThrow(()-> positiveIntValidator.validate(VALID_INPUT));
        }

        @ParameterizedTest
        @ValueSource(strings = {""," ","\t","\n"}) //given
        @DisplayName("[Exception] 빈 입력값이 들어오는 경우 예외를 던진다")
        void Given_EmptyInput_When_ValidateNotEmpty_Then_ThrowException(String invalidInput){

            //when & then
            assertThatThrownBy(()-> positiveIntValidator.validate(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(EMPTY_INPUT.getMessage());
        }

    }



    @Nested
    @DisplayName("[validateNumber] 입력값이 숫자로 변환이 가능한지 검증한다")
    class ValidateNumberTest {

        @Test
        @DisplayName("[Pass] 정상적인 조건의 입력값은 아무런 행동도 하지 않는다.")
        void Given_ValidInput_When_ValidateNumber_Then_DoNothing(){
            //given
            final String VALID_INPUT = VALID_RAW_PURCHASE_AMOUNT.getInput();

            //when & then
            assertDoesNotThrow(()-> positiveIntValidator.validate(VALID_INPUT));
        }

        @ParameterizedTest
        @ValueSource(strings = {"a 2 d 2","as2f","뽀뚜"," 4 4"}) //given
        @DisplayName("[Exception] 숫자로 변환이 불가능한 입력값 들어오는 경우 예외를 던진다")
        void Given_NotNumber_When_ValidateNumber_Then_ThrowException(String invalidInput){

            //when & then
            assertThatThrownBy(()-> positiveIntValidator.validate(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_NUMBER.getMessage());
        }

    }

    @Nested
    @DisplayName("[validateInt] 입력값이 정수로 변환이 가능한 지 검증한다.")
    class ValidateIntTest {

        @Test
        @DisplayName("[Pass] 정상적인 조건의 입력값은 아무런 행동도 하지 않는다.")
        void Given_ValidInput_When_ValidateInt_Then_DoNothing(){
            //given
            final String VALID_INPUT = VALID_RAW_BONUS_NUMBER.getInput();

            //when & then
            assertDoesNotThrow(()-> positiveIntValidator.validate(VALID_INPUT));
        }

        @ParameterizedTest
        @ValueSource(strings = {"4.4","1.011","-23.415"}) //given
        @DisplayName("[Exception] 정수로 변환이 불가능한 입력값 들어오는 경우 예외를 던진다")
        void Given_NotInt_When_ValidateInt_Then_ThrowException(String invalidInput){

            //when & then
            assertThatThrownBy(()-> positiveIntValidator.validate(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_INT.getMessage());
        }

    }


    @Nested
    @DisplayName("[validatePositiveInt] 입력값이 양의 정수로 변환이 가능한지 검증한다.")
    class ValidatePositiveIntTest {

        @Test
        @DisplayName("[Pass] 정상적인 조건의 입력값은 아무런 행동도 하지 않는다.")
        void Given_ValidInput_When_ValidatePositiveInt_Then_DoNothing(){
            //given
            final String VALID_INPUT = VALID_RAW_BONUS_NUMBER.getInput();

            //when & then
            assertDoesNotThrow(()-> positiveIntValidator.validate(VALID_INPUT));
        }

        @ParameterizedTest
        @ValueSource(strings = {"0","-1","-10234"}) //given
        @DisplayName("[Exception] 정수로의 변환 결과가 양수가 아닌 경우 예외를 던진다")
        void Given_NotPositiveInt_When_ValidatePositiveInt_Then_ThrowException(String invalidInput){

            //when & then
            assertThatThrownBy(()-> positiveIntValidator.validate(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_POSITIVE_INT.getMessage());
        }

    }
}
