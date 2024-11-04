package lotto;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParserTest {

    @Test
    public void 쉼표를_기준으로_숫자를_분리한다() {
        List<Integer> winningNumbers = new ArrayList<>();
        String inputWinningNumbers = "1,   2,3,4,5,6";
        for (String winningNumber : inputWinningNumbers.split(",")) {
            winningNumbers.add(Integer.parseInt(winningNumber.trim()));
        }
        assertThat(winningNumbers)
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
