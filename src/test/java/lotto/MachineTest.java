package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MachineTest {

    @Test
    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void 구입_금액이_천_단위로_나누어_떨어지지_않으면_예외가_발생한다(){
        assertThatThrownBy(() -> new Machine(1250))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위입니다.");
    }
}
