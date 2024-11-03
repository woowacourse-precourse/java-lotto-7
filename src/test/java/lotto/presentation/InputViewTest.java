package lotto.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.global.ErrorMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
    private ByteArrayOutputStream outputStream;

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private void runConsoleTest(Runnable runnable) {
        try {
            runnable.run();
        } catch (NoSuchElementException ignored) {
            // 입력 실패 시 재입력하므로 예외 무시
        }
    }

    private String getOutput() {
        return outputStream.toString().trim();  // 출력된 내용을 문자열로 가져옴
    }

    private void assertThatOutputContains(ErrorMessage errorMessage) {
        assertThat(getOutput()).contains(errorMessage.getMessage());
    }

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Nested
    @DisplayName("금액 입력 테스트")
    class MoneyInputTests {

        @DisplayName("숫자가 아닌 금액을 입력하면 에러 메시지가 출력된다")
        @ParameterizedTest
        @ValueSource(strings = {"abc", "123abc"})
        void inputNonNumericMoney(String input) {
            setInput(input);
            runConsoleTest(InputView::getMoney);
            assertThatOutputContains(ErrorMessage.INVALID_NUMBER_FORMAT);
        }

        @DisplayName("0 또는 음수를 금액으로 입력하면 에러 메시지가 출력된다")
        @Test
        void inputZeroOrNegativeMoney() {
            setInput("0");
            runConsoleTest(InputView::getMoney);
            assertThatOutputContains(ErrorMessage.INVALID_MONEY);

            setInput("-1000");
            runConsoleTest(InputView::getMoney);
            assertThatOutputContains(ErrorMessage.INVALID_MONEY);
        }

        @DisplayName("1000의 배수가 아닌 금액을 입력하면 에러 메시지가 출력된다")
        @Test
        void inputNonDivisibleByThousandMoney() {
            setInput("1500");
            runConsoleTest(InputView::getMoney);
            assertThatOutputContains(ErrorMessage.INVALID_MONEY);
        }
    }

    @Nested
    @DisplayName("당첨 번호 입력 테스트")
    class WinningTicketInputTests {

        @DisplayName("쉼표로 구분되지 않은 당첨 번호 입력 시 에러 메시지가 출력된다")
        @Test
        void inputWinningNumbersNotCommaSeparated() {
            setInput("1 2 3 4 5 6");
            runConsoleTest(InputView::getWinningNumbers);
            assertThatOutputContains(ErrorMessage.INVALID_NUMBERS);
        }

        @DisplayName("1~45 범위를 벗어난 당첨 번호를 입력 시 에러 메시지가 출력된다")
        @Test
        void inputWinningNumbersOutOfRange() {
            setInput("1,2,3,4,5,46");
            runConsoleTest(InputView::getWinningNumbers);
            assertThatOutputContains(ErrorMessage.INVALID_NUMBER_RANGE);
        }

        @DisplayName("중복된 당첨 번호 입력 시 에러 메시지가 출력된다")
        @Test
        void inputDuplicateWinningNumbers() {
            setInput("1,2,3,4,5,5");
            runConsoleTest(InputView::getWinningNumbers);
            assertThatOutputContains(ErrorMessage.DUPLICATED_NUMBERS_IN_LOTTO);
        }
    }

    @Nested
    @DisplayName("보너스 번호 입력 테스트")
    class BonusNumberInputTests {

        @DisplayName("보너스 번호로 숫자가 아닌 값을 입력 시 에러 메시지가 출력된다")
        @Test
        void inputNonNumericBonusNumber() {
            setInput("bonus");
            runConsoleTest(() -> InputView.getBonusNumber(List.of(1, 2, 3, 4, 5, 6)));
            assertThatOutputContains(ErrorMessage.INVALID_NUMBER_FORMAT);
        }

        @DisplayName("보너스 번호가 1~45 범위를 벗어나면 에러 메시지가 출력된다")
        @ParameterizedTest
        @ValueSource(strings = {"0", "46"})
        void inputBonusNumberOutOfRange(String input) {
            setInput(input);
            runConsoleTest(() -> InputView.getBonusNumber(List.of(1, 2, 3, 4, 5, 6)));
            assertThatOutputContains(ErrorMessage.INVALID_NUMBER_RANGE);
        }

        @DisplayName("보너스 번호가 당첨 번호와 중복되면 에러 메시지가 출력된다")
        @ParameterizedTest
        @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
        void inputDuplicateBonusNumberWithWinningNumbers(String input) {
            setInput(input);
            runConsoleTest(() -> InputView.getBonusNumber(List.of(1, 2, 3, 4, 5, 6)));
            assertThatOutputContains(ErrorMessage.DUPLICATED_BONUS_NUMBER);
        }
    }
}
