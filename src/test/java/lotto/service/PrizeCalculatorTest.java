package lotto.service;

import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PrizeCalculatorTest {

    PrizeCalculator prizeCalculator;
    @BeforeEach
    void setUp(){
        prizeCalculator = new PrizeCalculator();
    }

    @Test
    void calculatePrizes() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7);
        Lotto winnerLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto secondLotto = new Lotto(List.of(1,2,3,4,5,7));
        Lotto losingLotto = new Lotto(List.of(8,9,10,11,12,13));

        List<Lotto> lottos = List.of(winnerLotto, secondLotto, losingLotto);

        prizeCalculator.calculatePrizes(lottos, winningLotto);

        assertThat(prizeCalculator.getPrizeCount().get(Prize.FIRST)).isEqualTo(1);
        assertThat(prizeCalculator.getPrizeCount().get(Prize.SECOND)).isEqualTo(1);
        assertThat(prizeCalculator.getPrizeCount().get(Prize.FIFTH)).isEqualTo(0);


    }



    @Test
    void calculateWinningRate() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7);
        Lotto winnerLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto secondLotto = new Lotto(List.of(1,2,3,4,5,7));
        Lotto losingLotto = new Lotto(List.of(8,9,10,11,12,13));

        List<Lotto> lottos = List.of(winnerLotto, secondLotto, losingLotto);

        prizeCalculator.calculatePrizes(lottos, winningLotto);

        double winningRate = prizeCalculator.calculateWinningRate(3000);

        assertThat(winningRate).isGreaterThan(100);

    }
}