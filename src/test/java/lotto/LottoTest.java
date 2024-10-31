package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void 로또번호_6개_생성_테스트() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertEquals(validNumbers, lotto.getNumbers());
    }

    @Test
    void 로또번호가_1에서_45사이의_값이_아닐때_예외처리() {
        List<Integer> outOfRangeNumbers = Arrays.asList(0, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(outOfRangeNumbers));
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
