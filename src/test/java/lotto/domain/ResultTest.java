package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @Test
    void 로또_1등_테스트() {
        Result result = Result.getResult();
        result.addWinPrize(Ranking.FIRST);
        result.addWinCount(Ranking.FIRST);

        assertThat(result.getWinPrize()).isEqualTo(2_000_000_000);
        assertThat(result.getWinCount(Ranking.FIRST)).isEqualTo(1);
    }

    @Test
    void 로또_3등_3번_테스트() {
        Result result = Result.getResult();
        for(int i=0; i<3; i++) {
            result.addWinPrize(Ranking.FIFTH);
            result.addWinCount(Ranking.FIFTH);
        }

        for(Ranking ranking : Ranking.values()) {
            if(ranking == Ranking.FIFTH) {
                assertThat(result.getWinCount(Ranking.FIFTH)).isEqualTo(3);
                continue;
            }
            assertThat(result.getWinCount(ranking)).isEqualTo(0);
        }

        assertThat(result.getWinPrize()).isEqualTo(15_000);
    }
}