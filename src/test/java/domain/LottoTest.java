package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @DisplayName("로또 번호를 오름차순으로 정렬하여 가져온다.")
    @Test
    void getAscNumber() {
        // given
        Lotto lotto = new Lotto(List.of(4, 2, 13, 45, 32, 5));
        List<Integer> expected = List.of(2, 4, 5, 13, 32, 45);

        // when
        List<Integer> ascNumber = lotto.getAscNumber();

        // then
        assertEquals(expected, ascNumber);
    }

    @DisplayName("로또 번호를 가져온다.")
    @Test
    void getNumbers() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        // when
        List<Integer> getNumbers = lotto.getNumbers();

        // then
        assertEquals(numbers, getNumbers);
    }
}
