package lotto.command.view.validate;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.service.lotto.constant.LottoConstant.MATCH_SIX_PRIZE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.stream.Stream;
import lotto.common.exception.ExceptionEnum;
import lotto.dto.PurchaseAmountUserInput;
import lotto.dto.UserInput;

import lotto.service.lotto.constant.LottoConstant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 3.
 */
class PurchaseAmountCommandTest extends NsTest {
  private PurchaseAmountCommand command;

  @BeforeEach
  void setUp () {
    command = new PurchaseAmountCommand();
  }

  @ParameterizedTest
  @MethodSource("provideInputsForRetry")
  @DisplayName("[success]execute : 재시도 로직")
  void execute_shouldRetryOnInvalidInput(String invalidInput, String validInput, ExceptionEnum exceptionEnum) {
    String ask = "구입금액을 입력해 주세요.";
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
  @ValueSource(strings = {
      "1000",
      "65000",
      "7000"})
  @DisplayName("[success]validate : 유효한 로또 구매 금액")
  void validate_shouldReturnCorrectUserInput(String input) {
    UserInput result = command.validate(input);
    assertThat(result)
        .isInstanceOf(PurchaseAmountUserInput.class);
    assertThat(((PurchaseAmountUserInput) result)
        .getAmount())
        .isEqualTo(Long.parseLong(input));
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
    String inputWithSpace = "1000 ";
    assertThatThrownBy(() -> command.validate(inputWithSpace))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]")
        .hasMessageContaining(ExceptionEnum.CONTAIN_WHITESPACE.getMessage());
  }

  @Test
  @DisplayName("[fail]validate : 최소 단위 보다 작은 값 입력")
  void validate_shouldThrowExceptionWhenAmountLessThanMinimum() {
    long lessThanMinimum = LottoConstant.AMOUNT_UNIT - 1;
    assertThatThrownBy(() -> command.validate(String.valueOf(lessThanMinimum)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]")
        .hasMessageContaining(ExceptionEnum.INPUT_LESS_THAN_MINIMUM.getMessage());
  }

  @Test
  @DisplayName("[fail]validate : 최대값 보다 큰 값 입력")
  void validate_shouldThrowExceptionWhenAmountGreaterThanMaximum() {
    long greaterThanMaximum = (Long.MAX_VALUE / MATCH_SIX_PRIZE) * LottoConstant.AMOUNT_UNIT + 1;
    assertThatThrownBy(() -> command.validate(String.valueOf(greaterThanMaximum)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]")
        .hasMessageContaining(ExceptionEnum.INPUT_GREATER_THAN_MAXIMUM.getMessage());
  }

  @Test
  @DisplayName("[fail]validate : 정수가 아닌 값 입력")
  void validate_shouldThrowExceptionWhenAmountNotInteger() {
    String decimalInput = "5000.5";
    assertThatThrownBy(() -> command.validate(decimalInput))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]")
        .hasMessageContaining(ExceptionEnum.INVALID_INTEGER_RANGE.getMessage());
  }

  @Test
  @DisplayName("[fail]validate : 입력값 단위로 나누어 떨어지지 않는 입력")
  void validate_shouldThrowExceptionWhenAmountNotInUnit() {
    long inputNotInRange = LottoConstant.AMOUNT_UNIT + 1;
    assertThatThrownBy(() -> command.validate(String.valueOf(inputNotInRange)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]")
        .hasMessageContaining(ExceptionEnum.PURCHASE_AMOUNT_NOT_IN_UNIT.getMessage());
  }

  @Test
  @DisplayName("[fail]ask : 입력값 질의")
  void ask_shouldReturnCorectPrompt() {
    assertThat(command.ask()).isEqualTo("\n구입금액을 입력해 주세요.");
  }


  private static Stream<org.junit.jupiter.params.provider.Arguments> provideInputsForRetry() {
    return Stream.of(
        org.junit.jupiter.params.provider.Arguments.of("invalid", "7000", ExceptionEnum.INVALID_LONG_RANGE),
        org.junit.jupiter.params.provider.Arguments.of("abc", "1000", ExceptionEnum.INVALID_LONG_RANGE),
        org.junit.jupiter.params.provider.Arguments.of("notANumber", "5000", ExceptionEnum.INVALID_LONG_RANGE)
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