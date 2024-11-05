package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CorrectDTOTest {
    private CorrectDTO correctDTO;

    @BeforeEach
    void setUp() {
        Lotto correctLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        correctDTO = new CorrectDTO(correctLotto);
    }

    @Test
    @DisplayName("정상적인 보너스 번호 설정")
    void testSetBonus_ValidBonus() {
        correctDTO.setBonus(7);
        assertEquals(7, correctDTO.getBonus());
    }

    @Test
    @DisplayName("보너스 번호가 45를 초과하는 경우 예외 발생")
    void testSetBonus_ExceedsUpperBound() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            correctDTO.setBonus(46);
        });
        assertEquals("[ERROR] 로또 번호는 45이하의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외 발생")
    void testSetBonus_DuplicateWithCorrects() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            correctDTO.setBonus(3);  // 당첨 번호에 포함된 숫자
        });
        assertEquals("[ERROR] 당첨 번호는 중복되어서는 안됩니다.", exception.getMessage());
    }

}