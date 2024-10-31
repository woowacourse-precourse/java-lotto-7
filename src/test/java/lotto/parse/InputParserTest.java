package lotto.parse;

import static lotto.parse.InputParser.getParsedPurchaseAmount;
import static lotto.parse.InputParser.getParsedWinningNumbers;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void 문자열_구입_금액을_정수로_파싱() {
        String input = "8000";

        int parsedPurchaseAmount = getParsedPurchaseAmount(input);

        assertThat(parsedPurchaseAmount).isEqualTo(8000);
    }

    @Test
    void 문자열_로또_번호를_리스트로_파싱() {
        String input = "1,2,3,4,5,6";

        List<Integer> parsedWinningNumbers = getParsedWinningNumbers(input);

        assertThat(parsedWinningNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
