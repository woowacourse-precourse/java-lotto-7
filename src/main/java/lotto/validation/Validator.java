package lotto.validation;

import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Validator {
    private static final LottoView lottoView = new LottoView();

    public static int validateLottoCount() {
        int price;
        try {
            price = Integer.parseInt(lottoView.input.price());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        if (price <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_OR_ZERO.getMessage());
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }
        return price / 1000;
    }

    public static List<Integer> validateWinningNumber(String[] inputWinningNumber) {
        List<Integer> winningNumber = new ArrayList<>();
        if (inputWinningNumber.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getMessage());
        }
        for (String strNumber : inputWinningNumber) {
            int number;
            try {
                number = Integer.parseInt(strNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
            }
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
            }
            winningNumber.add(number);
        }
        if (new HashSet<>(winningNumber).size() != 6) {
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
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WITH_WIN_NUMBER.getMessage());
        }
        return bonusNumber;

    }
}
