package lotto.model;

import static lotto.config.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import lotto.config.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticTest {

    @DisplayName("당첨 번호 매칭 개수와 보너스 포함 여부에 따라 통계 생성 결과를 반환합니다.")
    @Test
    void 당첨_번호_매칭_개수와_보너스_번호_포함_여부에_따라_통계를_산출() {
        List<Integer> matchedCounts = List.of(3, 4, 5, 5, 6);
        List<Boolean> bonusNumberIncludedFlags = List.of(false, false, false, true, false);

        Statistic statistic = Statistic.createStatistic(matchedCounts, bonusNumberIncludedFlags);

        Map<LottoRank, Integer> result = statistic.getStatisticResult();
        assertThat(result.get(FOURTH_RANK)).isEqualTo(1);
        assertThat(result.get(THIRD_RANK)).isEqualTo(1);
        assertThat(result.get(SECOND_RANK)).isEqualTo(1);
        assertThat(result.get(FIRST_RANK)).isEqualTo(1);
        assertThat(result.get(FIFTH_RANK)).isEqualTo(1);
    }
}