package lotto.io;

import static lotto.constant.ExceptionMessageConstant.INVALID_LOTTO_NUMBER_FORMAT;
import static lotto.constant.ExceptionMessageConstant.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.constant.ExceptionMessageConstant.INVALID_LOTTO_PURCHASE_AMOUNT_FORMAT;
import static lotto.constant.ExceptionMessageConstant.INVALID_LOTTO_PURCHASE_AMOUNT_UNIT;
import static lotto.constant.ExceptionMessageConstant.INVALID_LOTTO_REQUIRED_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.parser.UserInputParser;
import org.junit.jupiter.api.Test;

class UserInputParserTest {

    UserInputParser userInputParser = new UserInputParser();

    @Test
    void 유효한_로또_구매_금액을_입력한다() {

        //given
        String lottoPurchaseAmountInput = "5000";

        //when
        long lottoPurchaseAmount = userInputParser.getLottoPurchaseAmount(lottoPurchaseAmountInput);

        //then
        assertThat(lottoPurchaseAmount).isEqualTo(5000);
    }

    @Test
    void 로또_구매_금액_입력을_숫자로_변환할_수_없을_때_예외가_발생한다() {

        //given
        String lottoPurchaseAmountInput = "5,000";

        //then
        assertThatThrownBy(() -> userInputParser.getLottoPurchaseAmount(lottoPurchaseAmountInput)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining(INVALID_LOTTO_PURCHASE_AMOUNT_FORMAT);
    }

    @Test
    void 로또_구매_금액_입력이_1000원_단위로_나누어_떨어지지_않을_때_예외가_발생한다() {

        //given
        String lottoPurchaseAmountInput = "5001";

        //then
        assertThatThrownBy(() -> userInputParser.getLottoPurchaseAmount(lottoPurchaseAmountInput)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_PURCHASE_AMOUNT_UNIT);
    }

    @Test
    void 유효한_로또_당첨_번호을_입력한다() {

        //given
        String lottoWinningNumbersInput = "1,2,3,4,5,6";

        //when
        int[] lottoWinningNumbers = userInputParser.getLottoWinningNumbers(lottoWinningNumbersInput);

        //then
        assertThat(lottoWinningNumbers).containsExactly(1, 2, 3, 4, 5, 6);

    }

    @Test
    void 로또_당첨_번호_입력의_로또_번호_개수가_요구사항과_다를_시_예외가_발생한다() {

        //given
        String lottoWinningNumbersInput = "1,2,3,4,5,6,7";

        //then
        assertThatThrownBy(() -> userInputParser.getLottoWinningNumbers(lottoWinningNumbersInput)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_REQUIRED_COUNT);
    }

    @Test
    void 로또_당첨_번호_입력의_각_번호가_숫자로_변환_불가능_시_예외가_발생한다() {

        //given
        String lottoWinningNumbersInput = "one,2,3,four,5,6";

        //then
        assertThatThrownBy(() -> userInputParser.getLottoWinningNumbers(lottoWinningNumbersInput)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining(INVALID_LOTTO_NUMBER_FORMAT);
    }

    @Test
    void 로또_당첨_번호_입력의_각_번호가_1부터_45_범위_밖일_시_예외가_발생한다() {

        //given
        String lottoWinningNumbersInput = "-1,0,2,46,47,99";

        //then
        assertThatThrownBy(() -> userInputParser.getLottoWinningNumbers(lottoWinningNumbersInput)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining(
                INVALID_LOTTO_NUMBER_RANGE);
    }

    @Test
    void 유효한_로또_당첨_보너스_번호를_입력한다() {

        //given
        String lottoWinningBonusNumberInput = "8";

        //when
        int winningBonusNumber = userInputParser.getLottoWinningBonusNumber(lottoWinningBonusNumberInput);

        //then
        assertThat(winningBonusNumber).isEqualTo(8);

    }

    @Test
    void 로또_당첨_보너스_입력을_숫자로_변환할_수_없을_때_예외가_발생한다() {

        //given
        String lottoWinningBonusNumberInput = "eight";

        //then
        assertThatThrownBy(() -> userInputParser.getLottoWinningBonusNumber(lottoWinningBonusNumberInput)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining(INVALID_LOTTO_NUMBER_FORMAT);
    }

    @Test
    void 로또_당첨_보너스_입력이_1부터_45범위_밖일_시_예외가_발생한다() {

        //given
        String lottoPurchaseAmountInput = "46";

        //then
        assertThatThrownBy(() -> userInputParser.getLottoWinningBonusNumber(lottoPurchaseAmountInput)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining(INVALID_LOTTO_NUMBER_RANGE);
    }

}