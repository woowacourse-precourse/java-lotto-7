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
        WinningChecker winningChecker = new WinningChecker(winningNumber, bonusNumber, lottoResult);

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
        WinningNumber winningNumber = new WinningNumber("16,17,18,19,20,21");
        BonusNumber bonusNumber = new BonusNumber("45", winningNumber);
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

    @Test
    @DisplayName("보너스 번호가 없는 경우")
    void testWithoutBonusNumber() {
        // given
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("", winningNumber);
        LottoResult lottoResult = new LottoResult();
        WinningChecker winningChecker = new WinningChecker(winningNumber, bonusNumber, lottoResult);

        // when
        winningChecker.calculate(lottos);

        // then

    }

    @Test
    @DisplayName("잘못된 형식의 당첨 번호 입력 시 예외 발생")
    void testInvalidWinningNumberFormat() {
        // given
        String winningNumbers = "1,2,3,4,5,6j";
        String bonusNumber = "7";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            WinningNumber winningNumber = new WinningNumber(winningNumbers);
            new WinningChecker(winningNumber, new BonusNumber(bonusNumber, winningNumber), new LottoResult());
        });
        assertEquals(ErrorCode.WIN_NUMBER_PROPER.getErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("중복된 당첨 번호 입력 시 예외 발생")
    void testDuplicateWinningNumbers() {
        // given
        String winningNumbers = "1,2,3,4,5,5";
        String bonusNumber = "7";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            WinningNumber winningNumber = new WinningNumber(winningNumbers);
            new WinningChecker(winningNumber, new BonusNumber(bonusNumber, winningNumber), new LottoResult());
        });
        assertEquals(ErrorCode.WIN_NUMBER_DUPLICATE.getErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 보너스 번호 입력 시 예외 발생")
    void testInvalidBonusNumber() {
        // given
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("46", winningNumber);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningChecker(winningNumber, bonusNumber, new LottoResult());
        });
        assertEquals(ErrorCode.BONUS_NUMBER_IN_RANGE.getErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("중복된 보너스 번호 입력 시 예외 발생")
    void testDuplicateBonusNumber() {
        // given
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("6", winningNumber);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningChecker(winningNumber, bonusNumber, new LottoResult());
        });
        assertEquals(ErrorCode.BONUS_NUMBER_DUPLICATE.getErrorMessage(), exception.getMessage());
    }
}
