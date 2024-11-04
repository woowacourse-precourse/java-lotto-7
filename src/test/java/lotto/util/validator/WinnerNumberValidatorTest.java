package lotto.util.validator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerNumberValidatorTest {
    @Test
    void 정상적인_당첨_번호_검증() {
        List<Integer> result = WinnerNumberValidator.validate("1,2,3,4,5,6");
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
