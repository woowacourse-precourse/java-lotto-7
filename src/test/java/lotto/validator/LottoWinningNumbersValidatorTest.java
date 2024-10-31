package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoWinningNumbersValidatorTest {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private final LottoWinningNumbersValidator lottoWinningNumbersValidator;

    public LottoWinningNumbersValidatorTest() {
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX);
        this.lottoWinningNumbersValidator = new LottoWinningNumbersValidator(lottoNumberValidator);
    }

    @Test
    public void 문자가_포함된_당첨번호가_입력되면_예외가_발생한다() {
        String winningNumbers = "1,2,32,5,6.8";

        assertThatThrownBy(() -> lottoWinningNumbersValidator.validateLottoWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호_개수가_6개_미만이라면_예외가_발생한다() {
        String winningNumbers = "1,2,3,4,5";

        assertThatThrownBy(() -> lottoWinningNumbersValidator.validateLottoWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호중_최소미만_숫자가_포함되어있다면_예외가_발생한다() {
        String winningNumbers = "1,2,3,4,5," + (LOTTO_NUMBER_MIN - 1);

        assertThatThrownBy(() -> lottoWinningNumbersValidator.validateLottoWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호중_최대_초과_숫자가_포함되어_있다면_예외가_발생한다() {
        String winningNumbers = "1,2,3,4,5," + (LOTTO_NUMBER_MAX + 1);

        assertThatThrownBy(() -> lottoWinningNumbersValidator.validateLottoWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호중_중복이_있다면_예외가_발생한다() {
        String winningNumbers = "1,2,3,4,5,1";

        assertThatThrownBy(() -> lottoWinningNumbersValidator.validateLottoWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 올바른_당첨_번호_테스트() {
        String winningNumbers = "1,2,3,4,5,45";

        lottoWinningNumbersValidator.validateLottoWinningNumbers(winningNumbers);
    }
}
