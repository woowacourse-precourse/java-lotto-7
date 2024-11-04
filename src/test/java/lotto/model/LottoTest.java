package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    @DisplayName("로또 번호의 개수가 6개 보다 적을 경우 예외 발생")
    void lottoInvalidSize() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5); // 개수 5개
        assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers));
    }

    @Test
    @DisplayName("로또 번호가 중첩될 경우 예외 발생")
    void lottoDuplicatedNumbers() {
        List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 5); // 중복 번호 5
        assertThrows(IllegalArgumentException.class, () -> new Lotto(duplicatedNumbers));
    }

    @Test
    @DisplayName("로또 번호가 1에서 45 사이를 벗어날 경우 예외 발생")
    void lottoNumbersOutOfRange() {
        List<Integer> invalidNumbers = List.of(0, 2, 3, 4, 5, 6); // 0은 유효하지 않은 값
        assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers));
    }


    @Test
    @DisplayName("올바른 개수의 로또 번호가 입력되면 객체가 정상적으로 생성된다")
    void lottoValidSize() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertEquals(validNumbers, lotto.getNumbers());
    }
}
