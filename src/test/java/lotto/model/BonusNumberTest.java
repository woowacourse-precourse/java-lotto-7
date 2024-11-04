package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @ParameterizedTest
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"abcd", "12.34", "!"})
    void 보너스_번호가_숫자가_아니면예_예외가_발생한다(String input){
        assertThatThrownBy(()-> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 숫자가 범위를 벗어났다면 예외가 발생한다.")
    @ValueSource(strings = {"-2","-1", "46", "47"})
    void 보너스_번호가_숫자가_범위를_벗어났다면_예외가_발생한다(String input){
        assertThatThrownBy(()-> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
