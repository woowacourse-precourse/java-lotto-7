package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {
    @Test
    void test1() {
        Ball ball = new Ball(3);
        assertThat(ball).isEqualTo(new Ball(3));
    }

    @Test
    void test2() {
        assertThatThrownBy(() -> new Ball(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
