package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("로또 번호가 3개 일치 시, FIFTH를 반환한다.")
    @Test
    void of_whenThreeNumbersMatch() {
        //given & when
        LottoRank lottoRank = LottoRank.of(3, false);

        //then
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("로또 번호가 4개 일치 시, FOURTH를 반환한다.")
    @Test
    void of_whenFourNumbersMatch() {
        //given & when
        LottoRank lottoRank = LottoRank.of(4, false);

        //then
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("로또 번호가 5개 일치 시, THIRD를 반환한다.")
    @Test
    void of_whenFiveNumbersMatch() {
        //given & when
        LottoRank lottoRank = LottoRank.of(5, false);

        //then
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("로또 번호가 5개와 보너스 번호 일치 시, SECOND를 반환한다.")
    @Test
    void of_whenFiveNumbersMatchWithBonus() {
        //given & when
        LottoRank lottoRank = LottoRank.of(5, true);

        //then
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("로또 번호가 6개 일치 시, FIRST를 반환한다.")
    @Test
    void of_whenSixNumbersMatch() {
        //given & when
        LottoRank lottoRank = LottoRank.of(6, false);

        //then
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("사용자의 로또 번호와 당첨 로또 번호가 3개 일치 시, 5등이다.")
    @Test
    void checkWinningRank_whenThreeNumberMatch() {
        //given
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 45;

        //when
        LottoRank lottoRank = LottoRank.checkWinningRank(userLotto, winningLotto, bonusNumber);

        //then
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("사용자의 로또 번호와 당첨 로또 번호가 4개 일치 시, 4등이다.")
    @Test
    void checkWinningRank_whenFourNumberMatch() {
        //given
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 45;

        //when
        LottoRank lottoRank = LottoRank.checkWinningRank(userLotto, winningLotto, bonusNumber);

        //then
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("사용자의 로또 번호와 당첨 로또 번호가 5개 일치 시, 3등이다.")
    @Test
    void checkWinningRank_whenFiveNumberMatch() {
        //given
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 12));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 45;

        //when
        LottoRank lottoRank = LottoRank.checkWinningRank(userLotto, winningLotto, bonusNumber);

        //then
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("사용자의 로또 번호와 당첨 로또 번호가 5개 + 보너스 번호 일치 시, 2등이다.")
    @Test
    void checkWinningRank_whenFiveNumberMatchWithBonus() {
        //given
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 12));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        //when
        LottoRank lottoRank = LottoRank.checkWinningRank(userLotto, winningLotto, bonusNumber);

        //then
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("사용자의 로또 번호와 당첨 로또 번호가 6개 일치 시, 1등이다.")
    @Test
    void checkWinningRank_whenSixNumberMatch() {
        //given
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 45;

        //when
        LottoRank lottoRank = LottoRank.checkWinningRank(userLotto, winningLotto, bonusNumber);

        //then
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

}