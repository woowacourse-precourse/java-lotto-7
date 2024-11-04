package lotto;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

class InputTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 로또_구입금액이_0보다_작으면_오류_발생한다(){
        assertThatThrownBy(() -> Input.validatePrice(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE)
        ;
    }

    @Test
    void 지불한_금액이_1000원_단위가_아니면_오류_발생한다() {
        assertThatThrownBy(() -> Input.validatePrice(6500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 로또_범위는_1부터_45이고_이밖의_숫자가_입력되면_오류_발생한다(){
        assertThatThrownBy(() -> Input.validateNumberRange(47))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}