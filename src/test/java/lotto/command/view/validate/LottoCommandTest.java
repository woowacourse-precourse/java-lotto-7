package lotto.command.view.validate;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.common.exception.ExceptionEnum;
import lotto.dto.UserInput;
import lotto.dto.WinningLottoUserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 3.
 */
class LottoCommandTest extends NsTest {
  private LottoCommand command;

  @BeforeEach
  void setUp(){
    command = new LottoCommand();
  }

  @ParameterizedTest
  @MethodSource("provideInputsForRetry")
  @DisplayName("[success]execute : 재시도 로직")
  void execute_shouldRetryOnInvalidInput(String invalidInput, String validInput, ExceptionEnum exceptionEnum) {
    String ask = "당첨 번호를 입력해 주세요.";
    assertSimpleTest(()-> {
      run(invalidInput, validInput);
      assertThat(output()).satisfies(
          text -> assertThat(text).containsSubsequence(
              ask,
              ask
          ),
          text -> assertThat(text).contains(exceptionEnum.getMessage())
      );
    });
  }

  @ParameterizedTest
  @MethodSource("provideValidLottoInputs")
  @DisplayName("[success]validate : 유효한 로또 번호")
  void validate_shouldReturnCorrectUserInput(String input, List<Integer> expectedNumbers) {
    UserInput result = command.validate(input);
    assertThat(result)
        .isInstanceOf(WinningLottoUserInput.class);
    assertThat(((WinningLottoUserInput) result)
        .getNumbers())
        .isEqualTo(expectedNumbers);
  }

  @ParameterizedTest
  @MethodSource("invalidWhiteSpace")
  @DisplayName("[fail]validate : 공백 입력 처리")
  void validate_shouldThrowExceptionWithWhiteSpace(String blankInput,
      ExceptionEnum exceptionEnum) {
    assertThatThrownBy(() -> command.validate(blankInput))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]")
        .hasMessageContaining(exceptionEnum.getMessage());
  }

  @Test
  @DisplayName("[fail]validate : 공백이 포함된 입력 처리")
  void validate_shouldThrowExceptionWithSpace() {
    String inputWithSpace = "1,2,3,4,5,6 ";
    assertThatThrownBy(() -> command.validate(inputWithSpace))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]")
        .hasMessageContaining(ExceptionEnum.CONTAIN_WHITESPACE.getMessage());
  }

  @Test
  @DisplayName("[fail]validate : 최소 번호보다 작은 값 입력")
  void validate_shouldThrowExceptionWhenNumberLessThanMinimum() {
    String inputLessThanMinimum = "0,1,2,3,4,5";
    assertThatThrownBy(() -> command.validate(inputLessThanMinimum))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]")
        .hasMessageContaining(ExceptionEnum.INPUT_LESS_THAN_MINIMUM.getMessage());
  }

  @Test
  @DisplayName("[fail]validate : 최대 번호보다 큰 값 입력")
  void validate_shouldThrowExceptionWhenNumberGreaterThanMaximum() {
    String inputGreaterThanMaximum = "1,2,3,4,5,50";
    assertThatThrownBy(() -> command.validate(inputGreaterThanMaximum))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]")
        .hasMessageContaining(ExceptionEnum.INPUT_GREATER_THAN_MAXIMUM.getMessage());
  }

  @ParameterizedTest
  @MethodSource("provideInputsWithDuplicates")
  @DisplayName("[fail]validate : 중복된 번호 입력")
  void validate_shouldThrowExceptionWhenNumbersNotDistinct(String input) {
    assertThatThrownBy(() -> command.validate(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]")
        .hasMessageContaining(ExceptionEnum.LOTTO_NUMBER_NOT_DISTINCT.getMessage());
  }

  @Test
  @DisplayName("[fail]validate : 잘못된 숫자 형식 입력")
  void validate_shouldThrowExceptionWhenInvalidNumberFormat() {
    String invalidInput = "1,two,3,four,five,six";
    assertThatThrownBy(() -> command.validate(invalidInput))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]")
        .hasMessageContaining(ExceptionEnum.INVALID_INTEGER_RANGE.getMessage());
  }

  private static Stream<org.junit.jupiter.params.provider.Arguments> provideInputsForRetry() {
    return Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("1,2,3,4,5,6,7", "1,2,3,4,5,6", ExceptionEnum.LOTTO_NUMBER_COUNT_NOT_AVAILABLE),
        org.junit.jupiter.params.provider.Arguments.of("1,2,3,4,5", "1,2,3,4,5,6", ExceptionEnum.LOTTO_NUMBER_COUNT_NOT_AVAILABLE),
        org.junit.jupiter.params.provider.Arguments.of("a,b,c,d,e,f", "1,2,3,4,5,6", ExceptionEnum.INVALID_LONG_RANGE),
        org.junit.jupiter.params.provider.Arguments.of("1,2,3,4,5,5", "1,2,3,4,5,6", ExceptionEnum.LOTTO_NUMBER_NOT_DISTINCT)
    );
  }

  private static Stream<Arguments> provideValidLottoInputs() {
    return Stream.of(
        Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6)),
        Arguments.of("7,8,9,10,11,12", List.of(7, 8, 9, 10, 11, 12)),
        Arguments.of("1,3,5,7,9,11", List.of(1, 3, 5, 7, 9, 11))
    );
  }

  private static Stream<String> provideInputsWithDuplicates() {
    return Stream.of(
        "1,2,3,4,5,5",
        "1,1,2,3,4,5",
        "2,3,4,5,6,6",
        "7,8,9,10,10,11",
        "1,2,2,3,4,5",
        "5,6,7,8,9,9"
    );
  }

  private static Stream<Arguments> invalidWhiteSpace() {
    return Stream.of(
        Arguments.of("", ExceptionEnum.CONTAIN_BLANK),
        Arguments.of(" ", ExceptionEnum.CONTAIN_BLANK),
        Arguments.of("\t", ExceptionEnum.CONTAIN_BLANK),
        Arguments.of("\n", ExceptionEnum.CONTAIN_BLANK),
        Arguments.of("\r", ExceptionEnum.CONTAIN_BLANK),
        Arguments.of("\f", ExceptionEnum.CONTAIN_BLANK));
  }

  @Override
  protected void runMain() {
    command.execute(Arrays.toString(new String[]{}));
  }
}