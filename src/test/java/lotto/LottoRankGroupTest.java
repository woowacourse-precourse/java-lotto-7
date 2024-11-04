package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankGroupTest {

    @Test
    void of() {
    }

    @Test
    void getInstructions() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoRankGroup lottoRankGroup = LottoRankGroup.of(new LottoGroup(List.of(lotto)), lotto, 7);
        assertThat(lottoRankGroup.getRankInstructions()).contains(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 1개",
                "총 수익률은 200,000,000.0%입니다."
        );
    }

    @Test
    void getRateOfRevenue() {
    }
}