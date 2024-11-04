package lotto.domain;

import static lotto.constants.LottoConstant.PROFIT_RATE;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import lotto.utils.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoProfitRateTest {
    private PurchasePrice purchasePrice;
    private LottoSystem lottoSystem;
    private Lottos lottos;
    private String winningNumbers;
    private String bonusNumber;

    @BeforeEach
    public void setUp() {
        purchasePrice = new PurchasePrice("3000");
        lottoSystem = new LottoSystem();

        lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7)), //5개 일치, 보너스 일치o
                new Lotto(Arrays.asList(1, 2, 3, 4, 7, 10)), //4개 일치
                new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)) //3개 일치
        ));

        winningNumbers = "1,2,3,4,5,6";
        bonusNumber = "7";
    }

    @DisplayName("구매가격에 대해 올바른 수익률을 반환한다.")
    @Test
    public void 구매가격에_대해_올바른_수익률을_반환한다() {
        Rank.resetCount();
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(Parser.parseWinningNumber(winningNumbers), bonusNumber);
        LottoProfitRate lottoProfitRate = lottoSystem.generateLottoResults(lottos,winningLottoNumber,purchasePrice);

        double expectedProfitSum = (30000000 * Rank.SECOND.getCount() + 5000 * Rank.FIFTH.getCount() + 50000 * Rank.FOURTH.getCount());
        double expectedProfitRate = expectedProfitSum / purchasePrice.getAmount() * PROFIT_RATE;
        assertEquals(expectedProfitRate, lottoProfitRate.getLottoProfitRate(), 0.1);
    }
}