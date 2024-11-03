package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.util.message.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    private InputParser inputParser;

    @BeforeEach
    public void setUp() {
        inputParser = new InputParser();
    }

    @Test
    public void 정상적인_구입_금액이_들어온_경우_예외_발생_안함() {
        String validInput = "8000";

        int purchaseAmount = inputParser.parsePurchaseAmount(validInput);
        assertEquals(8, purchaseAmount);
    }

    @Test
    public void 구입_금액으로_빈_문자열이_들어온_경우_예외_발생() {
        String invalidInput = "";

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parsePurchaseAmount(invalidInput)
        );
        assertEquals(ErrorMessage.EMPTY_INPUT_ERROR, exception.getMessage());
    }

    @Test
    public void 구입_금액으로_문자가_들어온_경우_예외_발생() {
        String invalidInput = "abc";

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parsePurchaseAmount(invalidInput)
        );
        assertEquals(ErrorMessage.NUMBER_FORMAT_ERROR, exception.getMessage());
    }

    @Test
    public void 구입_금액으로_음수값이_들어온_경우_예외_발생() {
        String negativeInput = "-1000";

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parsePurchaseAmount(negativeInput)
        );
        assertEquals(ErrorMessage.INVALID_AMOUNT_ERROR, exception.getMessage());
    }

    @Test
    public void 구입_금액으로_1000원으로_나누어_떨어지지_않는_수가_들어온_경우_예외_발생() {
        String nonDivisibleInput = "1500";

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parsePurchaseAmount(nonDivisibleInput)
        );
        assertEquals(ErrorMessage.AMOUNT_UNIT_ERROR, exception.getMessage());
    }

    // 담첨 번호 테스트 -----------

    @Test
    public void 당첨_번호로_정상적인_값이_들어온_경우_예외_발생_안됨() {
        String validInput = "1,2,3,4,5,6";
        Lotto lotto = inputParser.parseWinningNumbers(validInput);

        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expectedNumbers, lotto.getNumbers());
    }

    @Test
    public void 당첨_번호로_빈_문자열이_들어온_경우_예외_발생() {
        String emptyInput = "";

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parseWinningNumbers(emptyInput)
        );
        assertEquals(ErrorMessage.EMPTY_INPUT_ERROR, exception.getMessage());
    }

    @Test
    public void 당첨_번호에_공백이_섞여있는_경우_예외_발생() {
        String invalidInput = "1,2,3,4, 5,6";

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parseWinningNumbers(invalidInput)
        );
        assertEquals(ErrorMessage.CONTAIN_SPACE_ERROR, exception.getMessage());
    }

    @Test
    public void 당첨_번호에_콤마외의_숫자가_아닌_다른_문자가_있는_경우_예외_발생() {
        String invalidInput = "1,2,a,4,5,6";

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parseWinningNumbers(invalidInput)
        );
        assertEquals(ErrorMessage.NUMBER_FORMAT_ERROR, exception.getMessage());
    }

    @Test
    public void 당첨_번호에_허용된_범위외의_숫자가_있는_경우_예외_발생() {
        String invalidInput = "1,2,3,4,5,46";

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parseWinningNumbers(invalidInput)
        );
        assertEquals(ErrorMessage.NUMBER_RANGE_ERROR, exception.getMessage());
    }

    @Test
    public void 당첨_번호에_중복된_숫자가_있는_경우_예외_발생() {
        String invalidInput = "1,2,3,3,5,6";

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parseWinningNumbers(invalidInput)
        );
        assertEquals(ErrorMessage.DUPLICATE_NUMBER_ERROR, exception.getMessage());
    }

    @Test
    public void 당첨_번호의_개수가_6개가_아닌_경우_테스트() {
        String invalidInput = "1,2,3,4,6";

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parseWinningNumbers(invalidInput)
        );
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", exception.getMessage());
    }

    // 보너스 번호 테스트 -----------

    @Test
    public void 정상적인_보너스_번호가_들어온_경우_예외_발생_안함() {
        List<Integer> winningNumbersList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = new Lotto(winningNumbersList);
        String validInput = "8";

        int bonusNumber = inputParser.parseBonusNumber(winningNumbers, validInput);
        assertEquals(8, bonusNumber);
    }

    @Test
    public void 보너스_번호로_빈_문자열이_들어온_경우_예외_발생() {
        List<Integer> winningNumbersList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = new Lotto(winningNumbersList);
        String invalidInput = "";

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parseBonusNumber(winningNumbers, invalidInput)
        );
        assertEquals(ErrorMessage.EMPTY_INPUT_ERROR, exception.getMessage());
    }

    @Test
    public void 보너스_번호로_문자가_들어온_경우_예외_발생() {
        List<Integer> winningNumbersList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = new Lotto(winningNumbersList);
        String invalidInput = "a";

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parseBonusNumber(winningNumbers, invalidInput)
        );
        assertEquals(ErrorMessage.NUMBER_FORMAT_ERROR, exception.getMessage());
    }

    @Test
    public void 보너스_번호로_허용된_범위외의_숫자가_들어온_경우_예외_발생() {
        List<Integer> winningNumbersList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = new Lotto(winningNumbersList);
        String invalidInput = "46";

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parseBonusNumber(winningNumbers, invalidInput)
        );
        assertEquals(ErrorMessage.NUMBER_RANGE_ERROR, exception.getMessage());
    }

    @Test
    public void 보너스_번호로_당첨_번호와_중복되는_번호가_들어오는_경우_예외_발생() {
        List<Integer> winningNumbersList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = new Lotto(winningNumbersList);
        String invalidInput = "6";

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> inputParser.parseBonusNumber(winningNumbers, invalidInput)
        );
        assertEquals(ErrorMessage.DUPLICATE_BONUS_ERROR, exception.getMessage());
    }
}