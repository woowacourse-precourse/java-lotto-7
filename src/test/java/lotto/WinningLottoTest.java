package lotto;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {
  
    @DisplayName("당첨번호와 입력받은 로또번호로 당첨결과를 반환한다.")
    @Test
    void compare_lotto() throws Exception{
        //given
        WinningLotto winningLotto = new WinningLotto(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))), 7);
        List<Lotto> lottos = new ArrayList<>();
        Lotto issuedLotto1 = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        Lotto issuedLotto2 = new Lotto(new ArrayList<>(List.of(2, 3, 4, 5, 6,7)));
        Lotto issuedLotto3 = new Lotto(new ArrayList<>(List.of(7, 8, 3, 4, 5, 6)));
        Lotto issuedLotto4 = new Lotto(new ArrayList<>(List.of(9, 10, 3, 4, 5, 6)));
        Lotto issuedLotto5 = new Lotto(new ArrayList<>(List.of(11,12,13,14,15,16)));

        lottos.add(issuedLotto1);
        lottos.add(issuedLotto2);
        lottos.add(issuedLotto3);
        lottos.add(issuedLotto4);
        lottos.add(issuedLotto5);
        //when
        List<Ranking> winningResult = winningLotto.getWinningResult(lottos);
        //then
        assertThat(winningResult)
                .contains(Ranking.FIRST, Ranking.SECOND, Ranking.FOURTH, Ranking.FOURTH,Ranking.UNRANKED);
     }
}