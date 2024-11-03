package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {
    private Result result;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;
    private SpyLottoIssuer lottoIssuer;

    @BeforeEach
    void setUp() {
        result = new Result();
        winningNumber = WinningNumber.from("1,2,3,4,5,6");
        bonusNumber = BonusNumber.from("7");
        lottoIssuer = new SpyLottoIssuer(Price.from("1000"));
    }

    @DisplayName("당첨 번호와 로또 번호가 6개 일치할 경우 1등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_여섯개_일치할_경우_1등에_당첨된다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 0);

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 1);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 5개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 2등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_다섯개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_2등에_당첨된다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 5, 7)), 0);

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 1);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 5개 일치할 경우 3등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_다섯개_일치할_경우_3등에_당첨된다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 5, 8)), 0);

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 1);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 4개 일치할 경우 4등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_네개_일치할_경우_4등에_당첨된다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 8, 9)), 0);

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 1);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 4개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 4등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_네개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_4등에_당첨된다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 7, 8)), 0);

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 1);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 3개 일치할 경우 5등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_세개_일치할_경우_5등에_당첨된다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 8, 9, 10)), 0);

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 1);
    }

    @DisplayName("당첨 번호와 로또 번호가 3개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 5등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_세개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_5등에_당첨된다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 7, 8, 9)), 0);

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 1);
    }

    @DisplayName("당첨 번호와 로또 번호가 2개 일치할 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_두개_일치할_경우_당첨되지_않는다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 8, 9, 10, 11)), 0);

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 2개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_두개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_당첨되지_않는다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 7, 8, 9, 10)), 0);

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 1개 일치할 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_한개_일치할_경우_당첨되지_않는다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 8, 9, 10, 11, 12)), 0);

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 1개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_한개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_당첨되지_않는다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 7, 8, 9, 10, 11)), 0);

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 0개 일치할 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_영개_일치할_경우_당첨되지_않는다() {
        lottoIssuer.setLottos(new Lotto(List.of(8, 9, 10, 11, 12, 13)), 0);

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("당첨 번호와 로또 번호가 0개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_영개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_당첨되지_않는다() {
        lottoIssuer.setLottos(new Lotto(List.of(7, 8, 9, 10, 11, 12)), 0);

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("여러 등수에 동시에 당첨될 수 있다.")
    @Test
    void 여러_등수에_동시에_당첨될_수_있다() {
        result = new Result();
        lottoIssuer = new SpyLottoIssuer(Price.from("14000"));

        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 0);
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 5, 7)), 1);
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 2);
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 5, 8)), 3);
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 7, 8)), 4);
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 8, 9)), 5);
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 7, 8, 9)), 6);
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 8, 9, 10)), 7);
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 7, 8, 9, 10)), 8);
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 8, 9, 10, 11)), 9);
        lottoIssuer.setLottos(new Lotto(List.of(1, 7, 8, 9, 10, 11)), 10);
        lottoIssuer.setLottos(new Lotto(List.of(1, 8, 9, 10, 11, 12)), 11);
        lottoIssuer.setLottos(new Lotto(List.of(7, 8, 9, 10, 11, 12)), 12);
        lottoIssuer.setLottos(new Lotto(List.of(8, 9, 10, 11, 12, 13)), 13);

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 2);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 1);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 1);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 2);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 2);
    }
}
