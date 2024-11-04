package lotto.service;

import lotto.domain.dto.LottoResultDto;
import lotto.enums.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constants.ErrorViewConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class ConverterServiceTest {
    @Test
    @DisplayName("입력 값이 유효하다면 로또 장 수를 리턴한다. ")
    void convertPurchasePriceWhenInputIsValid() {
        String enteredPurchasePrice = "5000";
        int result = ConverterService.convertPurchasePrice(enteredPurchasePrice);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("입력 값이 유효하지 않다면 에러를 리턴한다. ")
    void convertPurchasePriceWhenInputIsInvalid() {
        String enteredPurchasePrice = "12345678901"; // exceeds MAX_INT_LENGTH
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                ConverterService.convertPurchasePrice(enteredPurchasePrice)
        );
        assertEquals(INVALID_INPUT_CONSTRAINT, exception.getMessage());
    }

    @Test
    @DisplayName("문자열을 분리했을 때 올바르게 콤마 기준으로 분리되어야 한다")
    void splitWinningNumberWhenInputIsValid() {
        String enteredWinningNumber = "1,2,3,4,5,6";
        String[] result = ConverterService.splitWinningNumber(enteredWinningNumber);
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6"}, result);
    }

    @Test
    @DisplayName("올바르지 못한 문자열은 에러를 리턴해야 한다")
    void splitWinningNumberWhenInputIsInvalid() {
        String enteredWinningNumber = "1,2,3,4,5"; // less than WINNING_NUMBER_COUNT
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                ConverterService.splitWinningNumber(enteredWinningNumber)
        );
        assertEquals(INVALID_WINNING_NUMBERS, exception.getMessage());
    }

    @Test
    @DisplayName("올바른 문자열 배열은 정수형 배열로 변환이 일어나야 한다. ")
    void convertWinningNumberWhenInputIsValid() {
        String[] enteredWinningNumber = {"1", "2", "3", "4", "5", "6"};
        int[] result = ConverterService.convertWinningNumber(enteredWinningNumber);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, result);
    }

    @Test
    @DisplayName("올바르지 못한 문자열 배열은 에러를 리턴해야 한다. ")
    void convertWinningNumberWhenNumberOutOfRange() {
        String[] enteredWinningNumber = {"1", "2", "3", "4", "5", "46"}; // 46 is out of range
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                ConverterService.convertWinningNumber(enteredWinningNumber)
        );
        assertEquals(INVALID_WINNING_NUMBERS, exception.getMessage());
    }

    @Test
    @DisplayName("중복된 문자열 배열은 에러를 리턴해야 한다. ")
    void convertWinningNumberWhenNumbersAreDuplicated() {
        String[] enteredWinningNumber = {"1", "2", "3", "3", "5", "6"};
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                ConverterService.convertWinningNumber(enteredWinningNumber)
        );
        assertEquals(DUPLICATED_NUMBERS, exception.getMessage());
    }

    @Test
    @DisplayName("올바른 보너스 숫자 문자열이 입력된 경우 정수형으로 변경해서 반환한다. ")
    void convertBonusNumberWhenNotInWinningNumbers() {
        String enteredBonusNumber = "7";
        int[] winningNumbers = {1, 2, 3, 4, 5, 6};
        int result = ConverterService.convertBonusNumber(enteredBonusNumber, winningNumbers);
        assertEquals(7, result);
    }

    @Test
    @DisplayName("중복된 보너스 숫자 문자열이 입력된 경우 에러를 리턴한다. ")
    void convertBonusNumberWhenBonusInWinningNumbers() {
        String enteredBonusNumber = "3";
        int[] winningNumbers = {1, 2, 3, 4, 5, 6};
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                ConverterService.convertBonusNumber(enteredBonusNumber, winningNumbers)
        );
        assertEquals(DUPLICATED_NUMBERS, exception.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 보너스 숫자 문자열이 입력된 경우 에러를 리턴한다. ")
    void convertBonusNumberWhenInputIsNotANumber() {
        String enteredBonusNumber = "A"; // not a number
        int[] winningNumbers = {1, 2, 3, 4, 5, 6};
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                ConverterService.convertBonusNumber(enteredBonusNumber, winningNumbers)
        );
        assertEquals(INVALID_BONUS_NUMBERS, exception.getMessage());
    }

    @Test
    @DisplayName("당첨된 점수에 따라 올바른 PRIZE가 반환되어야 한다")
    void convertLottoResultDtoToPrize_ShouldReturnCorrectPrize() {
        LottoResultDto lottoResultDto = new LottoResultDto(6, false); // assuming 6 matches with bonus
        Prize result = ConverterService.convertLottoResultDtoToPrize(lottoResultDto);
        assertEquals(Prize.FIRST_PRIZE, result); // example based on Prize definition
    }

    @Test
    @DisplayName("수익률을 계산해서 리턴한다. ")
    void convertProfitToRate_ShouldReturnCorrectRate() {
        long profit = 2000;
        int purchasePrice = 1000;
        double result = ConverterService.convertProfitToRate(profit, purchasePrice);
        assertEquals(200.00, result, 0.01);
    }
}
