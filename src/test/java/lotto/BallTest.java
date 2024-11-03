package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {
    @Test
    void test1() {
        Ball ball = Ball.valueOf(45);
        assertThat(ball).isEqualTo(Ball.valueOf(45));
    }

    @Test
    void test2() {
        Ball ball = Ball.valueOf(1);
        assertThat(ball).isEqualTo(Ball.valueOf(1));
    }

    @Test
    void test3() {
        assertThatThrownBy(() -> Ball.valueOf(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test4() {
        assertThatThrownBy(() -> Ball.valueOf(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
