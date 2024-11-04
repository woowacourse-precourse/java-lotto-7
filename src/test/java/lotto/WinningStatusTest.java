package lotto;

import lotto.input.BonusNumber;
import lotto.input.WinningNumber;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningStatusTest {

    @Test
    void 발행한_로또와_당첨_번호를_비교한다() {
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.validate("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber(winningNumber.getLotto().getNumbers());
        List<Lotto> lottoList = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoList.add(lotto);

        WinningStatus winningStatus = new WinningStatus(winningNumber, bonusNumber);
        winningStatus.matchLotto(lottoList);

        assertThat(Match.MATCH_6.getCount()).isEqualTo(1);
    }

    @Test
    void 발행한_로또와_보너스_번호를_비교한다() {
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.validate("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber(winningNumber.getLotto().getNumbers());
        bonusNumber.validate("7");
        List<Lotto> lottoList = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        lottoList.add(lotto);

        WinningStatus winningStatus = new WinningStatus(winningNumber, bonusNumber);
        winningStatus.matchLotto(lottoList);

        assertThat(Match.MATCH_5_BONUS.getCount()).isEqualTo(1);
    }
}