package lotto.model.result;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import lotto.model.lottery.Bonus;
import lotto.model.lottery.Lotto;
import lotto.model.lottery.MockPurchasedLotto;
import lotto.model.lottery.Winning;
import lotto.model.payment.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {
    private Result result;
    private Winning winning;
    private Bonus bonus;
    private MockPurchasedLotto purchasedLotto;

    @BeforeEach
    void setUp() {
        winning = Winning.from("1,2,3,4,5,6");
        bonus = Bonus.from("7");
        purchasedLotto = new MockPurchasedLotto(Payment.from("1000"));
    }

    @DisplayName("당첨 번호와 로또 번호가 6개 일치할 경우 1등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_여섯개_일치할_경우_1등에_당첨된다() {
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        result = Result.from(winning, bonus, purchasedLotto);

        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(Rank.FIRST), 1);
        assertEquals(winningDetails.get(Rank.SECOND), 0);
        assertEquals(winningDetails.get(Rank.THIRD), 0);
        assertEquals(winningDetails.get(Rank.FOURTH), 0);
        assertEquals(winningDetails.get(Rank.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 5개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 2등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_다섯개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_2등에_당첨된다() {
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        result = Result.from(winning, bonus, purchasedLotto);

        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(Rank.FIRST), 0);
        assertEquals(winningDetails.get(Rank.SECOND), 1);
        assertEquals(winningDetails.get(Rank.THIRD), 0);
        assertEquals(winningDetails.get(Rank.FOURTH), 0);
        assertEquals(winningDetails.get(Rank.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 5개 일치할 경우 3등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_다섯개_일치할_경우_3등에_당첨된다() {
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));

        result = Result.from(winning, bonus, purchasedLotto);

        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(Rank.FIRST), 0);
        assertEquals(winningDetails.get(Rank.SECOND), 0);
        assertEquals(winningDetails.get(Rank.THIRD), 1);
        assertEquals(winningDetails.get(Rank.FOURTH), 0);
        assertEquals(winningDetails.get(Rank.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 4개 일치할 경우 4등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_네개_일치할_경우_4등에_당첨된다() {
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));

        result = Result.from(winning, bonus, purchasedLotto);

        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(Rank.FIRST), 0);
        assertEquals(winningDetails.get(Rank.SECOND), 0);
        assertEquals(winningDetails.get(Rank.THIRD), 0);
        assertEquals(winningDetails.get(Rank.FOURTH), 1);
        assertEquals(winningDetails.get(Rank.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 4개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 4등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_네개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_4등에_당첨된다() {
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 7, 8)));

        result = Result.from(winning, bonus, purchasedLotto);

        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(Rank.FIRST), 0);
        assertEquals(winningDetails.get(Rank.SECOND), 0);
        assertEquals(winningDetails.get(Rank.THIRD), 0);
        assertEquals(winningDetails.get(Rank.FOURTH), 1);
        assertEquals(winningDetails.get(Rank.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 3개 일치할 경우 5등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_세개_일치할_경우_5등에_당첨된다() {
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));

        result = Result.from(winning, bonus, purchasedLotto);

        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(Rank.FIRST), 0);
        assertEquals(winningDetails.get(Rank.SECOND), 0);
        assertEquals(winningDetails.get(Rank.THIRD), 0);
        assertEquals(winningDetails.get(Rank.FOURTH), 0);
        assertEquals(winningDetails.get(Rank.FIFTH), 1);
    }

    @DisplayName("당첨 번호와 로또 번호가 3개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 5등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_세개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_5등에_당첨된다() {
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));

        result = Result.from(winning, bonus, purchasedLotto);

        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(Rank.FIRST), 0);
        assertEquals(winningDetails.get(Rank.SECOND), 0);
        assertEquals(winningDetails.get(Rank.THIRD), 0);
        assertEquals(winningDetails.get(Rank.FOURTH), 0);
        assertEquals(winningDetails.get(Rank.FIFTH), 1);
    }

    @DisplayName("당첨 번호와 로또 번호가 2개 일치할 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_두개_일치할_경우_당첨되지_않는다() {
        purchasedLotto.add(new Lotto(List.of(1, 2, 8, 9, 10, 11)));

        result = Result.from(winning, bonus, purchasedLotto);

        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(Rank.FIRST), 0);
        assertEquals(winningDetails.get(Rank.SECOND), 0);
        assertEquals(winningDetails.get(Rank.THIRD), 0);
        assertEquals(winningDetails.get(Rank.FOURTH), 0);
        assertEquals(winningDetails.get(Rank.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 2개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_두개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_당첨되지_않는다() {
        purchasedLotto.add(new Lotto(List.of(1, 2, 7, 8, 9, 10)));

        result = Result.from(winning, bonus, purchasedLotto);

        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(Rank.FIRST), 0);
        assertEquals(winningDetails.get(Rank.SECOND), 0);
        assertEquals(winningDetails.get(Rank.THIRD), 0);
        assertEquals(winningDetails.get(Rank.FOURTH), 0);
        assertEquals(winningDetails.get(Rank.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 1개 일치할 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_한개_일치할_경우_당첨되지_않는다() {
        purchasedLotto.add(new Lotto(List.of(1, 8, 9, 10, 11, 12)));

        result = Result.from(winning, bonus, purchasedLotto);

        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(Rank.FIRST), 0);
        assertEquals(winningDetails.get(Rank.SECOND), 0);
        assertEquals(winningDetails.get(Rank.THIRD), 0);
        assertEquals(winningDetails.get(Rank.FOURTH), 0);
        assertEquals(winningDetails.get(Rank.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 1개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_한개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_당첨되지_않는다() {
        purchasedLotto.add(new Lotto(List.of(1, 7, 8, 9, 10, 11)));

        result = Result.from(winning, bonus, purchasedLotto);

        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(Rank.FIRST), 0);
        assertEquals(winningDetails.get(Rank.SECOND), 0);
        assertEquals(winningDetails.get(Rank.THIRD), 0);
        assertEquals(winningDetails.get(Rank.FOURTH), 0);
        assertEquals(winningDetails.get(Rank.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 0개 일치할 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_영개_일치할_경우_당첨되지_않는다() {
        purchasedLotto.add(new Lotto(List.of(8, 9, 10, 11, 12, 13)));

        result = Result.from(winning, bonus, purchasedLotto);

        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(Rank.FIRST), 0);
        assertEquals(winningDetails.get(Rank.SECOND), 0);
        assertEquals(winningDetails.get(Rank.THIRD), 0);
        assertEquals(winningDetails.get(Rank.FOURTH), 0);
        assertEquals(winningDetails.get(Rank.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 0개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_영개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_당첨되지_않는다() {
        purchasedLotto.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        result = Result.from(winning, bonus, purchasedLotto);

        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(Rank.FIRST), 0);
        assertEquals(winningDetails.get(Rank.SECOND), 0);
        assertEquals(winningDetails.get(Rank.THIRD), 0);
        assertEquals(winningDetails.get(Rank.FOURTH), 0);
        assertEquals(winningDetails.get(Rank.FIFTH), 0);
    }

    @DisplayName("여러 등수에 동시에 당첨될 수 있다.")
    @Test
    void 여러_등수에_동시에_당첨될_수_있다() {
        purchasedLotto = new MockPurchasedLotto(Payment.from("14000"));

        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 7, 8)));
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
        purchasedLotto.add(new Lotto(List.of(1, 2, 7, 8, 9, 10)));
        purchasedLotto.add(new Lotto(List.of(1, 2, 8, 9, 10, 11)));
        purchasedLotto.add(new Lotto(List.of(1, 7, 8, 9, 10, 11)));
        purchasedLotto.add(new Lotto(List.of(1, 8, 9, 10, 11, 12)));
        purchasedLotto.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        purchasedLotto.add(new Lotto(List.of(8, 9, 10, 11, 12, 13)));

        result = Result.from(winning, bonus, purchasedLotto);

        Map<Rank, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(Rank.FIRST), 2);
        assertEquals(winningDetails.get(Rank.SECOND), 1);
        assertEquals(winningDetails.get(Rank.THIRD), 1);
        assertEquals(winningDetails.get(Rank.FOURTH), 2);
        assertEquals(winningDetails.get(Rank.FIFTH), 2);
    }
}
