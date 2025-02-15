package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.Assertions;
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

    @DisplayName("로또에 1~45 범위를 벗언는 숫자가 있으면 예외가 발생한다.")
    @Test
    void givenOutOfRangeNumber_whenLotto_thenThrowIllegalArgumentException() {
        List<Integer> input = List.of(1, 569, -35, 2, 3, 4);
        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤 번호를 가진 로또 생성이 검증에 걸리는 지 확인")
    @Test
    void givenNothing_whenCreateWithRandomNumber_thenNonThrownException() {
        Assertions.assertDoesNotThrow(Lotto::createWithRandomNumbers);
    }

    @DisplayName("매칭 수를 계산하는 로직 검증")
    @Test
    void givenValidLottos_whenCountMatchingNumbers_thenCorrect() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        int excepted = 5;
        int result = lotto1.countMatchingNumbers(lotto2);
        Assertions.assertEquals(excepted, result);
    }
}
