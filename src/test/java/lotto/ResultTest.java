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
        bonusNumber = BonusNumber.from("7", winningNumber);
        lottoIssuer = new SpyLottoIssuer(1000);
    }

    @DisplayName("6개의 번호가 일치할 경우 1등에 당첨된다.")
    @Test
    void 여섯개의_번호가_일치할_경우_1등에_당첨된다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 1);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("5개의 번호와 보너스 번호가 일치할 경우 2등에 당첨된다.")
    @Test
    void 다섯개의_번호와_보너스_번호가_일치할_경우_2등에_당첨된다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 1);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("5개의 번호가 일치할 경우 3등에 당첨된다.")
    @Test
    void 다섯개의_번호가_일치할_경우_3등에_당첨된다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 5, 8)));

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 1);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("4개의 번호가 일치할 경우 4등에 당첨된다.")
    @Test
    void 네개의_번호가_일치할_경우_4등에_당첨된다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 8, 9)));

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 1);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("4개의 번호와 보너스 번호가 일치할 경우 4등에 당첨된다.")
    @Test
    void 네개의_번호와_보너스_번호가_일치할_경우_4등에_당첨된다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 4, 7, 8)));

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 1);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("3개의 번호가 일치할 경우 5등에 당첨된다.")
    @Test
    void 세개의_번호가_일치할_경우_5등에_당첨된다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 8, 9, 10)));

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 1);
    }

    @DisplayName("3개의 번호와 보너스 번호가 일치할 경우 5등에 당첨된다.")
    @Test
    void 세개의_번호와_보너스_번호가_일치할_경우_5등에_당첨된다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 3, 7, 8, 9)));

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 1);
    }

    @DisplayName("2개의 번호가 일치할 경우 당첨되지 않는다.")
    @Test
    void 두개의_번호가_일치할_경우_당첨되지_않는다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 8, 9, 10, 11)));

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("2개의 번호와 보너스 번호가 일치할 경우 당첨되지 않는다.")
    @Test
    void 두개의_번호와_보너스_번호가_일치할_경우_당첨되지_않는다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 2, 7, 8, 9, 10)));

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("1개의 번호가 일치할 경우 당첨되지 않는다.")
    @Test
    void 한개의_번호가_일치할_경우_당첨되지_않는다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 8, 9, 10, 11, 12)));

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("1개의 번호와 보너스 번호가 일치할 경우 당첨되지 않는다.")
    @Test
    void 한개의_번호와_보너스_번호가_일치할_경우_당첨되지_않는다() {
        lottoIssuer.setLottos(new Lotto(List.of(1, 7, 8, 9, 10, 11)));

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }

    @DisplayName("보너스 번호만 일치할 경우 당첨되지 않는다.")
    @Test
    void 보너스_번호만_일치할_경우_당첨되지_않는다() {
        lottoIssuer.setLottos(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }


    @DisplayName("번호가 하나도 일치하지 않을 경우 당첨되지 않는다.")
    @Test
    void 번호가_하나도_일치하지_않을_경우_당첨되지_않는다() {
        lottoIssuer.setLottos(new Lotto(List.of(8, 9, 10, 11, 12, 13)));

        result.calculate(winningNumber, bonusNumber, lottoIssuer);

        Map<WinningCondition, Integer> winningDetails = result.getWinningDetails();
        assertEquals(winningDetails.get(WinningCondition.FIRST), 0);
        assertEquals(winningDetails.get(WinningCondition.SECOND), 0);
        assertEquals(winningDetails.get(WinningCondition.THIRD), 0);
        assertEquals(winningDetails.get(WinningCondition.FOURTH), 0);
        assertEquals(winningDetails.get(WinningCondition.FIFTH), 0);
    }
}
