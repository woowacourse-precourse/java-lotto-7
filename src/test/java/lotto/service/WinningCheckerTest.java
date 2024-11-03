package lotto.service;

import lotto.ErrorCode;
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
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "7";
        LottoResult lottoResult = new LottoResult();
        WinningChecker winningChecker = new WinningChecker(winningNumbers, bonusNumber, lottoResult);

        // when
        winningChecker.calculate(lottos);

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
        String winningNumbers = "16,17,18,19,20,21";
        String bonusNumber = "45";
        LottoResult lottoResult = new LottoResult();
        WinningChecker winningChecker = new WinningChecker(winningNumbers, bonusNumber, lottoResult);

        // when
        winningChecker.calculate(lottos);

        // then
        HashMap<WinningInfo, Integer> result = lottoResult.getResult();
        assertEquals(0, result.get(WinningInfo.FIRST_WINNER));
        assertEquals(0, result.get(WinningInfo.SECOND_WINNER));
        assertEquals(0, result.get(WinningInfo.THIRD_WINNER));
        assertEquals(5, result.get(WinningInfo.NOT_MATCH));
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호에 포함된 경우")
    void testBonusNumberIncludedInWinningNumbers() {
        // given
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "6";
        LottoResult lottoResult = new LottoResult();
        WinningChecker winningChecker = new WinningChecker(winningNumbers, bonusNumber, lottoResult);

        // when
        winningChecker.calculate(lottos);

        // then
        HashMap<WinningInfo, Integer> result = lottoResult.getResult();
        assertEquals(1, result.get(WinningInfo.FIRST_WINNER));
        assertEquals(0, result.get(WinningInfo.SECOND_WINNER));
        assertEquals(0, result.get(WinningInfo.THIRD_WINNER));
        assertEquals(4, result.get(WinningInfo.NOT_MATCH));
    }

    @Test
    @DisplayName("보너스 번호가 없는 경우")
    void testWithoutBonusNumber() {
        // given
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "";
        LottoResult lottoResult = new LottoResult();
        WinningChecker winningChecker = new WinningChecker(winningNumbers, bonusNumber, lottoResult);

        // when
        winningChecker.calculate(lottos);

        // then
        HashMap<WinningInfo, Integer> result = lottoResult.getResult();
        assertEquals(1, result.get(WinningInfo.FIRST_WINNER));
        assertEquals(0, result.get(WinningInfo.SECOND_WINNER));
        assertEquals(0, result.get(WinningInfo.THIRD_WINNER));
        assertEquals(4, result.get(WinningInfo.NOT_MATCH));
    }

    @Test
    @DisplayName("잘못된 형식의 당첨 번호 입력 시 예외 발생")
    void testInvalidWinningNumberFormat() {
        // given
        String winningNumbers = "1,2,3,4,5,6j";
        String bonusNumber = "7";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningChecker(winningNumbers, bonusNumber, new LottoResult());
        });
        assertEquals(ErrorCode.WIN_NUMBER_PROPER.getErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("중복된 당첨 번호 입력 시 예외 발생")
    void testDuplicateWinningNumbers() {
        // given
        String winningNumbers = "1,2,3,4,5,5"; // 중복된 번호
        String bonusNumber = "7";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningChecker(winningNumbers, bonusNumber, new LottoResult());
        });
        assertEquals(ErrorCode.WIN_NUMBER_DUPLICATE.getErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 보너스 번호 입력 시 예외 발생")
    void testInvalidBonusNumber() {
        // given
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "46";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningChecker(winningNumbers, bonusNumber, new LottoResult());
        });
        assertEquals(ErrorCode.BONUS_NUMBER_IN_RANGE.getErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("중복된 보너스 번호 입력 시 예외 발생")
    void testDuplicateBonusNumber() {
        // given
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "6";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningChecker(winningNumbers, bonusNumber, new LottoResult());
        });
        assertEquals(ErrorCode.BONUS_NUMBER_DUPLICATE.getErrorMessage(), exception.getMessage());
    }
}
