package lotto.parser;

import static lotto.config.constant.ExceptionMessageConstant.INVALID_LOTTO_NUMBER_FORMAT;
import static lotto.config.constant.ExceptionMessageConstant.INVALID_LOTTO_PURCHASE_AMOUNT_FORMAT;
import static lotto.config.constant.ExceptionMessageConstant.INVALID_LOTTO_PURCHASE_AMOUNT_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputParserTest {

    UserInputParser userInputParser = new UserInputParser();

    @DisplayName("유효한 로또 구매 금액을 입력한다")
    @Test
    void 유효한_로또_구매_금액을_입력한다() {

        //given
        String lottoPurchaseAmountInput = "5000";

        //when
        long lottoPurchaseAmount = userInputParser.getLottoPurchaseAmount(lottoPurchaseAmountInput);

        //then
        assertThat(lottoPurchaseAmount).isEqualTo(5000);
    }

    @DisplayName("로또 구매 금액 입력을 숫자로 변환할 수 없을 때 예외가 발생한다")
    @Test
    void 로또_구매_금액_입력을_숫자로_변환할_수_없을_때_예외가_발생한다() {

        //given
        String lottoPurchaseAmountInput = "5,000";

        //then
        assertThatThrownBy(() -> userInputParser.getLottoPurchaseAmount(lottoPurchaseAmountInput)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining(INVALID_LOTTO_PURCHASE_AMOUNT_FORMAT);
    }

    @DisplayName("로또 구매 금액 입력이 1000원 단위로 나누어 떨어지지 않을 때 예외가 발생한다")
    @Test
    void 로또_구매_금액_입력이_1000원_단위로_나누어_떨어지지_않을_때_예외가_발생한다() {

        //given
        String lottoPurchaseAmountInput = "5001";

        //then
        assertThatThrownBy(() -> userInputParser.getLottoPurchaseAmount(lottoPurchaseAmountInput)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_PURCHASE_AMOUNT_UNIT);
    }

    @DisplayName("유효한 로또 당첨 번호를 입력한다")
    @Test
    void 유효한_로또_당첨_번호을_입력한다() {

        //given
        String lottoWinningNumbersInput = "1,2,3,4,5,6";

        //when
        List<Integer> lottoWinningNumbers = userInputParser.getLottoWinningNumbers(lottoWinningNumbersInput);

        //then
        assertThat(lottoWinningNumbers).containsExactly(1, 2, 3, 4, 5, 6);

    }


    @DisplayName("로또 당첨 번호 입력의 각 번호가 숫자로 변환 불가능 시 예외가 발생한다")
    @Test
    void 로또_당첨_번호_입력의_각_번호가_숫자로_변환_불가능_시_예외가_발생한다() {

        //given
        String lottoWinningNumbersInput = "one,2,3,four,5,6";

        //then
        assertThatThrownBy(() -> userInputParser.getLottoWinningNumbers(lottoWinningNumbersInput)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining(INVALID_LOTTO_NUMBER_FORMAT);
    }

    @DisplayName("유효한 로또 당첨 보너스 번호를 입력한다")
    @Test
    void 유효한_로또_당첨_보너스_번호를_입력한다() {

        //given
        String lottoWinningBonusNumberInput = "8";

        //when
        int winningBonusNumber = userInputParser.getLottoWinningBonusNumber(lottoWinningBonusNumberInput);

        //then
        assertThat(winningBonusNumber).isEqualTo(8);

    }

    @DisplayName("로또 당첨 보너스 입력을 숫자로 변환할 수 없을 때 예외가 발생한다")
    @Test
    void 로또_당첨_보너스_입력을_숫자로_변환할_수_없을_때_예외가_발생한다() {

        //given
        String lottoWinningBonusNumberInput = "eight";

        //then
        assertThatThrownBy(() -> userInputParser.getLottoWinningBonusNumber(lottoWinningBonusNumberInput)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining(INVALID_LOTTO_NUMBER_FORMAT);
    }


}