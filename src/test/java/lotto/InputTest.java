package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @Test
    void 입력값이_비어있으면_예외가_발생한다(){
        assertThatThrownBy(() -> Input.validateNotEmpty(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값에_숫자가_아닌_값이_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> Input.validateIsNumber("1000k"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값을_정수로_변환한다(){
        assertThat(Input.toInt("123")).isEqualTo(123);
    }

    @Test
    void 구입금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> Input.validateDivisibleByThousand(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
