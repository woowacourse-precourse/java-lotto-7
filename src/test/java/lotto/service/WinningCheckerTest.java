package lotto.service;

import lotto.ErrorCode;
import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
    @DisplayName("당첨 결과 계산 - 당첨 번호와 보너스 번호가 주어질 때")
    void testCalculateWinningResults() {
        // given
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumber);
        LottoResult lottoResult = new LottoResult();
        WinningChecker winningChecker = new WinningChecker(lottoResult);

        // when
        winningChecker.calculate(lottos, winningNumber, bonusNumber);

        // then
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
        WinningNumber winningNumber = new WinningNumber("16,17,18,19,20,21");
        BonusNumber bonusNumber = new BonusNumber("45", winningNumber);
        LottoResult lottoResult = new LottoResult();
        WinningChecker winningChecker = new WinningChecker(lottoResult);

        // when
        winningChecker.calculate(lottos, winningNumber, bonusNumber);

        // then
        HashMap<WinningInfo, Integer> result = lottoResult.getResult();
        assertEquals(0, result.get(WinningInfo.FIRST_WINNER));
        assertEquals(0, result.get(WinningInfo.SECOND_WINNER));
        assertEquals(0, result.get(WinningInfo.THIRD_WINNER));
        assertEquals(5, result.get(WinningInfo.NOT_MATCH));
    }
}
