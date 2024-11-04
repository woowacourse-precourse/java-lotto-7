package lotto;

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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("로또 번호와 보너스 번호와 비교하여 일치하면 true를 반환한다")
    @Test
    void 로또_번호와_당첨_번호를_비교하여_일치된_숫자의_개수를_반환한다() {
        // Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(3, 4, 5, 6, 7, 8);

        // When
        int matchCount = lotto.countMatchingNumbers(winningNumbers);

        // Then
        assertThat(matchCount).isEqualTo(4);
    }

    @DisplayName("로또 번호와 보너스 번호와 비교하여 일치하지 않으면 false를 반환한다")
    @Test
    void 로또_번호와_보너스_번호와_비교하여_일치하지_않으면_false를_반환한다() {
        // Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // When
        boolean isBonusMatch = lotto.matchesBonusNumber(bonusNumber);

        // Then
        assertThat(isBonusMatch).isFalse();
    }
}
