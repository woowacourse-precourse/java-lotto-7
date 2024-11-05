package lotto.io;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Rank;
import lotto.dto.WinningResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultParserTest {

    @DisplayName("WinningResult dto 객체를 문자열로 파싱한다.")
    @Test
    void 객체_파싱_테스트() {
        //given
        WinningResultParser parser = new WinningResultParser();
        WinningResult winningResult = getWinningResult();

        //when
        String result = parser.parseWinningResult(winningResult);

        //then
        Assertions.assertThat(result).isEqualTo(
                """
                                                
                        당첨 통계
                        ---
                        3개 일치 (5,000원) - 0개
                        4개 일치 (50,000원) - 0개
                        5개 일치 (1,500,000원) - 0개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
                        6개 일치 (2,000,000,000원) - 0개
                        총 수익률은 3,000,000.0%입니다."""
        );
    }

    private WinningResult getWinningResult() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        result.put(FIFTH, 0);
        result.put(FOURTH, 0);
        result.put(THIRD, 0);
        result.put(SECOND, 1);
        result.put(FIRST, 0);

        long prize = 30_000_000L;
        double rateOfReturn = 3000000.0;

        return WinningResult.of(result, prize, rateOfReturn);
    }
}