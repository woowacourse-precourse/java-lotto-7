package lotto.validation;

import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Validator {
    private static final LottoView lottoView = new LottoView();


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
        if (inputPrice % Constant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }
        return inputPrice / Constant.LOTTO_PRICE;
    }

    public static List<Integer> validateWinningNumber(String[] inputWinningNumber) {
        List<Integer> winningNumber = new ArrayList<>();
        if (inputWinningNumber.length != Constant.LOTTO_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getMessage());
        }
        for (String strNumber : inputWinningNumber) {
            int number;
            try {
                number = Integer.parseInt(strNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
            }
            if (number < Constant.LOTTO_NUMBER_MIN || number > Constant.LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
            }
            winningNumber.add(number);
        }
        if (new HashSet<>(winningNumber).size() != Constant.LOTTO_LENGTH) {
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
        if (bonusNumber < Constant.LOTTO_NUMBER_MIN || bonusNumber > Constant.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WITH_WIN_NUMBER.getMessage());
        }
        return bonusNumber;

    }
}
