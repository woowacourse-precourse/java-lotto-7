package lotto.parser;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    @DisplayName("구매 금액이 1000원보다 작을 경우")
    void 구매_금액이_1000원_이하_예외가_발생한다() {
        // given
        String purchaseAmount = "100";

        // when-then
        assertThrows(IllegalArgumentException.class, () -> InputParser.parsePurchaseAmount(purchaseAmount));
    }

    @Test
    @DisplayName("구매 금액이 isBlank 인 경우")
    void 구매_금액이_입력되지_않으면_예외가_발생한다() {
        // given
        String purchaseAmount = " ";

        // when-then
        assertThrows(IllegalArgumentException.class, () -> InputParser.parsePurchaseAmount(purchaseAmount));
    }

    @Test
    @DisplayName("구매 금액이 숫자가 아닌 경우")
    void 구매_금액이_숫자가_아니면_예외가_발생한다() {
        // given
        String purchaseAmount = "ttt";

        // when-then
        assertThrows(IllegalArgumentException.class, () -> InputParser.parsePurchaseAmount(purchaseAmount));
    }

    @Test
    @DisplayName("당첨번호가 isBlank인 경우")
    void 당첨_번호가_입력되지_않으면_예외가_발생한다() {
        // given
        String winningNumbers = "";

        // when-then
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseWinningNumbers(winningNumbers));
    }

    @Test
    @DisplayName("당첨번호가 중복인 경우")
    void 당첨_번호에_중복_숫자가_있으면_예외가_발생한다() {
        // given
        String winningNumbers = "1,2,3,4,5,5";

        // when-then
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseWinningNumbers(winningNumbers));
    }

    @Test
    @DisplayName("당첨번호가 1부터 45사이의 숫자가 아닌 경우 경우")
    void 당첨_번호에_1부터_45사이의_숫자가_아닌_수가_존재하면_예외가_발생한다() {
        // given
        String winningNumbers = "1,2,3,4,5,46";

        // when-then
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseWinningNumbers(winningNumbers));
    }

    @Test
    @DisplayName("당첨번호가 숫자가 아닌 경우 경우")
    void 당첨_번호에_숫자가_아니면_예외가_발생한다() {
        // given
        String winningNumbers = "1,2,3,4,5,t";

        // when-then
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseWinningNumbers(winningNumbers));
    }

    @Test
    @DisplayName("보너스 번호가 isBlank 인 경우 경우")
    void 보너스_번호가_입력되지_않으면_예외가_발생한다() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = " ";

        // when-then
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseBonusNumber(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닌 경우 경우")
    void 보너스_번호에_숫자가_아니면_예외가_발생한다() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "t";

        // when-then
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseBonusNumber(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호와 중복인 경우 경우")
    void 보너스_번호가_당첨_번호와_중복이_있으면_예외가_발생한다() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "1";

        // when-then
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseBonusNumber(winningNumbers, bonusNumber));
    }
}
