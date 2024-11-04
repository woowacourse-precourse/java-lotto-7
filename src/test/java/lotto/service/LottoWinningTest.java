package lotto.service;

import lotto.domain.Lotto;
import lotto.staticenum.WinningAmountEnum;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoWinningTest {

    @Test
    void 로또_당첨금_테스트() {
        //GIVEN
        ArrayList<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); //1등
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7))); //2등
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8))); //3등
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9))); //4등
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10))); //5등
        LottoWinning lottoWinning = new LottoWinning(List.of(1,2,3,4,5,6),7,lottos);

        //WHEN
        lottoWinning.start();

        //THEN
        assertThat(lottoWinning.winningAmount).isEqualTo(
                WinningAmountEnum.FIVE.getValue() + WinningAmountEnum.FOUR.getValue() + WinningAmountEnum.THREE.getValue() +
                        WinningAmountEnum.TWO.getValue() + WinningAmountEnum.ONE.getValue()
        );
    }

    @Test
    void 로또_수익률_테스트() {
        //GIVEN
        ArrayList<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(40, 41, 42, 43, 44, 45))); //꽝
        lottos.add(new Lotto(List.of(40, 41, 42, 43, 44, 45))); //꽝
        lottos.add(new Lotto(List.of(40, 41, 42, 43, 44, 45))); //꽝
        lottos.add(new Lotto(List.of(40, 41, 42, 43, 44, 45))); //꽝
        lottos.add(new Lotto(List.of(40, 41, 42, 43, 44, 45))); //꽝
        lottos.add(new Lotto(List.of(40, 41, 42, 43, 44, 45))); //꽝
        lottos.add(new Lotto(List.of(40, 41, 42, 43, 44, 45))); //꽝
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10))); //5등
        LottoWinning lottoWinning = new LottoWinning(List.of(1,2,3,4,5,6),7,lottos);

        //WHEN
        lottoWinning.start();

        //THEN
        assertThat(lottoWinning.getYield()).isEqualTo(62.5);
    }
}
