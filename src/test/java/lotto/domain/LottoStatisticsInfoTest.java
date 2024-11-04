package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoStatisticsInfoTest {

    @Test
    void 통계출력_테스트() {
        final LottoStatisticsInfo lottoStatisticsInfo = new LottoStatisticsInfo("3개 일치", 5000000, 400);

        Assertions.assertThat(lottoStatisticsInfo.toString())
                .isEqualTo("3개 일치 (5,000,000원) - 400개");
    }
}