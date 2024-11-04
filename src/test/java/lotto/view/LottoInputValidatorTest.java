package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.enums.LottoError;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoInputValidatorTest {

    private final LottoInputValidator lottoInputValidator;

    public LottoInputValidatorTest() {
        lottoInputValidator = new LottoInputValidator();
    }


    @ParameterizedTest
    @ValueSource(strings = {"1000,", "1,000", ";[];;[;.;", "100000;0000", "10000.00000", "[100000000]", "1,2"})
    @EmptySource
    void 로또_구입_금액이_숫자가_아닌_문자가_포함되어있다면_예외가_발생한다(String purchasePrice) {

        assertThatThrownBy(() -> lottoInputValidator.validateLottoPurchasePrice(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.INPUT_NUMBER_INVALID.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,", ",1,2,3,4", ",1,2,3,4,", "1,2,3:4", "[1,2,3,4]", "1, 2, 3, 4"})
    void 로또_당첨_번호의_형식이_올바르지_않다면_예외가_발생한다(String lottoWinningNumbers) {

        assertThatThrownBy(() -> lottoInputValidator.validateLottoWinningNumbers(lottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.INPUT_NUMBERS_INVALID.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,", ",1", ",1,", "1,2"})
    @EmptySource
    void 보너스_번호의_형식이_올바르지_않다면_예외가_발생한다(String bonusNumber) {

        assertThatThrownBy(() -> lottoInputValidator.validateLottoBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.INPUT_NUMBER_INVALID.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "100", "10000000", "100000000000", "1000000000000", "0"})
    void 로또_구입_금액의_형식이_올바르다면_예외가_발생하지_않는다(String purchasePrice) {
        lottoInputValidator.validateLottoPurchasePrice(purchasePrice);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2", "1,2,3", "1,2,3,4", "1,2,3,4,5", "1,2,3,4,5,6", "1,2,3,4,5,6,7"})
    void 로또_당첨_번호의_형식이_올바르다면_예외가_발생하지_않는다(String winningLottoNumbers) {
        lottoInputValidator.validateLottoWinningNumbers(winningLottoNumbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void 보너스_번호의_형식이_올바르다면_예외가_발생하지_않는다(String bonusNumber) {
        lottoInputValidator.validateLottoBonusNumber(bonusNumber);
    }


}
