package lotto.util;

import static lotto.util.Spliter.splitStringByDelimiter;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SpliterTest {
    @Test
    void 당첨번호_분할() {
        String winningNumbers = "1,2,3,4,5,6";
        List<String> expectedResult =List.of("1", "2", "3", "4", "5", "6");

        assertThat(splitStringByDelimiter(winningNumbers))
                .hasSize(expectedResult.size())
                .isEqualTo(expectedResult);
    }
}