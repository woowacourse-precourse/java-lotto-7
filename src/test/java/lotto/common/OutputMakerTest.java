package lotto.common;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.dto.LottosDto;
import lotto.dto.WinningResultDto;
import lotto.view.OutputMaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OutputMakerTest {
    @Test
    void 구매현황_생성() {
        //given
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.addLotto(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        LottosDto dto = new LottosDto(lottos);
        String expected = "\n2개를 구매했습니다.\n"
                + "[1, 2, 3, 4, 5, 6]\n"
                + "[7, 8, 9, 10, 11, 12]\n";

        // when
        String overview = OutputMaker.makePurchaseOverview(dto);

        //then
        assertThat(overview).isEqualTo(expected);
    }

    @Test
    void 당첨통계_생성() {
        //given
        Map<LottoRank, Integer> scores = new EnumMap<>(LottoRank.class);
        scores.put(LottoRank.FiFTH, 1);
        WinningResultDto dto = new WinningResultDto(scores, 25.0);
        String expected = "\n당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 25.0%입니다.";
        //when
        String result = OutputMaker.makeFinalResult(dto);
        //then
        assertThat(result).isEqualTo(expected);
    }
}
