package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @Test
    @DisplayName("Lotto 객체 생성 시 6개의 숫자가 아닌 경우 예외 발생")
    void createLottoWithInvalidSize() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers));
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("Lotto 객체 생성 시 중복된 숫자가 있는 경우 예외 발생")
    void createLottoWithDuplicateNumbers() {
        List<Integer> duplicateNumbers = List.of(1, 2, 3, 4, 5, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(duplicateNumbers));
        assertEquals("[ERROR] 로또 번호에 중복된 값이 있습니다.", exception.getMessage());
    }

}