package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
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
    @Test
    @DisplayName("정수 리스트가 오름차순으로 정렬이 되었는지 테스트")
    void testIntegerNumberAreSorted() {
        List<Integer> intNumbers = Arrays.asList(6, 3, 5, 1, 4, 2);
        Lotto lotto = new Lotto(intNumbers);

        lotto.sortAscendingInteger();

        List<Integer> expectedSortedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expectedSortedNumbers, lotto.getNumbers());
    }
}
