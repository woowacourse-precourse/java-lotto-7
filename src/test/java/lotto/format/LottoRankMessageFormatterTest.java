package lotto.format;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoRank.*;

class LottoRankMessageFormatterTest {

    @Test
    void 당첨_통계_출력() {
        //given
        List<LottoRank> lottoRanks = List.of(SECOND, THIRD, FOURTH, FIFTH, FIFTH, NO_RANK);

        //when
        String format = new LottoRankMessageFormatter().format(lottoRanks);

        //then
        System.out.println(format);
    }
}