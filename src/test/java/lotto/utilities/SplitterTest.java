package lotto.utilities;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

class SplitterTest {

    @Test
    void 입력된_문자열을_쉼표로_구분하여_리스트로_변환한다() {
        String winningNumbers = "1,2,3,4,5,6";
        List<String> expectedList = List.of("1", "2", "3", "4", "5", "6");

        List<String> result = Splitter.splitWinningNumbers(winningNumbers);

        assertThat(result).containsExactlyElementsOf(expectedList);
    }

    @Test
    void 빈_문자열을_입력하면_빈_리스트를_반환한다() {
        String emptyWinningNumbers = "";
        List<String> result = Splitter.splitWinningNumbers(emptyWinningNumbers);

        assertThat(result).isEmpty();
    }
}
