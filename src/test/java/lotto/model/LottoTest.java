package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
//    @Test
//    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
//    @Test
//    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }

    @Test
    @DisplayName("Lotto numbers 오름차순 테스트")
    void testSortNumbers() {
        Lotto lotto = new Lotto(List.of(43, 21, 42, 41, 23, 8));
        assertEquals(List.of(8, 21, 23, 41, 42, 43), lotto.getNumbers());
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
