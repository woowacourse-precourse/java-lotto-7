package lotto.service;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    public void 로또구매개수세기() {
        int purchaseAmount = 8000;
        int expectedCount = 8;

        int actualCount = lottoService.countLotto(purchaseAmount);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void 매치번호세기() {
        int[] winningNumbers = {1, 2, 3, 4, 5, 6};
        ArrayList<Integer> purchasedNumbers = new ArrayList<>();
        purchasedNumbers.add(1);
        purchasedNumbers.add(2);
        purchasedNumbers.add(7);
        purchasedNumbers.add(8);
        purchasedNumbers.add(9);
        purchasedNumbers.add(10);

        int expectedMatchCount = 2; 
        int actualMatchCount = lottoService.countMatchNumber(winningNumbers, purchasedNumbers);

        assertEquals(expectedMatchCount, actualMatchCount);
    }

    @Test
    public void 보너스번호체크() {
        int bonusNumber = 7;
        ArrayList<Integer> purchasedNumbers = new ArrayList<>();
        purchasedNumbers.add(1);
        purchasedNumbers.add(2);
        purchasedNumbers.add(3);
        purchasedNumbers.add(4);
        purchasedNumbers.add(5);
        purchasedNumbers.add(6);

        boolean hasBonusMatch = lottoService.checkBonusNumber(bonusNumber, purchasedNumbers);

        assertTrue(!hasBonusMatch); 
    }

    @Test
    public void 수익률계산() {
    HashMap<Integer, Integer> winningRecord = new HashMap<>();
    winningRecord.put(5, 1); 

    int purchaseAmount = 8000;
    double expectedProfitMargin = (5000 / (double) purchaseAmount) * 100;

    double actualProfitMargin = lottoService.calculateProfitMargin(winningRecord, purchaseAmount);

    assertEquals(expectedProfitMargin, actualProfitMargin);
    }
}