package lotto.value;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import lotto.lottoapp.model.value.Won;
import org.junit.jupiter.api.Test;

class WonTest {

    public static final Class<IllegalArgumentException> COMMON_EXCEPTION = IllegalArgumentException.class;

    @Test
    void 원화는_0_또는_양의정수다() {
        assertThatCode(() -> Won.of(0))
                .doesNotThrowAnyException();
        assertThatCode(() -> Won.of(1))
                .doesNotThrowAnyException();

        assertThatCode(() -> Won.of(-1))
                .isInstanceOf(COMMON_EXCEPTION);
    }

    @Test
    void 원화는_덧셈_나머지_연산가능하다() {
        Won won1 = Won.of(1);
        Won won2 = Won.of(2);

        assertThat(won1.add(won2))
                .isEqualTo(Won.of(3));

        Won won1000 = Won.of(1000);
        Won won500 = Won.of(500);
        Won won300 = Won.of(300);
        assertThat(won1000.reminder(won500))
                .isEqualTo(Won.of(0));
        assertThat(won1000.reminder(won300))
                .isEqualTo(Won.of(100));
    }

}