package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningCheckerTest {
    private Lottos lottos;

    @BeforeEach
    @DisplayName("WinningChecker 초기화")
    void setUp() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),
                new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))
        );

        lottos = new Lottos(lottoList);
    }

    @Test
    @DisplayName("당첨 결과 계산 - 다양한 로또 번호")
    void testCalculateWinningResults() {
        // given
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 7;

        LottoResult lottoResult = new LottoResult();
        WinningChecker winningChecker = new WinningChecker(winningNumber, bonusNumber, lottoResult);

        winningChecker.calculate(lottos);

        // when & then
        HashMap<WinningInfo, Integer> result = lottoResult.getResult();
        assertEquals(1, result.get(WinningInfo.FIRST_WINNER));
        assertEquals(1, result.get(WinningInfo.SECOND_WINNER));
        assertEquals(1, result.get(WinningInfo.THIRD_WINNER));
        assertEquals(1, result.get(WinningInfo.NOT_MATCH));
        assertEquals(1, result.get(WinningInfo.FOURTH_WINNER));
        assertEquals(0, result.get(WinningInfo.FIFTH_WINNER));
    }

    @Test
    @DisplayName("당첨 번호가 없는 경우의 결과")
    void testCalculateWithNoWinningResults() {
        // given
        Lotto winningNumber = new Lotto(Arrays.asList(16, 17, 18, 19, 20, 21));
        Integer bonusNumber = 45;

        LottoResult lottoResult = new LottoResult();
        WinningChecker winningChecker = new WinningChecker(winningNumber, bonusNumber, lottoResult);

        // when
        winningChecker.calculate(lottos);

        // then
        HashMap<WinningInfo, Integer> result = lottoResult.getResult();
        assertEquals(0, result.get(WinningInfo.FIRST_WINNER));
        assertEquals(0, result.get(WinningInfo.SECOND_WINNER));
        assertEquals(0, result.get(WinningInfo.THIRD_WINNER));
        assertEquals(5, result.get(WinningInfo.NOT_MATCH));
    }
}
