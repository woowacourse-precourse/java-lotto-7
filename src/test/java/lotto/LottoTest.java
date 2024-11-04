package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Rank;
import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.WinningCombination;
import lotto.domain.winning.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개일 때 정상적으로 객체가 생성된다.")
    @Test
    void 로또_번호가_6개일_때_정상적으로_객체가_생성된다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isNotNull();
    }

    @DisplayName("로또 번호가 정렬되어 저장된다.")
    @Test
    void 로또_번호가_정렬되어_저장된다() {
        Lotto lotto = new Lotto(List.of(6, 1, 4, 5, 3, 2));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 올바른 등급을 계산한다.")
    @Test
    void 로또_번호와_당첨_번호를_비교하여_올바른_등급을_계산한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");
        WinningCombination winningCombination = new WinningCombination(winningNumbers, bonusNumber);

        Rank rank = lotto.calculateRank(winningCombination);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("로또 번호와 보너스 번호를 포함하여 2등 등급을 계산한다.")
    @Test
    void 로또_번호와_보너스_번호를_포함하여_2등_등급을_계산한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");
        WinningCombination winningCombination = new WinningCombination(winningNumbers, bonusNumber);

        Rank rank = lotto.calculateRank(winningCombination);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
