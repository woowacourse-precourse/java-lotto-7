package lotto.domain.number;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("로또 당첨 번호를 테스트한다.")
class WinningNumbersTest {

    @DisplayName("성공 케이스를 테스트한다.")
    @Nested
    class HappyCase {

        @DisplayName("번호가 6개이며, 중복된 번호가 없으면 성공한다.")
        @Test
        void successWinningNumbersTest() {
            assertDoesNotThrow(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)));
        }
    }

    @DisplayName("실패 케이스를 테스트한다.")
    @Nested
    class EdgeCase {

        @DisplayName("번호가 7개 이상이면 실패한다.")
        @Test
        void failWinningNumbersTest1() {
            assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("중복된 로또 번호가 있으면 실패한다.")
        @Test
        void failWinningNumbersTest2() {
            assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }
    }
}