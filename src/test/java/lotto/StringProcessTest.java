package lotto;

import static lotto.util.StringProcessor.removeCommas;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringProcessTest {
    @Test
    @DisplayName("콤마_제거를_확인하는_테스트")
    void 콤마_제거를_확인하는_테스트() {
        assertThat(removeCommas("1,000,000")).contains("1000000");
    }
}
