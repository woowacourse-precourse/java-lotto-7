package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성 확인")
    @Test
    public void testLottoCreation() {
//        Lotto randomLotto = new Lotto();
//        List<Integer> numbers = randomLotto.getNumbers();
//        로또 번호의 크기가 6 인지 확인
//        assertEquals(6, numbers.size(), "[ERROR] 로또 번호는 6개여야 합니다.");
//
//        // 중복이 없는지 확인
//        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
//        assertEquals(6, uniqueNumbers.size(), "[ERROR] 로또 번호는 중복이 없어야 합니다.");
        // 각 숫자가 1부터 45 사이인지 확인
//        for (Integer number : numbers) {
//            Assertions.assertTrue(number >= 1 && number <= 45, "[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
//        }
//    }
        // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    }
}