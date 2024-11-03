package lotto;

import lotto.core.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    @Test
    @DisplayName("기능 테스트 :: 로또 번호를 출력 형식에 맞춰 join 후 반환")
    void getNumberStringTest() {
        String expected = "[5, 8, 12, 17, 23, 34]";

        Lotto lotto = new Lotto(new ArrayList<>(List.of(5, 8, 12, 17, 23, 34)));
        String result = lotto.getNumberString();

        assertEquals(expected, result, "로또 번호를 형식에 맞춰 반환해야 합니다.");
    }

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

    @Test
    @DisplayName("예외 테스트 :: 로또 번호가 6개보다 작을 경우 예외 발생")
    void throwExceptionIfLessThanSixDigits() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("예외 테스트 :: 로또 번호가 1~45 범위를 벗어날 경우 예외 발생")
    void throwExceptionIfOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 46, 5, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
