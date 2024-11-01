package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @Test
    @DisplayName("로또 번호가 6개가 아닐 경우 예외가 발생한다.")
    void 로또_번호_6개_아닐_경우_예외가_발생한다() {
        // given
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5); // 5개의 숫자

        // when, then
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있을 경우 예외가 발생한다.")
    void 로또_번호_중복_숫자_예외가_발생한다() {
        // given
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 4, 5, 5); // 중복된 숫자 5

        // when, then
        assertThatThrownBy(() -> new Lotto(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("로또 번호가 범위를 벗어나는 경우 예외가 발생한다.")
    void 로또_번호가_범위를_벗어나는_경우_예외가_발생한다() {
        // given
        List<Integer> outOfRangeNumbers = Arrays.asList(0, 2, 3, 4, 5, 6); // 0은 범위를 벗어남

        // when, then
        assertThatThrownBy(() -> new Lotto(outOfRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 정상적으로 생성되는 경우이다.")
    void 로또_번호가_정상적으로_생성되는_경우이다() {
        // given
        List<Integer> validNumbers = Arrays.asList(8, 21, 15, 33, 40, 42);

        // when
        Lotto lotto = new Lotto(validNumbers);

        // then
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrder(8, 21, 15, 33, 40, 42);
    }
}