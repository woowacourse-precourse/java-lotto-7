package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("보너스 번호가 당첨 번호에 포함되었다면 예외가 발생한다.")
    void should_throwException_When_WinningNumberContainsBonusNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        BonusNumber bonusNumber = new BonusNumber(3);

        // then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호와 같은 숫자가 2개 이하이면 순위가 없어야 한다.")
    void should_ReturnNoRank_When_MatchCountIsLessThanTwo() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        Lotto target = new Lotto(List.of(1, 2, 8, 9, 10, 11));

        // when
        LottoRank lottoRank = winningLotto.calculateRank(target);

        // then
        assertEquals(lottoRank, LottoRank.NONE);
    }

    @Test
    @DisplayName("당첨 번호와 같은 숫자가 3개이면 5등이여야 한다.")
    void should_ReturnFifthRank_When_MatchCountIsThree() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        Lotto target = new Lotto(List.of(1, 2, 3, 9, 10, 11));

        // when
        LottoRank lottoRank = winningLotto.calculateRank(target);

        // then
        assertEquals(lottoRank, LottoRank.FIFTH);
    }

    @Test
    @DisplayName("당첨 번호와 같은 숫자가 4개이면 4등이여야 한다.")
    void should_ReturnFourthRank_When_MatchCountIsThree() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 10, 11));

        // when
        LottoRank lottoRank = winningLotto.calculateRank(target);

        // then
        assertEquals(lottoRank, LottoRank.FOURTH);
    }

    @Test
    @DisplayName("당첨 번호와 같은 숫자가 5개지만, 보너스 번호가 일치하지 않으면 3등이여야 한다.")
    void should_ReturnThirdRank_When_MatchCountIsThree() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 11));

        // when
        LottoRank lottoRank = winningLotto.calculateRank(target);

        // then
        assertEquals(lottoRank, LottoRank.THIRD);
    }

    @Test
    @DisplayName("당첨 번호와 같은 숫자가 5개이고, 보너스 번호가 일치하면 2등이여야 한다.")
    void should_ReturnSecondRank_When_MatchCountIsThree() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // when
        LottoRank lottoRank = winningLotto.calculateRank(target);

        // then
        assertEquals(lottoRank, LottoRank.SECOND);
    }

    @Test
    @DisplayName("당첨 번호와 같은 숫자가 6개이면 1등이여야 한다.")
    void should_ReturnFirstRank_When_MatchCountIsThree() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        LottoRank lottoRank = winningLotto.calculateRank(target);

        // then
        assertEquals(lottoRank, LottoRank.FIRST);
    }

    @Test
    @DisplayName("당첨 번호와 같은 숫자가 4개이고, 보너스 번호가 일치하면 4등이여야 한다.")
    void should_ReturnFourthRank_When_MatchCountIsFourAndContainsBonusNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 7, 8));

        // when
        LottoRank lottoRank = winningLotto.calculateRank(target);

        // then
        assertEquals(lottoRank, LottoRank.FOURTH);
    }
}
