package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import java.util.Map;
import lotto.controller.generator.mock.MockNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StoreTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("주어진 금액으로 올바른 개수의 로또를 구매한다.")
        void purchaseLottos() {
            // given
            MockNumberGenerator mockNumberGenerator = new MockNumberGenerator();
            Store store = new Store(mockNumberGenerator);
            Money money = new Money(5000);

            // when
            List<Lotto> purchasedLottos = store.purchaseLottos(money);

            // then
            assertSoftly(softly -> {
                softly.assertThat(purchasedLottos).hasSize(5);
                softly.assertThat(purchasedLottos.get(0).getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
            });
        }

        @Test
        @DisplayName("구입한 로또의 당첨 결과를 올바르게 계산한다.")
        void calculateLottoResult() {
            // given
            MockNumberGenerator mockNumberGenerator = new MockNumberGenerator();
            Store store = new Store(mockNumberGenerator);
            Money money = new Money(3000);
            List<Lotto> purchasedLottos = store.purchaseLottos(money);

            Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(7, winningLottoNumbers);
            WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

            // when
            Statistics statistics = store.calculateLottoResult(winningLotto, purchasedLottos);
            Map<Rank, Integer> winningResult = statistics.getWinningResult();

            // then
            assertSoftly(softly -> {
                softly.assertThat(winningResult).containsKeys(Rank.FIRST_PLACE);
                softly.assertThat(winningResult.get(Rank.FIRST_PLACE)).isEqualTo(3);
            });
        }

        @Test
        @DisplayName("로또와 당첨 로또를 비교하여 로또 순위를 올바르게 계산한다.")
        void calculateRank() {
            // given
            MockNumberGenerator mockNumberGenerator = new MockNumberGenerator();
            Store store = new Store(mockNumberGenerator);
            Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(7, winningLottoNumbers);
            WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

            // when
            Rank rank = store.calculateRank(winningLotto, winningLottoNumbers);

            // then
            assertThat(rank).isEqualTo(Rank.FIRST_PLACE);
        }
    }
}
