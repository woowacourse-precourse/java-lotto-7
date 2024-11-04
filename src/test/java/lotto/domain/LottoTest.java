package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NO_PRIZE;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("모두 일치하는 경우 1등 결과를 반환한다")
    @Test
    void 모두_일치하는_경우_1등_결과를_반환한다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        Rank result = lotto.getResult(winningNumbers, bonusNumber);

        // then
        assertThat(result).isEqualByComparingTo(FIRST);
    }

    @DisplayName("다섯개가 일치하고 보너스 번호가 일치하는 경우 2등 결과를 반환한다")
    @Test
    void 다섯개가_일치하고_보너스_번호가_일치하는_경우_2등_결과를_반환한다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        Rank result = lotto.getResult(winningNumbers, bonusNumber);

        // then
        assertThat(result).isEqualByComparingTo(SECOND);
    }

    @DisplayName("다섯개가 일치하고 보너스 번호가 불일치하는 경우 3등 결과를 반환한다")
    @Test
    void 다섯개가_일치하고_보너스_번호가_불일치하는_경우_3등_결과를_반환한다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 8;

        // when
        Rank result = lotto.getResult(winningNumbers, bonusNumber);

        // then
        assertThat(result).isEqualByComparingTo(THIRD);
    }

    @DisplayName("네개가 일치하는 경우 4등 결과를 반환한다")
    @Test
    void 네개가_일치하는_경우_4등_결과를_반환한다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 7, 8);
        int bonusNumber = 5;

        // when
        Rank result = lotto.getResult(winningNumbers, bonusNumber);

        // then
        assertThat(result).isEqualByComparingTo(FOURTH);
    }

    @DisplayName("세개가 일치하는 경우 5등 결과를 반환한다")
    @Test
    void 세개가_일치하는_경우_5등_결과를_반환한다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 7, 8, 9);
        int bonusNumber = 5;

        // when
        Rank result = lotto.getResult(winningNumbers, bonusNumber);

        // then
        assertThat(result).isEqualByComparingTo(FIFTH);
    }

    @DisplayName("세개 미만 일치하는 경우 낙첨 결과를 반환한다")
    @Test
    void 세개_미만_일치하는_경우_낙첨_결과를_반환한다() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Set<Integer> winningNumbers = Set.of(1, 2, 7, 8, 9, 10);
        int bonusNumber = 5;

        // when
        Rank result = lotto.getResult(winningNumbers, bonusNumber);

        // then
        assertThat(result).isEqualByComparingTo(NO_PRIZE);
    }
}
