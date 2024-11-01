package lotto;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    void findByCorrectCountAndBonusBall() {
        assertThat(LottoRank.findByCorrectCountAndBonusBall(1, TRUE)).isEqualTo(LottoRank.BLANK);
        assertThat(LottoRank.findByCorrectCountAndBonusBall(2, TRUE)).isEqualTo(LottoRank.BLANK);
        assertThat(LottoRank.findByCorrectCountAndBonusBall(5, TRUE)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.findByCorrectCountAndBonusBall(6, FALSE)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void getCondition() {
        assertThat(LottoRank.FIRST.getCondition()).isEqualTo("6개 일치");
        assertThat(LottoRank.SECOND.getCondition()).isEqualTo("5개 일치, 보너스 볼 일치");
    }

    @Test
    void getPrice() {
        assertThat(LottoRank.FIRST.getPrice()).isEqualTo(2_000_000_000);
    }
}