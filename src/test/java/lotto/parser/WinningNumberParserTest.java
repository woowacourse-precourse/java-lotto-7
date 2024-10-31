package lotto.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberParserTest {
    @DisplayName("")
    @Test
    void parseWinningNumbers() {
        //given
        String rawWinningNumber = "1,2,3,4,5,6";

        //when
        List<Integer> winningNumbers = WinningNumberParser.parseRawWinningNumbers(rawWinningNumber);

        //then
        assertThat(winningNumbers).hasSize(6)
                .containsExactly(1, 2, 3, 4, 5, 6);
    }
}