package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Parser;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    @Test
    @DisplayName("올바른 구매 금액을 파싱한다")
    void 구매_금액_파싱() {
        Assertions.assertThat(Parser.parseCost("8000")).isEqualTo(8000);
    }

    @Test
    @DisplayName("쉼표로 구분된 당첨 번호를 파싱한다")
    void 당첨_번호_파싱() {
        assertThat(Parser.parseWinningNumbers("1,2,3,4,5,6"))
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("보너스 번호를 파싱한다")
    void 보너스_번호_파싱() {
        assertThat(Parser.parseBonusNumber("7")).isEqualTo(7);
    }
}
