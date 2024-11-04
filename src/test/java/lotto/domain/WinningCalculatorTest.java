package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningCalculatorTest {
    private WinningCalculator winningCalculator;
    private PurchaseLottos purchaseLottos;
    private Lotto winningLotto;

    @BeforeEach
    public void beforeEach() {
        winningCalculator = new WinningCalculator();
        purchaseLottos = new PurchaseLottos();
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        purchaseLottos.saveAll(lottos);
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void 로또저장_테스트() {
        winningCalculator.saveLottos(purchaseLottos);
        assertThat(winningCalculator).isNotNull();
    }

    @Test
    public void 당첨로또저장_테스트() {
        winningCalculator.saveWinningLotto(winningLotto);
        assertThat(winningLotto).isNotNull();
    }

    @Test
    public void 보너스번호저장_유효한경우_테스트() {
        winningCalculator.saveWinningLotto(winningLotto);
        assertDoesNotThrow(() -> winningCalculator.saveBonusNumber(7));
    }

    @Test
    public void 보너스번호저장_중복예외_테스트() {
        winningCalculator.saveWinningLotto(winningLotto);
        assertThatThrownBy(() -> winningCalculator.saveBonusNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 계산_테스트() {
        winningCalculator.saveLottos(purchaseLottos);
        winningCalculator.saveWinningLotto(winningLotto);
        winningCalculator.saveBonusNumber(7);
        WinningResult result = winningCalculator.calculate();

        assertThat(result).isNotNull();
        assertThat(result.getResult().get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.getResult().get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.getResult().get(Rank.THIRD)).isEqualTo(1);
        assertThat(result.getResult().get(Rank.FOURTH)).isEqualTo(0);
        assertThat(result.getResult().get(Rank.FIFTH)).isEqualTo(0);
    }
}

