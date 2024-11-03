package lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.model.LottoResult;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @Test
    void 최종_결과_입력_검증() {
        //given
        List<LottoResult> results = List.of(LottoResult.valueOf(6,0));
        int amount = 10000;

        String expected = "3개 일치 (5,000원) - 0개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 1개\n"
                + "총 수익률은 20000000.0%입니다.";

        //when
        WinningStatistics winningStatistics = new WinningStatistics(results, amount);

        //then
        assertEquals(expected, winningStatistics.toFinalString());
    }
}