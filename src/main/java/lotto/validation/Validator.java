package lotto.validation;

import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Validator {
    private static final LottoView lottoView = new LottoView();
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_LENGTH = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;


    public static int validateLottoCount() {
        int inputPrice;
        try {
            inputPrice = Integer.parseInt(lottoView.input.price());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        if (inputPrice <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_OR_ZERO.getMessage());
        }
        if (inputPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }
        return inputPrice / LOTTO_PRICE;
    }

    public static List<Integer> validateWinningNumber(String[] inputWinningNumber) {
        List<Integer> winningNumber = new ArrayList<>();
        if (inputWinningNumber.length != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getMessage());
        }
        for (String strNumber : inputWinningNumber) {
            int number;
            try {
                number = Integer.parseInt(strNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
            }
            if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
            }
            winningNumber.add(number);
        }
        if (new HashSet<>(winningNumber).size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }

        return winningNumber;
    }

    public static int validateBonusNumber(List<Integer> winningNumber) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(lottoView.input.bonusNumber());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WITH_WIN_NUMBER.getMessage());
        }
        return bonusNumber;

    }
}
