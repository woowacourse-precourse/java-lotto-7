package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    @Test
    public void testValidLotto() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertEquals(validNumbers, lotto.getNumbers());
    }

    @Test
    public void testInvalidLottoSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(List.of(1, 2, 3, 4));
        });
        assertEquals("[ERROR] 6개의 숫자가 필요합니다.", exception.getMessage());
    }

    @Test
    public void testInvalidLottoRange() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(List.of(0, 1, 2, 3, 4, 5));
        });
        assertEquals("[ERROR] 1~45사이의 숫자를 입력해주세요.", exception.getMessage());
    }

    @Test
    public void testInvalidLottoDuplicated() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(List.of(1, 1, 2, 3, 4, 5));
        });
        assertEquals("[ERROR] 중복된 공입니다.", exception.getMessage());
    }
}
