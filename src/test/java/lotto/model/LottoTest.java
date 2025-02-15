package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호_범위_예외_테스트() {
        // 1보다 작은 경우
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);

        // 45보다 큰 경우
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 번호가 정상적으로 생성된다.")
    @Test
    void 로또_번호_정상_생성_테스트() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        Assertions.assertThat(lotto.getNumbers())
                .hasSize(6)
                .containsExactly(1, 2, 3, 4, 5, 6)  //
                .isSorted();
    }

    @DisplayName("로또 번호가 정렬되어 저장된다.")
    @Test
    void 로또_번호_정렬_테스트() {
        // given
        List<Integer> unorderedNumbers = List.of(45, 1, 31, 9, 25, 16);

        // when
        Lotto lotto = new Lotto(unorderedNumbers);

        // then
        Assertions.assertThat(lotto.getNumbers())
                .containsExactly(1, 9, 16, 25, 31, 45);
    }

}
