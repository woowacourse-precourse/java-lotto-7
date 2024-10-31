package lotto.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningNumbersInputViewTest {
    WinningNumbersInputView winningNumbersInputView;

    @BeforeEach
    void init() {
        winningNumbersInputView = new WinningNumbersInputView();
    }

    @Test
    void 당첨_번호를_쉼표를_기준으로_파싱한다() {
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> debugList = winningNumbersInputView.getWinningNumbers();
        assertThat(debugList)
                .isEqualTo(List.of("1", "2", "3", "4", "5", "6"));
    }
}
