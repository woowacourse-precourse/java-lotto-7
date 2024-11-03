package lotto.winning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.LottoNumber;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    private static final List<LottoNumber> LOTTO_NUMBERS = List.of(LottoNumber.from(1), LottoNumber.from(2),
            LottoNumber.from(3), LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6));

    @Test
    void 당첨_로또_생성() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        assertThat(winningLotto).isEqualTo(new WinningLotto(winningNumbers, bonusNumber));
    }

    @Test
    void 로또와_당첨로또_매칭_개수_계산() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,43,44");
        BonusNumber bonusNumber = new BonusNumber("45", winningNumbers);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        assertThat(winningLotto.countWinnings(LOTTO_NUMBERS)).isEqualTo(4);
    }

    @Test
    void 로또와_당첨로또_매칭_시_보너스번호_일치_여부_확인() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,44");
        BonusNumber bonusNumber1 = new BonusNumber("6", winningNumbers);
        BonusNumber bonusNumber2 = new BonusNumber("45", winningNumbers);

        WinningLotto winningLotto1 = new WinningLotto(winningNumbers, bonusNumber1);
        WinningLotto winningLotto2 = new WinningLotto(winningNumbers, bonusNumber2);

        assertThat(winningLotto1.containsBonus(LOTTO_NUMBERS)).isTrue();
        assertThat(winningLotto2.containsBonus(LOTTO_NUMBERS)).isFalse();
    }
}
