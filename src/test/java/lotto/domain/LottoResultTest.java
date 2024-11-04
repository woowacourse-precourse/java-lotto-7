package lotto.domain;

import lotto.domain.enums.LottoRank;
import lotto.domain.enums.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import java.util.List;

public class LottoResultTest {

    private static final Lotto LOTTO_1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private static final Lotto LOTTO_2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
    private static final Lotto LOTTO_3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
    private static final Lotto LOTTO_4 = new Lotto(List.of(1, 2, 3, 4, 8, 9));
    private static final Lotto LOTTO_5 = new Lotto(List.of(1, 2, 3, 8, 9, 10));
    private static final Lotto LOTTO_6 = new Lotto(List.of(10, 11, 12, 13, 14, 15));

    private static final Lotto WINNING_LOTTO = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private static final int BONUS_NUMBER = 7;

    private static final LottoDraw LOTTO_DRAW = LottoDraw.of(WINNING_LOTTO, BONUS_NUMBER);

    private static final List<MatchResult> MATCH_RESULTS = List.of(
            MatchResult.of(LOTTO_1, LOTTO_DRAW),
            MatchResult.of(LOTTO_2, LOTTO_DRAW),
            MatchResult.of(LOTTO_3, LOTTO_DRAW),
            MatchResult.of(LOTTO_4, LOTTO_DRAW),
            MatchResult.of(LOTTO_5, LOTTO_DRAW),
            MatchResult.of(LOTTO_6, LOTTO_DRAW)
    );

    private static final LottoResult lottoResult = LottoResult.of(MATCH_RESULTS);

    @Test
    @DisplayName("로또 결과 생성 및 각 등수에 대한 결과 확인")
    void createLottoResultAndCheckRankCount() {
        EnumMap<LottoRank, Integer> resultMap = lottoResult.getRankResult();
        assertEquals(1, resultMap.get(LottoRank.FIRST));
        assertEquals(1, resultMap.get(LottoRank.SECOND));
        assertEquals(1, resultMap.get(LottoRank.THIRD));
        assertEquals(1, resultMap.get(LottoRank.FOURTH));
        assertEquals(1, resultMap.get(LottoRank.FIFTH));
        assertEquals(1, resultMap.get(LottoRank.NONE));
    }

    @Test
    @DisplayName("총 상금 계산")
    void calculateTotalPrize() {
        long totalPrize = lottoResult.calculateTotalPrize();

        int expectedTotalPrize = LottoPrize.FIRST_PRIZE.getPrize() +
                LottoPrize.SECOND_PRIZE.getPrize() +
                LottoPrize.THIRD_PRIZE.getPrize() +
                LottoPrize.FOURTH_PRIZE.getPrize() +
                LottoPrize.FIFTH_PRIZE.getPrize();
        assertEquals(expectedTotalPrize, totalPrize);
    }
}
