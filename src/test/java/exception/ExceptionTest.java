package exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ExceptionTest {

    private Exception exception;

    @BeforeEach
    void setUp() {
        exception = new Exception();
    }

    @DisplayName("입력된_정보가_숫자가_아니거나_너무크면_에러발생")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"e", "  ", "", ";", "88888888888888888888888888888888888888"})
    void 입력된_정보가_숫자가_아니거나_너무크면_에러발생(String input) {
        assertThatThrownBy(() -> exception.changeInputStrToNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된_정보가_숫자가_아니거나_너무크면_에러발생")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"0", "1001", "2005", "asdf", "88888888888888888888888888888888888888"})
    void 구입금액이_1000배수가_아니면_에러발생(String input) {
        assertThatThrownBy(() -> exception.verifyBuyPrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스_번호가_1부터_45가_아니면_에러발생")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"0", "46", "asdf", "88888888888888888888888888888888888888"})
    void 보너스_번호가_1부터_45가_아니면_에러발생(String input) {
        assertThatThrownBy(() -> exception.verifyBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}