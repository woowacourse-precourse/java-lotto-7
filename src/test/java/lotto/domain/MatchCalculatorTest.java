package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MatchCalculatorTest {

    @DisplayName("당첨 내역을 계산한다.")
    @Test
    void 당첨_내역_계산_테스트() {
        Lotto winNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(winNum);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))));
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 7))));
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 8))));
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 7, 8))));
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 7, 8, 9))));
        lottos.add(new Lotto(new ArrayList<>(List.of(10, 11, 12, 13, 14, 15))));
        lottos.add(new Lotto(new ArrayList<>(List.of(10, 11, 12, 13, 14, 15))));
        winningNumber.addBonusNumber(new BonusNumber(7));

        MatchCalculator matchCalculator =
                new MatchCalculator(winningNumber, new Lottos(lottos, new PurchaseMoney(7000)));
        matchCalculator.calculatePrize();
        Map<Prize, Integer> prizes = matchCalculator.getPrizes();

        Assertions.assertThat(prizes.get(Prize.FIRST)).isEqualTo(1);
        Assertions.assertThat(prizes.get(Prize.SECOND)).isEqualTo(1);
        Assertions.assertThat(prizes.get(Prize.THIRD)).isEqualTo(1);
        Assertions.assertThat(prizes.get(Prize.FOURTH)).isEqualTo(1);
        Assertions.assertThat(prizes.get(Prize.FIFTH)).isEqualTo(1);
        Assertions.assertThat(prizes.get(Prize.NOTHING)).isEqualTo(2);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void 수익률_계산_테스트() {
        Lotto winNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        WinningNumber winningNumber = new WinningNumber(winNum);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 7, 11, 12))));
        winningNumber.addBonusNumber(new BonusNumber(7));

        MatchCalculator matchCalculator =
                new MatchCalculator(winningNumber, new Lottos(lottos, new PurchaseMoney(8000)));
        matchCalculator.calculatePrize();
        double result = matchCalculator.calculateEarnRate();

        Assertions.assertThat(result).isEqualTo(62.5);
    }
}