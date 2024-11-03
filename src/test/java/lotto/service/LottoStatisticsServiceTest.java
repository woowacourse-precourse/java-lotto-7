package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.User;
import org.junit.jupiter.api.Test;

class LottoStatisticsServiceTest {
    private final LottoStatisticsService lottoStatisticsService = new LottoStatisticsService();

    @Test
    void 수익률_계산_테스트() {
        User user = new User(new PurchaseAmount("1000"));
        int totalPrice = 5000;

        String winningYield = lottoStatisticsService.getWinningYield(user, totalPrice);
        assertEquals(winningYield, "500.0");
    }

    @Test
    void 로또_번호_적중_테스트() {
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        int expectedMatchCount = 5;

        int matchCount = lottoStatisticsService.countMatchingNumbers(userNumbers, winningNumbers);

        assertEquals(expectedMatchCount, matchCount);
    }

    @Test
    void 로또_번호_매칭_5개_및_보너스_번호_테스트() {
        int matchCount = 5;
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(8);
        int bonusNumber = 6;
        Lotto lotto = new Lotto(lottoNumbers);
        lotto.createBonusNumber(bonusNumber);
        boolean expectedMatchCount = true;

        boolean result = lottoStatisticsService.isFiveMatchesWithBonus(matchCount, userNumbers,
                bonusNumber);

        assertEquals(expectedMatchCount, result);
    }

    @Test
    void 로또_번호_매칭_5개_테스트() {
        int matchCount = 5;
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(8);
        int bonusNumber = 10;
        Lotto lotto = new Lotto(lottoNumbers);
        lotto.createBonusNumber(bonusNumber);
        boolean expectedMatchCount = true;

        boolean result = lottoStatisticsService.isFiveMatchesOnly(matchCount, userNumbers,
                bonusNumber);

        assertEquals(expectedMatchCount, result);
    }
}