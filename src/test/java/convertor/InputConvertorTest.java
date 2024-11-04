package convertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import convert.InputConvertor;
import exception.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputConvertorTest {

    private InputConvertor inputConvertor = new InputConvertor();

    @DisplayName("구입 금액이 1,000원 단위의 숫자일 때 정수형으로 변환한다.")
    @Test
    void convertPurchaseAmountWhenIsThousandsUnitAndNumber() {
        // given
        String purchaseAmount = "2000";

        // when
        int convertPurchaseAmount = inputConvertor.convertPurchaseAmount(purchaseAmount);

        // then
        assertEquals(convertPurchaseAmount, Integer.parseInt(purchaseAmount));
    }

    @DisplayName("구입 금액이 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenPurchaseAmountIsNotNumberFormat() {
        // given
        String purchaseAmount = "NOT_NUMBER";

        // when     // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputConvertor.convertPurchaseAmount(purchaseAmount));

        assertEquals(exception.getMessage(), ErrorMessage.NOT_NUMBER_FORMAT_MSG.getMessage());
    }

    @DisplayName("구입 금액이 1,000원 단위가 아닐 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenPurchaseAmountIsNotThousandsUnit() {
        // given
        String purchaseAmount = "1234";

        // when     // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputConvertor.convertPurchaseAmount(purchaseAmount));

        assertEquals(exception.getMessage(), ErrorMessage.PURCHASE_AMOUNT_INVALID_UNIT_MSG.getMessage());
    }

    @DisplayName("입력 받은 6개 당첨 번호를 정수형 리스트로 반환한다.")
    @Test
    void convertInputWinningNumbers() {
        // given
        String inputWinningNumbers = "1,2,3,4,5,6";
        List<Integer> aspectWinningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        List<Integer> winningNumbers = inputConvertor.convertInputWinningNumbers(inputWinningNumbers);

        // then
        assertEquals(aspectWinningNumbers, winningNumbers);
    }

    @DisplayName("입력 받은 6개 당첨 번호 중 숫자 포맷이 아닌 값이 있을 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenWinningNumberIsNotNumberFormat() {
        // given
        String inputWinningNumbers = "a,2,3,4,5,6";

        // when     // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputConvertor.convertInputWinningNumbers(inputWinningNumbers));

        assertEquals(exception.getMessage(), ErrorMessage.NOT_NUMBER_FORMAT_MSG.getMessage());
    }

    @DisplayName("입력 받은 6개 당첨 번호 중 1과 45 사잇값 아닐 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenWinningNumberIsNotOneBetweenFortyFiveNumber() {
        // given
        String inputWinningNumbers = "1,2,3,4,5,60";

        // when     // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputConvertor.convertInputWinningNumbers(inputWinningNumbers));

        assertEquals(exception.getMessage(), ErrorMessage.NOT_ONE_BETWEEN_FORTY_FIVE_MSG.getMessage());
    }

    @DisplayName("입력 받은 당첨 번호가 중복될 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenWinningNumberIsDuplicated() {
        // given
        String inputWinningNumbers = "1,2,3,4,5,5";

        // when     // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputConvertor.convertInputWinningNumbers(inputWinningNumbers));

        assertEquals(exception.getMessage(), ErrorMessage.DUPLICATE_WINNING_NUMBERS_MSG.getMessage());
    }

    @DisplayName("입력 받은 당첨 번호가 6개가 아닐 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenWinningNumberIsNotSixNumbers() {
        // given
        String inputWinningNumbers = "1,2,3,4,5";

        // when     // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputConvertor.convertInputWinningNumbers(inputWinningNumbers));

        assertEquals(exception.getMessage(), ErrorMessage.NOT_SIX_WINNING_NUMBERS_MSG.getMessage());
    }

    @DisplayName("입력 받은 보너스 번호를 정수형으로 변환한다.")
    @Test
    void convertInputBonusNumbers() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String inputBonusNumber = "7";

        // when
        int bonusNumber = inputConvertor.convertInputBonusNumber(inputBonusNumber, winningNumbers);

        // then
        assertEquals(bonusNumber, Integer.parseInt(inputBonusNumber));
    }

    @DisplayName("입력 받은 보너스 번호가 숫자 형태가 아닐 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenBonsuNumberIsNotNumberFormat() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String inputBonusNumber = "bonus";

        // when     // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputConvertor.convertInputBonusNumber(inputBonusNumber, winningNumbers));

        assertEquals(exception.getMessage(), ErrorMessage.NOT_NUMBER_FORMAT_MSG.getMessage());
    }

    @DisplayName("입력 받은 보너스 번호가 당첨 번호와 같을 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenBonsuNumberInWinningNumbers() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String inputBonusNumber = "1";

        // when     // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputConvertor.convertInputBonusNumber(inputBonusNumber, winningNumbers));

        assertEquals(exception.getMessage(), ErrorMessage.BONUS_NUMBER_IN_WINNING_NUMBERS_MSG.getMessage());
    }

    @DisplayName("입력 받은 보너스 번호가 1과 45 사잇값이 아닐 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenBonsuNumberIsNotOneBetweenFortyFiveNumber() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String inputBonusNumber = "46";

        // when     // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputConvertor.convertInputBonusNumber(inputBonusNumber, winningNumbers));

        assertEquals(exception.getMessage(), ErrorMessage.NOT_ONE_BETWEEN_FORTY_FIVE_MSG.getMessage());
    }
}
