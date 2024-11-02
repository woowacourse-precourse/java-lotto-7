package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {

    @DisplayName("발행한 로또 수량은 로또 구입 금액을 천 원으로 나눈 몫이다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 10000})
    void numberOfLottoShouldBeBudgetDividedBy1000Won(int budget) {
        List<Lotto> results = LottoMachine.generateLotto(budget);

        assertThat(results.size()).isEqualTo(budget / 1000);
    }

    @DisplayName("3개의 번호가 일치하면 5천원 당첨이다.")
    @Test
    void prizeFor3MatchShouldBe5_000Won() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        LottoResult result = LottoMachine.match(winningNumbers, List.of(lotto));
        List<LottoPrize> prize = result.getPrizeFor(3);

        assertThat(prize).hasSize(1);
        assertThat(prize.getFirst().getMoney()).isEqualTo(5_000);
    }

    @DisplayName("4개의 번호가 일치하면 5만원 당첨이다.")
    @Test
    void prizeFor4MatchShouldBe50_000Won() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));

        LottoResult result = LottoMachine.match(winningNumbers, List.of(lotto));
        List<LottoPrize> prize = result.getPrizeFor(4);

        assertThat(prize).hasSize(1);
        assertThat(prize.getFirst().getMoney()).isEqualTo(50_000);
    }

    @DisplayName("5개의 번호가 일치하면 150만원 당첨이다.")
    @Test
    void prizeFor5MatchShouldBe1_500_000Won() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        LottoResult result = LottoMachine.match(winningNumbers, List.of(lotto));
        List<LottoPrize> prize = result.getPrizeFor(5);

        assertThat(prize).hasSize(1);
        assertThat(prize.getFirst().getMoney()).isEqualTo(1_500_000);
    }

    @DisplayName("5개의 번호가 일치하고 보너스 볼이 일치하면 3천만원 당첨이다.")
    @Test
    void prizeFor5MatchWithBonusBallShouldBe30_000_000Won() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));

        LottoResult result = LottoMachine.match(winningNumbers, List.of(lotto));
        List<LottoPrize> prize = result.getPrizeFor(5, true);

        assertThat(prize).hasSize(1);
        assertThat(prize.getFirst().getMoney()).isEqualTo(30_000_000);
    }

    @DisplayName("6개의 번호가 일치하면 20억원 당첨이다.")
    @Test
    void prizeFor6MatchShouldBe2_000_000_000Won() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        LottoResult result = LottoMachine.match(winningNumbers, List.of(lotto));
        List<LottoPrize> prize = result.getPrizeFor(6);

        assertThat(prize).hasSize(1);
        assertThat(prize.getFirst().getMoney()).isEqualTo(2_000_000_000);
    }

    @DisplayName("아무 번호도 일치하지 않으면 당첨금은 없다.")
    @Test
    void noPrizeForNoMatch() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10);
        Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        LottoResult result = LottoMachine.match(winningNumbers, List.of(lotto));
        List<LottoPrize> prize = result.getPrizes();

        assertThat(prize).isEmpty();
    }
}
