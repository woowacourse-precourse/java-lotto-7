package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberValidatorTest {
    private WinningNumberValidator winningNumberValidator;

    @BeforeEach
    void setUp() {
        this.winningNumberValidator = new WinningNumberValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "   "})
    void 당첨번호가_비어있을때_오류반환(String winningNumbers) {
        assertThatThrownBy(() -> {
            winningNumberValidator.validate(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호는 비어있을 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3:4:5:6", "1:2,3:4:5:6", "1,2,3,4:5,6", "1,2,3,4,5:6", "12,45,1,23,32!23",
            "1?,12,4?5,"})
    void 당첨번호의_구분자가_쉼표가_아닐때_에러_반환(String winningNumbers) {
        assertThatThrownBy(() -> {
            winningNumberValidator.validate(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호의 구분자는 쉼표여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2,3,4", "1,2,3,4,5", "12,45,1,23,32,23,29"})
    void 당첨번호가_6개가_아닐때_에러_반환(String winningNumbers) {
        assertThatThrownBy(() -> {
            winningNumberValidator.validate(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호는 6개여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,43,45", "1,5,2,3,43,46"})
    void 당첨번호가_1미만_45초과일때_에러_반환(String winningNumbers) {
        assertThatThrownBy(() -> {
            winningNumberValidator.validate(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호는 1이상 45이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,1,1,1,1", "1,1,2,2,3,3", "1,1,2,3,4,5"})
    void 당첨번호가_서로_중복될때_에러_반환(String winningNumbers) {
        assertThatThrownBy(() -> {
            winningNumberValidator.validate(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호는 서로 중복될 수 없습니다.");
    }
}