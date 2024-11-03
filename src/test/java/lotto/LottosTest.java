package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.winning.BonusNumber;
import lotto.winning.WinningLotto;
import lotto.winning.WinningNumbers;
import org.junit.jupiter.api.Test;

public class LottosTest {

    private static final Lotto LOTTO = new Lotto(
            List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4),
                    LottoNumber.from(5), LottoNumber.from(6)));

    @Test
    void Lottos_생성() {
        Lottos lottos = new Lottos(List.of(LOTTO));

        assertThat(lottos).isEqualTo(new Lottos(List.of(LOTTO)));
    }

    @Test
    void 모든_로또_출력() {
        Lotto otherLotto = new Lotto(
                List.of(LottoNumber.from(7), LottoNumber.from(8), LottoNumber.from(9), LottoNumber.from(10),
                        LottoNumber.from(11), LottoNumber.from(12)));

        Lottos lottos = new Lottos(List.of(LOTTO, otherLotto));

        assertThat(lottos.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]");
    }

    @Test
    void 로또_번호_일치_개수_구하기() {
        Lottos lottos = new Lottos(List.of(LOTTO));

        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,7,8,9");
        BonusNumber bonusNumber = new BonusNumber("10", winningNumbers);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        assertThat(lottos.calculateWinnings(LOTTO, winningLotto)).isEqualTo(3);
    }

    @Test
    void 보너스_번호_일치_여부_확인() {
        Lottos lottos = new Lottos(List.of(LOTTO));

        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,7");
        BonusNumber bonusNumber1 = new BonusNumber("6", winningNumbers);
        BonusNumber bonusNumber2 = new BonusNumber("45", winningNumbers);

        WinningLotto winningLotto1 = new WinningLotto(winningNumbers, bonusNumber1);
        WinningLotto winningLotto2 = new WinningLotto(winningNumbers, bonusNumber2);

        assertThat(lottos.hasBonus(LOTTO, winningLotto1)).isTrue();
        assertThat(lottos.hasBonus(LOTTO, winningLotto2)).isFalse();
    }

    @Test
    void Lottos_크기_확인() {
        Lottos lottos = new Lottos(List.of(LOTTO));

        assertThat(lottos.size()).isEqualTo(1);
    }
}
