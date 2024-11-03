package lotto.validator;

import lotto.service.LottoValidateService;
import lotto.service.LottoValidateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputWinningNumbersValidatorTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    private LottoValidateService lottoValidateService;

    @BeforeEach
    void setUp() {
        // 객체를 초기화
        lottoValidateService = new LottoValidateServiceImpl();
    }

    @Test
    void 당첨_번호가_숫자가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateWinningNumbers("안녕"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 당첨_번호가_빈문자열이면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateWinningNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 당첨_번호가_NULL이면_예외가_발생한다(){
        String winningNumbers = null;
        assertThatThrownBy(() -> lottoValidateService.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 당첨_번호로_공백을_포함하면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateWinningNumbers("1,2, ,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 당첨_번호_사이에_쉼표를_하나이상_포함하면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateWinningNumbers("1,2,,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 당첨_번호_맨앞에_쉼표를_하나이상_포함하면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateWinningNumbers(",1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 당첨_번호_맨뒤에_쉼표를_하나이상_포함하면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateWinningNumbers("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
