package lotto;

import lotto.util.Parser;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {
    @Test
    void 구입_금액_파싱() {
        int purchaseAmount = Parser.purchaseAmountParser("1000");
        assertThat(purchaseAmount).isEqualTo(1000);
    }

    @Test
    void 구입_금액_예외() {
        assertThatThrownBy(() -> Parser.purchaseAmountParser("AAA"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_파싱() {
        List<Integer> winningNums = Parser.winningNumsParser("1,2,3,4,5,6");
        assertThat(winningNums).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 당첨_번호_예외() {
        assertThatThrownBy(() -> Parser.winningNumsParser("1,2,3,4,5,AAA"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_파싱() {
        int bonusNum = Parser.bonusNumParser("7");
        assertThat(bonusNum).isEqualTo(7);
    }

    @Test
    void 보너스_번호_예외() {
        assertThatThrownBy(() -> Parser.winningNumsParser("AAA"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
