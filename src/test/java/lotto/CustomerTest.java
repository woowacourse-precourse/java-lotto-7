package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomerTest {

    @Test
    void 소비자테스트() {
        assertThatThrownBy(() -> new Customer("100100"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
