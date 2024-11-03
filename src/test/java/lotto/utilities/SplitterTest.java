package lotto.utilities;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class SplitterTest {

    @Test
    void 입력된_문자열을_쉼표로_구분하여_리스트로_변환한다() {
        String winningNumbers = "1,2,3,4,5,6";
        List<String> expectedList = List.of("1", "2", "3", "4", "5", "6");

        List<String> result = Splitter.splitWinningNumbers(winningNumbers);

        assertThat(result).containsExactlyElementsOf(expectedList);
    }
}
