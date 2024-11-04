package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @DisplayName("올바른 당첨 번호와 보너스 번호 입력 시 예외가 발생하지 않고 저장된다.")
    @Test
    void 올바른_당첨_번호와_보너스_번호_입력() {
        // given
        String validWinningNumbers = "1,2,3,4,5,6";
        String validBonusNumber = "7";
        // when
        WinningLotto winningLotto = new WinningLotto(validWinningNumbers, validBonusNumber);
        // then
        assertThat(winningLotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("6개 번호가 일치하면 1등을 반환한다.")
    @Test
    void 여섯_개_번호_일치() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Rank rank = winningLotto.match(lotto);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개 번호와 보너스 번호가 일치하면 2등을 반환한다.")
    @Test
    void 다섯_개_번호_및_보너스_번호_일치() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        Rank rank = winningLotto.match(lotto);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개 번호만 일치하고 보너스 번호가 일치하지 않으면 3등을 반환한다.")
    @Test
    void 다섯_개_번호_일치() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        Rank rank = winningLotto.match(lotto);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4개 번호가 일치하면 4등을 반환한다.")
    @Test
    void 네_개_번호_일치() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));

        Rank rank = winningLotto.match(lotto);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3개 번호가 일치하면 5등을 반환한다.")
    @Test
    void 세_개_번호_일치() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        Rank rank = winningLotto.match(lotto);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2개 이하의 번호만 일치하면 당첨되지 않음(NONE)을 반환한다.")
    @Test
    void 두_개_이하_번호_일치() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));

        Rank rank = winningLotto.match(lotto);

        assertThat(rank).isEqualTo(Rank.NONE);
    }
}
