package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @DisplayName("생성된 로또의 6개의 번호가 당첨 번호와 모두 같으면 1등이다.")
    @Test
    void 로또_1등_당첨() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Lotto firstPlaceLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.findRank(firstPlaceLotto)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("생성된 로또가 당첨 번호 5개와 보너스 번호 1개가 일치하면 2등이다.")
    @Test
    void 로또_2등_당첨() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Lotto secondPlaceLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(winningLotto.findRank(secondPlaceLotto)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("생성된 로또가 당첨 번호 5개와 일치하고 보너스 번호는 일치하지 않으면 3등이다.")
    @Test
    void 로또_3등_당첨() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Lotto thirdPlaceLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        assertThat(winningLotto.findRank(thirdPlaceLotto)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("생성된 로또가 당첨 번호 4개와 일치하면 4등이다.")
    @Test
    void 로또_4등_당첨() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Lotto fourthPlaceLotto = new Lotto(List.of(1, 2, 3, 4, 10, 11));
        assertThat(winningLotto.findRank(fourthPlaceLotto)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("생성된 로또가 당첨 번호 3개와 일치하면 5등이다.")
    @Test
    void 로또_5등_당첨() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Lotto fifthPlaceLotto = new Lotto(List.of(1, 2, 3, 12, 13, 14));
        assertThat(winningLotto.findRank(fifthPlaceLotto)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("생성된 로또가 당첨 번호 2개 이하로 일치하면 낙첨이다.")
    @Test
    void 로또_낙첨() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Lotto noRankLotto = new Lotto(List.of(1, 2, 10, 11, 12, 13));
        assertThat(winningLotto.findRank(noRankLotto)).isEqualTo(Rank.MISS);
    }
}