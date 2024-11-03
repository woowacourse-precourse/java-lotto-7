package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @DisplayName("로또 번호에 46 이상의 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_45_이상의_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 0 이하의 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_0_이하의_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 생성 시 번호가 정렬되어 저장한다.")
    void 로또_생성_시_번호가_정렬되어_저장된다() {
        List<Integer> unsortedNumbers = Arrays.asList(45, 1, 23, 14, 3, 6);
        Lotto lotto = new Lotto(unsortedNumbers);
        assertThat(lotto.getNumbers()).containsExactly(1, 3, 6, 14, 23, 45);
    }

    @Test
    @DisplayName("로또 번호와 보너스 번호가 일치하는 개수에 따른 MatchResult 반환한다.")
    void 로또_번호와_보너스_번호가_일치하는_개수에_따른_MatchResult_반환한다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto purchasedLotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        int bonusNumber = 4;

        MatchResult result = purchasedLotto.match(winningLotto, bonusNumber);

        assertThat(result).isEqualTo(MatchResult.valueOf(3, true));
    }

    @Test
    @DisplayName("보너스 번호는 당첨 번호 5개 일치하는 경우 외 영향을 주지 않는다.")
    void 보너스_번호는_당첨_번호_5개_일치하는_경우_외_영향을_주지_않는다() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto purchasedLotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        int bonusNumber = 7;

        MatchResult result = purchasedLotto.match(winningLotto, bonusNumber);

        assertThat(result).isEqualTo(MatchResult.valueOf(3, false));
    }

}
