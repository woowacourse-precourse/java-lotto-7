package lotto.application;

import lotto.Lotto;
import lotto.LottoPrize;
import lotto.dto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LottoWinningEvaluatorTest {


    @Test
    @DisplayName("로또 당첨 번호에 따른 결과 경우의 수 테스트")
    void calculatePrize() {
        LottoWinningEvaluator lottoWinningEvaluator = new LottoWinningEvaluator();
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        assertAll(
            // 1등 (6개 일치)
            () -> assertEquals(Optional.of(LottoPrize.SIX_MATCH),
                lottoWinningEvaluator.calculatePrize(new Lotto(List.of(1, 2, 3, 4, 5, 6)), winningLotto)),

            // 2등 (5개 일치 + 보너스 번호 일치)
            () -> assertEquals(Optional.of(LottoPrize.FIVE_MATCH_WITH_BONUS),
                lottoWinningEvaluator.calculatePrize(new Lotto(List.of(1, 2, 3, 4, 5, 7)), winningLotto)),

            // 3등 (5개 일치 + 보너스 번호 불일치)
            () -> assertEquals(Optional.of(LottoPrize.FIVE_MATCH),
                lottoWinningEvaluator.calculatePrize(new Lotto(List.of(1, 2, 3, 4, 5, 8)), winningLotto)),

            // 4등 (4개 일치)
            () -> assertEquals(Optional.of(LottoPrize.FOUR_MATCH),
                lottoWinningEvaluator.calculatePrize(new Lotto(List.of(1, 2, 3, 4, 8, 9)), winningLotto)),

            // 4등 (4개 일치 + 보너스 번호 일치)
            () -> assertEquals(Optional.of(LottoPrize.FOUR_MATCH),
                lottoWinningEvaluator.calculatePrize(new Lotto(List.of(1, 2, 3, 4, 7, 8)), winningLotto)),

            // 5등 (3개 일치)
            () -> assertEquals(Optional.of(LottoPrize.THREE_MATCH),
                lottoWinningEvaluator.calculatePrize(new Lotto(List.of(1, 2, 3, 8, 9, 10)), winningLotto)),

            // 5등 (3개 일치 + 보너스 번호 일치)
            () -> assertEquals(Optional.of(LottoPrize.THREE_MATCH),
                lottoWinningEvaluator.calculatePrize(new Lotto(List.of(1, 2, 3, 7, 8, 9)), winningLotto))
        );
    }
}