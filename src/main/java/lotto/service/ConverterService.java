package lotto.service;

import lotto.constants.ConstraintConstants;
import lotto.domain.dto.LottoResultDto;
import lotto.enums.Prize;

import java.math.BigDecimal;

import static lotto.constants.ConstraintConstants.MAX_INT_LENGTH;
import static lotto.constants.ErrorViewConstants.*;
import static lotto.service.ValidatorService.*;

public class ConverterService {
    private static final double RATE = 100.0f;
    private static final String formatter = "%.2f";
    public static int convertPurchasePrice(String enteredPurchasePrice) {
        try {
            if (enteredPurchasePrice.length() >= MAX_INT_LENGTH) {
                throw new IllegalArgumentException(INVALID_INPUT_CONSTRAINT);
            }

            int purchasePrice = Integer.parseInt(enteredPurchasePrice);
            if (validatePurchaseAmount(purchasePrice)) {
                return purchasePrice / ConstraintConstants.PURCHASE_UNIT;
            }
            throw new IllegalArgumentException(INVALID_INPUT_CONSTRAINT);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS);
        }
    }

    public static String[] splitWinningNumber(String enteredWinningNumber) {
        enteredWinningNumber = enteredWinningNumber.replaceAll(" ", "");
        String[] splitWinningNumber = enteredWinningNumber.split(",");
        if (splitWinningNumber.length != ConstraintConstants.WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS);
        }
        return splitWinningNumber;
    }

    public static int[] convertWinningNumber(String[] enteredWinningNumber) {
        if (!validateWinningNumbersFormat(enteredWinningNumber)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS);
        }

        int[] result = new int[enteredWinningNumber.length];
        for (int i = 0; i < enteredWinningNumber.length; i++) {

            result[i] = Integer.parseInt(enteredWinningNumber[i]);

            if (!ValidatorService.isValidNumber(result[i])) {
                throw new IllegalArgumentException(INVALID_WINNING_NUMBERS);
            }
        }
        if (!ValidatorService.isUniqueNumber(result)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBERS);
        }
        return result;
    }

    public static int convertBonusNumber(String enteredBonusNumber, int[] winningNumbers) {
        try {
            int bonusNumber = Integer.parseInt(enteredBonusNumber);
            for (int winningNumber : winningNumbers) {
                if (bonusNumber == winningNumber) {
                    throw new IllegalArgumentException(DUPLICATED_NUMBERS);
                }
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBERS);
        }
    }

    public static Prize convertLottoResultDtoToPrize(LottoResultDto lottoResultDto) {
        return Prize.getPrizeByMatchCountAndBonus(lottoResultDto.getWinningNumber(), lottoResultDto.getIsBonus());
    }

    public static double convertProfitToRate(long profit, int purchasePrice) {
        BigDecimal profitRate = BigDecimal.valueOf((float) profit / (float) purchasePrice * RATE);
        return Double.parseDouble(String.format(formatter, profitRate));
    }
}
