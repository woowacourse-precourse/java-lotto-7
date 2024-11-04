package lotto.validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.exception.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberValidatorTest {

    @DisplayName("구분자 제외 숫자 이외의 문자 입력시 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"A", "b", "+", "ㅋ", ":"})
    void 구분자_제외_숫자_이외의_문자_예외(String input){
        Assertions.assertThatThrownBy(()->WinningNumberValidator.validateOnlyNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_WINNING_NUMBER_NOT_NUMERIC.toString());
    }

    @DisplayName("구분자 제외 숫자만 입력된다면 해당 검증은 통과합니다")
    @Test
    void 구분자_제외_숫자만_입력_통과(){
        String input = "1";
        WinningNumberValidator.validateOnlyNumeric(input);
    }

    @DisplayName("구분자 사이가 비어있으면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,,3,42,13,34,41",
            "1,2,3,4,5,6,",
            ",1,2,3,4,5,6",
            "1, 2, 3, 4, , 5, 6"
    })
    void 구분자_사이_없음_예외(String input){
        Assertions.assertThatThrownBy(()->WinningNumberValidator.validateBetweenDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_INPUT_NO_EMPTY_BETWEEN_DELIMITER.toString());
    }

    @DisplayName("구분자 사이가 비어있지 않으면 통과")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,6",
            "1, 2, 3, 4, 5, 6",
            "1,2,3,;,4,5" // 잘못된 입력이나 해당 검증 자체는 통과
    })
    void 구분자_사이_들어있음_통과(String input){
        WinningNumberValidator.validateBetweenDelimiter(input);
    }

    @DisplayName("당첨번호가 6개가 아닌 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @MethodSource("provideWinningNumbersList")
    void 당첨번호_6개_아님_예외(List<Integer> winningNumbers){
        Assertions.assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbersCount(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_WINNING_NUMBERS_NOT_SIX.toString());
    }

    static Stream<Arguments> provideWinningNumbersList(){
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6,7)),
                Arguments.of(Arrays.asList(1,2,3,4,5)),
                Arguments.of(Arrays.asList(1,4,5))
        );
    }

    @DisplayName("당첨번호가 정확히 6개가 들어가있으면 통과한다")
    @Test
    void 당첨번호_6개_맞음_통과(){
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        WinningNumberValidator.validateWinningNumbersCount(winningNumber);
    }

    @DisplayName("구분자가 쉼표가 아니면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {
            "1:2,3:4:5:6",
            "1,2,3:4,5,6",
            "1/2/3/4/5/6"
    })
    void 구분자_쉼표_아님_예외(String input){
        Assertions.assertThatThrownBy(()->WinningNumberValidator.validateDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_INPUT_DELIMITER_ONLY_COMMA.toString());
    }

    @DisplayName("구분자가 쉼표만으로 이루어져있으면 통과")
    @Test
    void 구분자_오직_쉼표_통과(){
        String input = "1,2,3,4,5,6";
        WinningNumberValidator.validateDelimiter(input);
    }

    @DisplayName("당첨 번호 중 중복된 숫자가 있으면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {1,31,41,29,16})
    void 당첨_번호_숫자_중복_예외(int inputNumber){
        List<Integer> winningNumbers = List.of(1,31,41,29,16); // 리스트에 5개의 당첨번호가 들어가있고, 마지막 당첨번호를 넣는 차례라 가정
        Assertions.assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumberDuplicate(winningNumbers,inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_WINNING_NUMBER_DUPLICATE.toString());
    }

    @DisplayName("당첨 번호 중 중복된 숫자가 없으면 통과")
    @Test
    void 당첨_번호_중복_없음_통과(){
        List<Integer> winningNumbers = List.of(1,31,41,29,16);
        int inputNumber = 34;
        WinningNumberValidator.validateWinningNumberDuplicate(winningNumbers,inputNumber);
    }

    @DisplayName("당첨 번호가 1~45 사이의 값이 아니면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100, 67})
    void 숫자_범위_벗어남_예외(int winningNumber){
        Assertions.assertThatThrownBy(() -> WinningNumberValidator.validateNumberRange(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_OUT_OF_RANGE.toString());
    }

    @DisplayName("당첨 번호가 1~45 범위 이내의 값이라면 통과")
    @Test
    void 숫자_범위_이내_통과(){
        int winningNumber = 31;
        WinningNumberValidator.validateNumberRange(winningNumber);
    }
}