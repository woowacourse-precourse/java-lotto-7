package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ConsoleInputTest {

    private final InputStream originalIn = System.in;
    private ConsoleInput consoleInput;

    @BeforeEach
    void setUp() {
        consoleInput = new ConsoleInput();
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        consoleInput.close();
    }

    @Nested
    class 구입금액_입력_테스트 {

        @Test
        void 구입금액_정상_입력() {
            String input = "1000\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            String result = consoleInput.getPurchasedAmount();

            assertThat(result).isEqualTo("1000");
        }

        @Test
        void 구입금액_입력_실패() {
            System.setIn(new ByteArrayInputStream("".getBytes()));

            assertThatThrownBy(() -> consoleInput.getPurchasedAmount())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력을 받는데 실패했습니다.");
        }
    }

    @Nested
    class 당첨번호_입력_테스트 {

        @Test
        void 당첨번호_정상_입력() {
            String input = "1, 2, 3, 4, 5, 6\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            String result = consoleInput.getWinnerNumbers();

            assertThat(result).isEqualTo("1, 2, 3, 4, 5, 6");
        }

        @Test
        void 당첨번호_입력_실패() {
            System.setIn(new ByteArrayInputStream("".getBytes()));

            assertThatThrownBy(() -> consoleInput.getWinnerNumbers())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력을 받는데 실패했습니다.");
        }
    }

    @Nested
    class 보너스번호_입력_테스트 {

        @Test
        void 보너스번호_정상_입력() {
            String input = "7\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            String result = consoleInput.getBonusNumber();

            assertThat(result).isEqualTo("7");
        }

        @Test
        void 보너스번호_입력_실패() {
            System.setIn(new ByteArrayInputStream("".getBytes()));

            assertThatThrownBy(() -> consoleInput.getBonusNumber())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력을 받는데 실패했습니다.");
        }
    }
}
