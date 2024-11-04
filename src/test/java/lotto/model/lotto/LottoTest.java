package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.helper.LottoHelper;
import lotto.model.rank.RankCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    // 기본 제공 TC
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 비교, 일치 3개")
    void comparingLottoNumbersCase1() {
        // given
        Lotto myLotto = LottoHelper.mock(1, 2, 3, 4, 5, 6);
        Lotto drawResult = LottoHelper.mock(1, 2, 3, 14, 15, 16);
        Integer bonusNumber = 30;

        // when
        RankCondition actual = myLotto.rankWith(drawResult, bonusNumber);

        // then
        RankCondition expected = RankCondition.FIFTH;
        assertThat(actual == expected).isTrue();
    }

    @Test
    @DisplayName("로또 번호 비교, 일치 0개")
    void comparingLottoNumbersCase2() {
        // given
        Lotto myLotto = LottoHelper.mock(1, 2, 3, 4, 5, 6);
        Lotto drawResult = LottoHelper.mock(11, 12, 13, 14, 15, 16);
        Integer bonusNumber = 30;

        // when
        RankCondition actual = myLotto.rankWith(drawResult, bonusNumber);

        // then
        RankCondition expected = RankCondition.NONE;
        assertThat(actual == expected).isTrue();
    }

    @Test
    @DisplayName("보너스 번호 일치")
    void comparingBonusBallCase1() {
        // given
        Lotto myLotto = LottoHelper.mock(1, 2, 3, 4, 5, 6);
        Lotto drawResult = LottoHelper.mock(1, 2, 3, 4, 5, 7);
        Integer bonusNumber = 6;

        // when
        RankCondition actual = myLotto.rankWith(drawResult, bonusNumber);

        // then
        RankCondition expected = RankCondition.SECOND;
        assertThat(actual == expected).isTrue();
    }

    @Test
    @DisplayName("보너스 번호 불일치")
    void comparingBonusBallCase2() {
        // given
        Lotto myLotto = LottoHelper.mock(1, 2, 3, 4, 5, 6);
        Integer bonusBall = 7;

        // when
        boolean actual = myLotto.has(bonusBall);

        // then
        boolean expected = false;
        assertThat(actual).isEqualTo(expected);
    }
}
