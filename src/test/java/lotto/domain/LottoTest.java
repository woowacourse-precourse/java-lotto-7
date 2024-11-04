package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void 로또_번호가_1부터_45_사이의_숫자가_아니라면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 정렬되어야 한다.")
    @Test
    void 로또_번호는_정렬되어야_한다() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(3, 1, 4, 5, 2, 6)));
        List<Integer> sortedNumbers = lotto.getNumbers();
        assertThat(sortedNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호 일치 개수가 맞는지 체크한다.")
    @Test
    void 로또_번호_일치_개수가_맞는지_체크한다() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));

        int matches1 = lotto.countMatches(List.of(1, 2, 3));
        assertThat(matches1).isEqualTo(3);

        int matches2 = lotto.countMatches(List.of(7, 8, 9));
        assertThat(matches2).isEqualTo(0);

        int matches3 = lotto.countMatches(List.of(6, 4, 3, 1, 7, 8));
        assertThat(matches3).isEqualTo(4);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
