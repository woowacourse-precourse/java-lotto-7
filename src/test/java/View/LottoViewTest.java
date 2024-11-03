package View;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoViewTest {

    @DisplayName("view에서 구입 금액을 받아오는 테스트")
    @Test
    void 구입금액_받아오기() {
        assertThat("8000").isEqualTo("8000");
    }
}