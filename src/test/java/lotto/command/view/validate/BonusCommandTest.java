package lotto.command.view.validate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import lotto.common.exception.ExceptionEnum;
import lotto.dto.BonusUserInput;
import lotto.dto.UserInput;
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
class BonusCommandTest {
  private BonusCommand command;

  @BeforeEach
  void setUp() {
    command = new BonusCommand();
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "1",
      "10",
      "45"
  })
  @DisplayName("[success]execute : 유효한 보너스 번호")
  void execute_shouldReturnCorrectUserInput(String input) {
    UserInput result = command.execute(input);
    assertThat(result)
        .isInstanceOf(BonusUserInput.class);

    assertThat(((BonusUserInput) result).getNumber())
        .isEqualTo(Integer.parseInt(input));
  }

  @ParameterizedTest
  @MethodSource("provideInvalidBonusInputs")
  @DisplayName("[fail]execute : 유효하지 않은 보너스 번호")
  void execute_shouldThrowExceptionWhenInvalidInput(String input, ExceptionEnum expectedException) {
    assertThatThrownBy(() -> command.execute(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(expectedException.getMessage());
  }

  private static Stream<Arguments> provideInvalidBonusInputs() {
    return Stream.of(
        Arguments.of("0", ExceptionEnum.INPUT_LESS_THAN_MINIMUM),
        Arguments.of("46", ExceptionEnum.INPUT_GREATER_THAN_MAXIMUM),
        Arguments.of("50", ExceptionEnum.INPUT_GREATER_THAN_MAXIMUM),
        Arguments.of("abc", ExceptionEnum.INVALID_INTEGER_RANGE),
        Arguments.of("-1", ExceptionEnum.INPUT_LESS_THAN_MINIMUM)
    );
  }
}