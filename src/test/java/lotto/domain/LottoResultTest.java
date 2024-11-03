package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("6개 번호 일치 시 1등 Rank를 반환한다.")
    @Test
    void from_firstRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        LottoResult lottoResult = LottoResult.of(lotto, winningNumbers, bonusNumber);

        // then
        assertThat(lottoResult.getRank()).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개 번호 일치 + 보너스 번호 일치 시 2등 Rank를 반환한다.")
    @Test
    void from_secondRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        LottoResult lottoResult = LottoResult.of(lotto, winningNumbers, bonusNumber);

        // then
        assertThat(lottoResult.getRank()).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개 번호 일치 시 3등 Rank를 반환한다.")
    @Test
    void from_thirdRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        LottoResult lottoResult = LottoResult.of(lotto, winningNumbers, bonusNumber);

        // then
        assertThat(lottoResult.getRank()).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4개 번호 일치 시 4등 Rank를 반환한다.")
    @Test
    void from_fourthRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 10, 11));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        LottoResult lottoResult = LottoResult.of(lotto, winningNumbers, bonusNumber);

        // then
        assertThat(lottoResult.getRank()).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3개 번호 일치 시 5등 Rank를 반환한다.")
    @Test
    void from_fifthRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        LottoResult lottoResult = LottoResult.of(lotto, winningNumbers, bonusNumber);

        // then
        assertThat(lottoResult.getRank()).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2개 이하 번호 일치 시 Rank.NONE을 반환한다.")
    @Test
    void from_noneRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 10, 11, 12, 13));
        List<Integer> winningNumbers = List.of(3, 4, 5, 6, 7, 8);
        int bonusNumber = 9;

        // when
        LottoResult lottoResult = LottoResult.of(lotto, winningNumbers, bonusNumber);

        // then
        assertThat(lottoResult.getRank()).isEqualTo(Rank.NONE);
    }
}