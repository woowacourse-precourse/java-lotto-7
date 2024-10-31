package lotto.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class UserInputTest {

    UserInput userInput = new UserInput();

    @Test
    void 유효한_로또_구매_금액_입력_테스트() {
        //given
        String lottoPurchaseAmountInput = "5000";

        //when
        long lottoPurchaseAmount = userInput.getLottoPurchaseAmount(lottoPurchaseAmountInput);

        //then
        assertThat(lottoPurchaseAmount).isEqualTo(5000);
    }

    @Test
    void 로또_구매_금액_입력을_숫자로_변환할_수_없을_때_예외_테스트() {
        //given
        String lottoPurchaseAmountInput = "5,000";

        //then
        assertThatThrownBy(() ->
                userInput.getLottoPurchaseAmount(lottoPurchaseAmountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "[ERROR] 로또 구입 금액은 숫자입니다."
                );
    }

    @Test
    void 로또_구매_금액_입력이_1000원_단위로_나누어_떨어지지_않을_때_예외_테스트() {
        //given
        String lottoPurchaseAmountInput = "5001";

        //then
        assertThatThrownBy(() ->
                userInput.getLottoPurchaseAmount(lottoPurchaseAmountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "[ERROR] 로또 구입 금액은 " + userInput.LOTTO_AMOUNT_UNIT + "원 단위입니다."
                );
    }

    @Test
    void 유효한_로또_당첨_번호_입력_테스트() {
        //given
        String lottoWinningNumbersInput = "1,2,3,4,5,6";

        //when
        int[] lottoWinningNumbers = userInput.getLottoWinningNumbers(lottoWinningNumbersInput);

        //then
        assertThat(lottoWinningNumbers).containsExactly(1, 2, 3, 4, 5, 6);

    }

    @Test
    void 로또_당첨_번호_입력의_로또_번호_개수가_요구사항과_다를_시_예외_테스트() {

        //given
        String lottoWinningNumbersInput = "1,2,3,4,5,6,7";

        //then
        assertThatThrownBy(() ->
                userInput.getLottoWinningNumbers(lottoWinningNumbersInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "[ERROR] 로또 당첨 번호의 개수는 " + userInput.NUMBER_OF_LOTTO_WINNING_NUMBERS + "개 입니다."
                );
    }

    @Test
    void 로또_당첨_번호_입력의_각_번호가_숫자로_변환_불가능_시_예외_테스트() {
        //given
        String lottoWinningNumbersInput = "one,2,3,four,5,6";

        //then
        assertThatThrownBy(() ->
                userInput.getLottoWinningNumbers(lottoWinningNumbersInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "[ERROR] 로또 당첨 번호는 숫자여야 합니다."
                );
    }

    @Test
    void 로또_당첨_번호_입력의_각_번호가_1부터_45_범위_밖일_시_예외_테스트() {
        //given
        String lottoWinningNumbersInput = "-1,0,2,46,47,99";

        //then
        assertThatThrownBy(() ->
                userInput.getLottoWinningNumbers(lottoWinningNumbersInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "[ERROR] 로또 당첨 번호는 " + userInput.LOTTO_NUMBER_MINIMUM_VALUE + "~" + userInput.LOTTO_NUMBER_MAXIMUM_VALUE + "까지 입니다."
                );
    }

}