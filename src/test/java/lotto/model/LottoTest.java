package lotto.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("유효한 번호로 Lotto 인스턴스 생성")
    void testLottoCreationValid() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("잘못된 번호 개수로 Lotto 인스턴스 생성 시 예외 발생")
    void testLottoCreationInvalidSize() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(1, 2, 3, 4, 5))); // 번호 5개
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("범위를 벗어난 번호로 Lotto 인스턴스 생성 시 예외 발생")
    void testLottoCreationOutOfRange() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(1, 2, 3, 4, 5, 46))); // 46은 범위를 벗어남
        assertEquals("[ERROR] 로또 번호의 범위는 1~45입니다.", exception.getMessage());
    }

    @Test
    @DisplayName("중복된 번호로 Lotto 인스턴스 생성 시 예외 발생")
    void testLottoCreationWithDuplicates() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(1, 1, 3, 4, 5, 6))); // 1이 중복됨
        assertEquals("[ERROR] 로또 번호는 중복될 수 없습니다.", exception.getMessage());
    }
}
