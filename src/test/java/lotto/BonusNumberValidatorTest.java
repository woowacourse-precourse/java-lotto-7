package lotto;

import lotto.validator.entity.BonusNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberValidatorTest {
    // 보너스 번호 검증 클래스 ( BonusNumberValidator ) 테스트

    @DisplayName("[BonusNumberValidatorTest] 보너스 번호에 숫자 외의 값이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"asdwasda", "*@^&*@$", "12@*#", "asd12@$#", "12 21141 13", "123,123,43,12,1"})
    void 보너스_번호에_숫자_외의_값이_입력되면_예외가_발생한다(String input){
        assertThatThrownBy(() -> new BonusNumberValidator(input).validate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[BonusNumberValidatorTest] 보너스 번호가 1 과 45 사이의 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "-123123", "2341412"})
    void 보너스_번호가_1_과_45_사이의_숫자가_아니면_예외가_발생한다(String input){
        assertThatThrownBy(() -> new BonusNumberValidator(input).validate())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
