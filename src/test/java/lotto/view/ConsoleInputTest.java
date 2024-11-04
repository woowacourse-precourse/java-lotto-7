package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.view.InputProvider.MockInputProvider;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ConsoleInputTest {

    @Nested
    class 구입금액_입력_테스트 {

        @Test
        void 성공__구입금액_입력() {
            // given
            List<String> inputs = List.of("1000");
            String expect = "1000";

            // when
            ConsoleInput consoleInput = new ConsoleInput(new MockInputProvider(inputs));
            String result = consoleInput.getPurchasedAmount();

            // then
            assertThat(result).isEqualTo(expect);
        }

        @Test
        void 성공__구입금액_빈문자열() {
            List<String> inputs = List.of("");
            String expect = "";

            // when
            ConsoleInput consoleInput = new ConsoleInput(new MockInputProvider(inputs));
            String result = consoleInput.getPurchasedAmount();

            assertThat(result).isEqualTo(expect);
        }

    }

    @Nested
    class 당첨번호_입력_테스트 {

        @Test
        void 성공__당첨번호_입력() {
            List<String> inputs = List.of("1, 2, 3, 4, 5, 6");
            String expect = "1, 2, 3, 4, 5, 6";

            // when
            ConsoleInput consoleInput = new ConsoleInput(new MockInputProvider(inputs));
            String result = consoleInput.getWinningNumbers();

            // then
            assertThat(result).isEqualTo(expect);
        }

        @Test
        void 성공__당첨번호_빈문자열() {
            List<String> inputs = List.of("");
            String expect = "";

            // when
            ConsoleInput consoleInput = new ConsoleInput(new MockInputProvider(inputs));
            String result = consoleInput.getWinningNumbers();

            // then
            assertThat(result).isEqualTo(expect);
        }
    }

    @Nested
    class 보너스번호_입력_테스트 {

        @Test
        void 성공__보너스번호_입력() {
            List<String> inputs = List.of("1");
            String expect = "1";

            // when
            ConsoleInput consoleInput = new ConsoleInput(new MockInputProvider(inputs));
            String result = consoleInput.getBonusNumber();

            // then
            assertThat(result).isEqualTo(expect);
        }

        @Test
        void 성공__보너스번호_입력_빈문자열() {
            List<String> inputs = List.of("1");
            String expect = "1";

            // when
            ConsoleInput consoleInput = new ConsoleInput(new MockInputProvider(inputs));
            String result = consoleInput.getBonusNumber();

            // then
            assertThat(result).isEqualTo(expect);
        }
    }
}
