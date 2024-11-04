package lotto.service.domain.lottoresult;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import lotto.service.domain.lotto.Lotto;
import lotto.service.domain.lotto.LottoBuyer;
import lotto.service.domain.lotto.LottoNumber;
import lotto.service.domain.lotto.LottoReward;
import lotto.service.domain.money.Budget;
import lotto.service.domain.money.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoWinCalculatorTest {

    private LottoWinNumber lottoWinNumber;
    private Money budget;
    private List<Lotto> purchasedLotto;
    private LottoBuyer lottoBuyer;

    @BeforeEach
    public void 셋업() {
        lottoWinNumber = new LottoWinNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
        budget = new Budget(0);
        purchasedLotto = Arrays.asList(
                new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(1,2,3,4,5,7)),
                new Lotto(Arrays.asList(1,2,3,4,5,10)),
                new Lotto(Arrays.asList(1,2,3,4,11,10)),
                new Lotto(Arrays.asList(1,2,3,12,11,10))
        );
        lottoBuyer = new LottoBuyer(purchasedLotto,budget);

    }

    @Test
    public void 일등로또_반환_체크() {
        List<LottoReward> test = LottoWinCalculator.calculateReward(lottoBuyer,lottoWinNumber);

        assertTrue(test.contains(LottoReward.FIRST), "[ERROR] : 있어야할 LottoReward.FIRST가 없습니다.");
    }
}