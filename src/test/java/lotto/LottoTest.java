package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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

    @DisplayName("로또_번호가_정상적으로_오름차순정렬_되는지_확인한다")
    @Test
    void 로또_번호가_정상적으로_오름차순정렬_되는지_확인한다() {
        List<Integer> test = List.of(6, 5, 4, 3, 2, 1);

        Lotto lotto = new Lotto(test);

        assertThat(1).isEqualTo(lotto.getNumbers().get(0));
        assertThat(6).isEqualTo(lotto.getNumbers().get(5));
    }

    @DisplayName("리스트값중_하나라도_1부터45가_아닐때_에러발생_확인")
    @Test
    void 리스트값중_하나라도_1부터45가_아닐때_에러발생_확인() {
        List<Integer> list1 = List.of(-1, 0, 1, 2, 3, 4);
        List<Integer> list2 = List.of(1, 2, 3, 4, 45, 46);

        assertThatThrownBy(() -> new Lotto(list1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(list2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되는 숫자 있을때 에러 발생 확인")
    @Test
    void 중복되는_숫자_있을때_에러_발생_확인() {
        List<Integer> list1 = List.of(1, 1, 1, 1, 1, 1);
        List<Integer> list2 = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> new Lotto(list1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(list2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("2개의 로또를 비교해서 몇개번호가 중복되는지 확인")
    @Test
    void 두개의_로또를_비교해서_몇개번호가_중복되는지_확인() {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> list2 = List.of(1, 2, 3, 4, 41, 42);

        Lotto lotto = new Lotto(list1);

        assertThat(4).isEqualTo(lotto.findDuplicateNumber(list2));
    }


}
