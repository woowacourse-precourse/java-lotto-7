package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class LottoTest {

    @Test
    @DisplayName("로또 번호가 6개가 아닐 때 예외 발생")
    void shouldThrowExceptionWhenLottoNumberCountIsNotSix() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers));
    }

    @Test
    @DisplayName("로또 번호가 1~45 범위를 벗어날 때 예외 발생")
    void shouldThrowExceptionWhenNumberIsOutOfRange() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers));
    }

    @Test
    @DisplayName("올바른 로또 번호가 주어졌을 때 로또 생성 성공")
    void shouldCreateLottoWhenNumbersAreValid() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertEquals(validNumbers, lotto.getNumbers());
    }
}
