package lotto.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersValidatorTest {
    private NumbersValidator winningNumbersValidator;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("당첨 번호 개수를 확인하는 함수")
    void 번호_중복_테스트1() {
        List<Integer> lotto = Arrays.asList(1, 2, 3);
        winningNumbersValidator = new NumbersValidator(lotto);
        assertThatThrownBy(() -> {
            winningNumbersValidator.validateNumbers();
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 중복되는 숫자가 존재합니다.");
    }

    @Test
    @DisplayName("보너스 번호 개수를 확인하는 함수")
    void 번호_중복_테스트2() {
        List<Integer> lotto = new ArrayList<>(1, 1, 1, 1, 1, 1)
        winningNumbersValidator = new NumbersValidator(lotto);
        assertThatThrownBy(() -> {
            winningNumbersValidator.validateNumbers();
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 중복되는 숫자가 존재합니다.");
    }
}
