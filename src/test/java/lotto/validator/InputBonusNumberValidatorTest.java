package lotto.validator;

import lotto.service.LottoValidateService;
import lotto.service.LottoValidateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class InputBonusNumberValidatorTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private LottoValidateService lottoValidateService;

    @BeforeEach
    void setUp() {
        // 객체를 초기화
        lottoValidateService = new LottoValidateServiceImpl();
    }

    @Test
    void 보너스_번호가_숫자가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateBonusNumbers("안녕"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 보너스_번호가_소수점_형태이면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateBonusNumbers("7.0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 보너스_번호가_공백을_포함하면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateBonusNumbers("7 "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 보너스_번호가_빈문자열이면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateBonusNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 보너스_번호가_NULL이면_예외가_발생한다(){
        String bonusNumber = null;
        assertThatThrownBy(() -> lottoValidateService.validateBonusNumbers(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

}
