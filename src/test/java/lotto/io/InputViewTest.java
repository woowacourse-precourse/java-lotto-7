package lotto.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lotto.domain.PurchaseAmount;
import lotto.error.ErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        Reader mockReader = new SequentialReader();
        inputView = new InputView(mockReader);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void 빈칸예외_후_정상입력() {
        // when
        PurchaseAmount result = inputView.inputPurchaseAmount();

        // then
        assertThat(outContent.toString()).contains(ErrorCode.BLANK_INPUT_MESSAGE.getMessage());
        assertThat(result).isNotNull();
        assertThat(result.getAmount()).isEqualTo(1000);
    }

    public static class SequentialReader implements Reader {
        private int callCount = 0;

        @Override
        public String readLine() {
            if (callCount == 0) {
                callCount++;
                return "";
            }
            return "1000";
        }

        @Override
        public void close() {
            // 리소스 해제가 필요하지 않다면 구현할 내용 없음
        }
    }
}