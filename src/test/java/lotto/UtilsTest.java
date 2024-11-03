package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.utils.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    private final Utils utils = new Utils();

    @DisplayName("숫자가 아닌 다른 문자를 넣으면 예외가 발생한다.")
    @Test
    void 숫자가_아니면_예외가_발생한다() {
        String inputTest = "가나다";

        assertThatThrownBy(() -> utils.parseStringToInt(inputTest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자를 넣으면 정상 로직")
    @Test
    void 숫자면_정상로직이다() {
        String inputTest = "123";

        assertDoesNotThrow(() -> utils.parseStringToInt(inputTest));
    }
}
