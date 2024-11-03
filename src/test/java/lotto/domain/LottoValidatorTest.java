package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoValidatorTest {
    @Test
    void validateInputTest_빈_문자열() {
        assertThatThrownBy(() -> LottoValidator.validateInput(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 입력이 잘못되었습니다.");
    }
}
