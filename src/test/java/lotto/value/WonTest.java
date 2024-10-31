package lotto.value;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class WonTest {

    public static final Class<IllegalArgumentException> COMMON_EXCEPTION = IllegalArgumentException.class;
    public static final String ERROR_HEADER = "[ERROR]";

    @Test
    void 원화는_0_또는_양의정수다() {
        assertThatCode(() -> Won.of(0))
                .doesNotThrowAnyException();
        assertThatCode(() -> Won.of(1))
                .doesNotThrowAnyException();

        assertThatCode(() -> Won.of(-1))
                .isInstanceOf(COMMON_EXCEPTION)
                .hasMessageContaining(ERROR_HEADER);
    }

}