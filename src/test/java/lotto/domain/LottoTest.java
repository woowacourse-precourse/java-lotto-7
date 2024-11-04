package lotto.domain;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @Test
    @DisplayName("로또 번호가 당첨 번호와 몇 개 일치하는지 확인한다")
    void 당첨_확인_테스트() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);

        // when
        int matchingCount = lotto.countLottoNumbers(winningNumbers);

        // then
        assertThat(matchingCount).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호에 포함되는지 확인한다")
    void 보너스_번호_포함_테스트() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        // when & then
        boolean containsBonus = lotto.containsBonusNumber(5);
        assertThat(containsBonus).isTrue();
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호에 포함되지 않았는지 확인한다")
    void 보너스_번호_비포함_테스트() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        // when & then
        boolean containsBonus = lotto.containsBonusNumber(7);
        assertThat(containsBonus).isFalse();
    }
}
