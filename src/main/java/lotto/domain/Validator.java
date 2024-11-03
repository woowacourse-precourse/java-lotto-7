package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.global.ErrorMessage;

public class Validator {

    public Validator() {}

    public int validateLottoPrice(String input) {
        try {
            int price = Integer.parseInt(input);
            if(price < 0) {
                throw new IllegalArgumentException(ErrorMessage.PRICE_ERROR);
            }
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_ERROR);
        }
    }

    public int validateLottoNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if(number < 0 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.ILLEGAL_LOTTO_NUMBER);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_LOTTO_NUMBER);
        }
    }

    public void validateLottoNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER);
        }
    }

}
