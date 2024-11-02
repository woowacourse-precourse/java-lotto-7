package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validation.BonusNumberValidator;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class BonusNumberValidatorTest {
    private BonusNumberValidator bonusNumberValidator;
    @BeforeEach
    void 테스트_사전작업(){
        this.bonusNumberValidator = new BonusNumberValidator();
    }

    @DisplayName("로또 숫자 범위에 맞지 않는 보너스 번호가 올 경우 에러를 발생시킵니다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 50})
    void 로또_숫자범위에_맞지_않는_보너스번호가_올_때(Integer bonusNumber){
        assertThatThrownBy(() -> bonusNumberValidator.validate(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
