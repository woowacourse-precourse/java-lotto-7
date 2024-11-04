package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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

    @DisplayName("입력된 번호가 6자리를 초과하면 예외가 발생한다.")
    @Test
    void rangeInputTest() {
        assertThatThrownBy(() -> new Lotto(new ArrayList<>()).saveNumbers("1, 2, 3, 4, 5, 6, 7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤 생성된 로또 번호는 중복이 없고 1~45사이의 6자리 숫자이다.")
    @Test
    void randomNumberPickTest() {
        Lotto lotto = new Lotto(new ArrayList<>());
        List<Integer> newNumbers = lotto.pickNewLotto();

        assertEquals(6, newNumbers.size());
        for (int number : newNumbers) {
            assertTrue(number >= 1 && number <= 45);
        }
        HashSet<Integer> uniqueNumbers = new HashSet<>(newNumbers);
        assertEquals(newNumbers.size(), uniqueNumbers.size());
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
