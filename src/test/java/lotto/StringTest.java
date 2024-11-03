package lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringTest {

  @DisplayName("구입 금액 입력값이 null이거나 빈 문자열인 경우 예외가 발생한다")
  @ParameterizedTest
  @NullAndEmptySource
  void validateEmptyPurchaseAmount(String input) {
    Application app = new Application();

    assertThatThrownBy(() -> app.validatePurchaseAmount(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("[ERROR] 구입금액은 필수입니다.");
  }

  @DisplayName("구입 금액이 숫자가 아닌 경우 예외가 발생한다")
  @ParameterizedTest
  @ValueSource(strings = { "abc", "1,000", "1000원", "천원" })
  void validateNonNumericPurchaseAmount(String input) {
    Application app = new Application();

    assertThatThrownBy(() -> app.validatePurchaseAmount(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("[ERROR] 구입금액은 숫자로 입력해 주세요.");
  }

  @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외가 발생한다")
  @ParameterizedTest
  @ValueSource(strings = { "999", "1500", "2001" })
  void validateInvalidUnitPurchaseAmount(String input) {
    Application app = new Application();

    assertThatThrownBy(() -> app.validatePurchaseAmount(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("[ERROR] 구입금액은 1,000원 단위이며, 1,000원 이상이어야 합니다.");
  }

  @DisplayName("당첨 번호 입력값이 null이거나 빈 문자열인 경우 예외가 발생한다")
  @ParameterizedTest
  @NullAndEmptySource
  void validateEmptyWinningNumbers(String input) {
    Application app = new Application();

    assertThatThrownBy(() -> app.validateWinningNumberInput(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("[ERROR] 당첨 번호는 필수입니다.");
  }

  @DisplayName("당첨 번호가 올바른 형식이 아닌 경우 예외가 발생한다")
  @ParameterizedTest
  @ValueSource(strings = {
      "1,2,3,4,5", // 6개 미만
      "1,2,3,4,5,6,7", // 6개 초과
      "1, 2, 3, a, 5, 6", // 숫자가 아닌 값
      "1.2.3.4.5.6", // 잘못된 구분자
      "1,,2,3,4,5,6" // 연속된 쉼표
  })
  void validateInvalidFormatWinningNumbers(String input) {
    Application app = new Application();

    assertThatThrownBy(() -> app.validateWinningNumberInput(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("당첨 번호가 1-45 범위를 벗어난 경우 예외가 발생한다")
  @ParameterizedTest
  @ValueSource(strings = {
      "0,1,2,3,4,5",
      "1,2,3,4,5,46",
      "-1,1,2,3,4,5"
  })
  void validateOutOfRangeWinningNumbers(String input) {
    Application app = new Application();

    assertThatThrownBy(() -> app.parseWinningNumbers(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
  }

  @DisplayName("올바른 형식의 입력값은 정상적으로 처리된다")
  @Test
  void validateValidInput() {
    Application app = new Application();

    assertThatCode(() -> {
      app.validatePurchaseAmount("1000");
      app.validateWinningNumberInput("1,2,3,4,5,6");
      List<Integer> numbers = app.parseWinningNumbers("1,2,3,4,5,6");
      assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }).doesNotThrowAnyException();
  }

  @DisplayName("공백이 포함된 입력값도 정상적으로 처리된다")
  @Test
  void validateInputWithWhitespace() {
    Application app = new Application();

    assertThatCode(() -> {
      app.validateWinningNumberInput(" 1, 2, 3, 4, 5, 6 ");
      List<Integer> numbers = app.parseWinningNumbers(" 1, 2, 3, 4, 5, 6 ");
      assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }).doesNotThrowAnyException();
  }
}