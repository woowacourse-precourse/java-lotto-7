package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ParserTest {
    Parser parser = new Parser();

    @Test
    void 구매_금액_파싱() {
        assertThat(parser.parsePurchaseAmount("1000"))
                .isEqualTo(1000);
    }

    @Test
    void 당첨_번호_파싱() {
        assertThat(parser.parseWinningNumbers("1,2,3,4,5,6"))
                .isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    void 보너스_번호_파싱() {
        assertThat(parser.parseBonusNumber("15"))
                .isEqualTo(15);
    }
}