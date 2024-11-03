package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.view.domain.Amount;
import lotto.view.domain.Lotto;
import lotto.view.domain.Lottos;
import lotto.view.domain.WinningCondition;
import lotto.view.domain.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {
    @DisplayName("로또 3등에 당첨됐을 때 정상적으로 동작하는지 확인한다.")
    @Test
    void 로또_3등에_당첨됐을_때_정상적으로_동작하는지_확인한다() {
        List<Integer> purchasedLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumber = List.of(1, 2, 3, 4, 5, 9);
        int bonusNumber = 7;

        assertRandomUniqueNumbersInRangeTest(() -> {
                    // given
                    Lottos purchasedLotto = new Lottos(new Amount(1000));
                    Lotto winningLottoNumbers = new Lotto(winningLottoNumber);

                    // when
                    WinningResult winningResult = new WinningResult(purchasedLotto, winningLottoNumbers, bonusNumber);

                    // then
                    assertThat(winningResult.getResultMap().get(WinningCondition.THIRD).size()).isEqualTo(1);
                },
                purchasedLottoNumber
        );
    }

    @DisplayName("보너스 볼 포함인 로또 2등에 당첨됐을 때 정상적으로 동작하는지 확인한다.")
    @Test
    void 보너스_볼_포함인_로또_2등에_당첨됐을_때_정상적으로_동작하는지_확인한다() {
        List<Integer> purchasedLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumber = List.of(1, 2, 3, 4, 5, 9);
        int bonusNumber = 6;

        assertRandomUniqueNumbersInRangeTest(() -> {
                    // given
                    Lottos purchasedLotto = new Lottos(new Amount(1000));
                    Lotto winningLottoNumbers = new Lotto(winningLottoNumber);

                    // when
                    WinningResult winningResult = new WinningResult(purchasedLotto, winningLottoNumbers, bonusNumber);

                    // then
                    assertThat(winningResult.getResultMap().get(WinningCondition.SECOND).size()).isEqualTo(1);
                },
                purchasedLottoNumber
        );
    }

    @DisplayName("로또 두 개 이상 당첨됐을 때 정상적으로 동작하는지 확인한다.")
    @Test
    void 로또_두_개_이상_당첨됐을_때_정상적으로_동작하는지_확인한다() {
        List<Integer> winningLottoNumber = List.of(1, 2, 3, 7, 8, 9);
        int bonusNumber = 10;

        assertRandomUniqueNumbersInRangeTest(() -> {
                    // given
                    Lottos purchasedLotto = new Lottos(new Amount(2000));
                    Lotto winningLottoNumbers = new Lotto(winningLottoNumber);

                    // when
                    WinningResult winningResult = new WinningResult(purchasedLotto, winningLottoNumbers, bonusNumber);

                    // then
                    assertThat(winningResult.getResultMap().get(WinningCondition.FOURTH).size()).isEqualTo(1);
                    assertThat(winningResult.getResultMap().get(WinningCondition.FIFTH).size()).isEqualTo(1);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 7, 12, 13)
        );
    }

    @DisplayName("수익률이 올바른지 확인한다.")
    @Test
    void 수익률이_올바른지_확인한다() {
        List<Integer> winningLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertRandomUniqueNumbersInRangeTest(() -> {
                    // given
                    int purchasedAmount = 8000;
                    Lottos purchasedLotto = new Lottos(new Amount(purchasedAmount));
                    Lotto winningLottoNumbers = new Lotto(winningLottoNumber);

                    // when
                    WinningResult winningResult = new WinningResult(purchasedLotto, winningLottoNumbers, bonusNumber);

                    // then
                    assertThat(winningResult.getProfitRate(new Amount(purchasedAmount))).isEqualTo(62.5);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }
}
