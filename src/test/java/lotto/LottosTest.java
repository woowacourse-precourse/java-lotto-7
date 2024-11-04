package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LottosTest {

    @Test
    @DisplayName("보유한 모든 로또의 당첨금을 얻는다")
    void 보유한_모든_로또의_당첨금을_얻는다() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber("7");
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber.getBonusNumber());

        List<Lotto> lotto = new ArrayList<>(List.of(
                new Lotto(List.of(1, 2, 3, 8 ,9 ,10)),
                new Lotto(List.of(1, 2, 3, 4 ,9 ,10)),
                new Lotto(List.of(1, 8, 9, 10 ,11 ,12))
        ));

        Lottos lottos = new Lottos(lotto);

        //when
        Long totalPrizeMoney = lottos.getTotalPrizeMoney(winningNumber, bonusNumber);

        //then
        assertThat(totalPrizeMoney).isEqualTo(55_000L);
    }
}