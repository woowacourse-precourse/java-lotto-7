package lotto.validator;

import lotto.service.LottoValidateService;
import lotto.service.LottoValidateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputLottoCostValidatorTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    private LottoValidateService lottoValidateService;

    @BeforeEach
    void setUp() {
        // 객체를 초기화
        lottoValidateService = new LottoValidateServiceImpl();
    }

    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateLottoCost("8500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 구입_금액이_숫자가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateLottoCost("안녕"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 구입_금액이_빈문자열이면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateLottoCost(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 구입_금액이_NULL이면_예외가_발생한다(){
        String lottoCost = null;
        assertThatThrownBy(() -> lottoValidateService.validateLottoCost(lottoCost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 구입_금액이_0원_이하이면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateLottoCost("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 구입_금액이_최대한도를_넘으면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateLottoCost("150000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 구입_금액에_소수점이_존재하면_예외가_발생한다(){
        assertThatThrownBy(() -> lottoValidateService.validateLottoCost("8000.0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 구입_금액이_공백을_포함하면_예외가_발생한다(){ // 2000(공백)
        assertThatThrownBy(() -> lottoValidateService.validateLottoCost("8000 "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

}