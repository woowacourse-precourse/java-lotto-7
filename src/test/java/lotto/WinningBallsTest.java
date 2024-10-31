package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningBallsTest {

    @DisplayName("당첨 번호를 생산한다")
    @Test
    void test1() {
        WinningBalls winningBalls = new WinningBalls(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(6, winningBalls.getsize());
    }

    @DisplayName("당첨 번호가 겹칠시 예외를 반환한다.")
    @Test
    void test2() {
        assertThatThrownBy(() -> new WinningBalls(List.of(6, 6, 6, 6, 6, 6)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("당첨 번호와 몇 개가 똑같은지 반환한다")
    @Test
    void test_3() {
        WinningBalls winningBalls = new WinningBalls(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(6, winningBalls.getSameNumberCount(lotto));
    }
}
