package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import domain.winningLotto.BonusNumber;
import domain.lotto.LottoNumber;
import domain.winningLotto.WinningLotto;
import domain.winningLotto.WinningNumbers;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 당첨_로또_생성() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        assertThat(winningLotto).isEqualTo(new WinningLotto(winningNumbers, bonusNumber));
    }

    @Test
    void 로또와_당첨로또_매칭_개수_계산() {
        List<LottoNumber> lottoNumbers = List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6));

        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,43,44");
        BonusNumber bonusNumber = new BonusNumber("45", winningNumbers);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        assertThat(winningLotto.countWinnings(lottoNumbers)).isEqualTo(4);
    }

    @Test
    void 로또와_당첨로또_매칭_시_보너스번호_일치_여부_확인() {
        List<LottoNumber> lottoNumbers = List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6));

        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,44");
        BonusNumber bonusNumber1 = new BonusNumber("6", winningNumbers);
        BonusNumber bonusNumber2 = new BonusNumber("45", winningNumbers);

        WinningLotto winningLotto1 = new WinningLotto(winningNumbers, bonusNumber1);
        WinningLotto winningLotto2 = new WinningLotto(winningNumbers, bonusNumber2);

        assertThat(winningLotto1.containsBonus(lottoNumbers)).isTrue();
        assertThat(winningLotto2.containsBonus(lottoNumbers)).isFalse();
    }
}
