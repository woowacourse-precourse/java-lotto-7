package lotto.command.view.validate;

import static lotto.service.lotto.constant.LottoConstant.MATCH_SIX_PRIZE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
class PurchaseAmountCommandTest {
  private PurchaseAmountCommand command;

  @BeforeEach
  void setUp () {
    command = new PurchaseAmountCommand();
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "1000",
      "65000",
      "7000"})
  @DisplayName("[success]execute : 유효한 로또 구매 금액")
  void execute_shouldReturnCorrectUserInput(String input) {
    UserInput result = command.execute(input);
    assertThat(result)
        .isInstanceOf(PurchaseAmountUserInput.class);
    assertThat(((PurchaseAmountUserInput) result)
        .getAmount())
        .isEqualTo(Long.parseLong(input));
  }

  @ParameterizedTest
  @MethodSource("invalidWhiteSpace")
  @DisplayName("[fail]execute : 공백 입력 처리")
  void execute_shouldThrowExceptionWithWhiteSpace(String blankInput,
      ExceptionEnum exceptionEnum) {

    assertThatThrownBy(() -> command.execute(blankInput))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("ERROR")
        .hasMessageContaining(exceptionEnum.getMessage());
  }

  @Test
  @DisplayName("[fail]execute : 공백이 포함된 입력 처리")
  void execute_shouldThrowExceptionWithSpace() {
    String inputWithSpace = "1000 ";
    assertThatThrownBy(() -> command.execute(inputWithSpace))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("ERROR")
        .hasMessageContaining(ExceptionEnum.CONTAIN_WHITESPACE.getMessage());
  }

  @Test
  @DisplayName("[fail]execute : 최소 단위 보다 작은 값 입력")
  void execute_shouldThrowExceptionWhenAmountLessThanMinimum() {
    long lessThanMinimum = LottoConstant.AMOUNT_UNIT - 1;
    assertThatThrownBy(() -> command.execute(String.valueOf(lessThanMinimum)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionEnum.INPUT_LESS_THAN_MINIMUM.getMessage());
  }

  @Test
  @DisplayName("[fail]execute : 최대값 보다 큰 값 입력")
  void execute_shouldThrowExceptionWhenAmountGreaterThanMaximum() {
    long greaterThanMaximum = (Long.MAX_VALUE / MATCH_SIX_PRIZE) * LottoConstant.AMOUNT_UNIT + 1;
    assertThatThrownBy(() -> command.execute(String.valueOf(greaterThanMaximum)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionEnum.INPUT_GREATER_THAN_MAXIMUM.getMessage());
  }

  @Test
  @DisplayName("[fail]execute : 정수가 아닌 값 입력")
  void execute_shouldThrowExceptionWhenAmountNotInteger() {
    String decimalInput = "5000.5";
    assertThatThrownBy(() -> command.execute(decimalInput))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionEnum.INVALID_INTEGER_RANGE.getMessage());
  }

  @Test
  @DisplayName("[fail]execute : 입력값 단위로 나누어 떨어지지 않는 입력")
  void execute_shouldThrowExceptionWhenAmountNotInUnit() {
    long inputNotInRange = LottoConstant.AMOUNT_UNIT + 1;
    assertThatThrownBy(() -> command.execute(String.valueOf(inputNotInRange)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionEnum.PURCHASE_AMOUNT_NOT_IN_UNIT.getMessage());
  }

  @Test
  @DisplayName("[fail]ask : 입력값 질의")
  void ask_shouldReturnCorectPrompt() {
    assertThat(command.ask()).isEqualTo("\n구입금액을 입력해 주세요.");
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

}