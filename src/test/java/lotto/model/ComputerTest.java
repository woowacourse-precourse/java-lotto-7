package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.config.LottoConfig;
import lotto.config.RankType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {
    private static final List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final int BONUS_NUMBER = 7;
    private static final int PURCHASE_QUANTITY = 1;
    private static final int ONE_HUNDRED = 100;

    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer(WINNING_NUMBERS);
        computer.setBonusNumber(BONUS_NUMBER);
    }

    @Test
    void 당첨_로또_발행() {
        Lotto winningLotto = computer.getWinningLotto();

        assertEquals(WINNING_NUMBERS, winningLotto.getNumbers());
    }

    @Test
    void 보너스_번호_설정() {
        assertEquals(BONUS_NUMBER, computer.getBonusNumber());
    }

    @Test
    void 로또_비교_1등() {
        Lotto lotto = new Lotto(WINNING_NUMBERS);
        computer.compareLotto(List.of(lotto));

        assertEquals(1, computer.getResults().get(RankType.FIRST.getRank()));
    }

    @Test
    void 로또_비교_2등_보너스_포함() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, BONUS_NUMBER));
        computer.compareLotto(List.of(lotto));

        assertEquals(1, computer.getResults().get(RankType.SECOND.getRank()));
    }

    @Test
    void 로또_비교_3등_보너스_미포함() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        computer.compareLotto(List.of(lotto));

        assertEquals(1, computer.getResults().get(RankType.THIRD.getRank()));
    }

    @Test
    void 로또_비교_4등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        computer.compareLotto(List.of(lotto));

        assertEquals(1, computer.getResults().get(RankType.FOURTH.getRank()));
    }

    @Test
    void 로또_비교_5등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        computer.compareLotto(List.of(lotto));

        assertEquals(1, computer.getResults().get(RankType.FIFTH.getRank()));
    }

    @Test
    void 수익률_계산() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        computer.compareLotto(List.of(lotto));

        float expectedReturn = RankType.FIFTH.getMoney();
        float purchaseAmount = PURCHASE_QUANTITY * LottoConfig.PRICE.getNumber();
        float expectedRateOfReturn = (expectedReturn / purchaseAmount) * ONE_HUNDRED;

        float rateOfReturn = computer.calculateRateOfReturn(PURCHASE_QUANTITY);

        assertEquals(expectedRateOfReturn, rateOfReturn, 0.01);
    }
}