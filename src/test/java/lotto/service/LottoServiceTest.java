package lotto.service;

import lotto.enums.WinningStatistics;
import lotto.model.Lotto;
import lotto.model.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
        for (WinningStatistics stat : WinningStatistics.values()) {
            stat.setCount(0);
        }
    }

    @DisplayName("로또를 발행한다.")
    @Test
    void 로또를_발행한다() {
        Money money = new Money(5000);
        Lotto[] issuedLottos = lottoService.issueLotto(money);

        assertThat(issuedLottos).hasSize(5);
        for (Lotto lotto: issuedLottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
        }
    }

    @DisplayName("발행된 로또 번호와 당첨 번호의 매칭된 번호를 카운트한다.")
    @Test
    void 발행된_로또_번호와_당첨_번호의_매칭된_번호를_카운트한다() {
        Lotto[] issuedLottos = {
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(4,5,6,7,8,9))
        };
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        winningLotto.addBonusNumber(10);

        lottoService.countMatchingNumbers(issuedLottos, winningLotto);

        assertThat(WinningStatistics.FIRST.getCount()).isEqualTo(1);
        assertThat(WinningStatistics.FIFTH.getCount()).isEqualTo(1);
    }

    @DisplayName("매칭된 번호가 5개일 때 보너스 번호가 포함될 경우 2등이다.")
    @Test
    void 매칭된_번호가_5개일_때_보너스_번호가_포함될_경우_2등이다() {
        Lotto[] issuedLottos = {
                new Lotto(List.of(1,2,3,4,7,8)),
        };
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        winningLotto.addBonusNumber(8);

        lottoService.countMatchingNumbers(issuedLottos, winningLotto);

        assertThat(WinningStatistics.SECOND.getCount()).isEqualTo(1);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void 수익률을_계산한다() {
        Money money = new Money(8000);
        Lotto[] issuedLottos = {
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        };
        lottoService.issueLotto(money);

        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        winningLotto.addBonusNumber(7);

        lottoService.countMatchingNumbers(issuedLottos, winningLotto);
        double profit = lottoService.calculateProfitRate();
        assertThat(profit).isEqualTo(62.5);
    }
}
