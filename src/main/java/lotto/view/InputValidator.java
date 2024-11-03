package lotto.view;

import lotto.constants.ErrorCode;
import lotto.constants.Value;

import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    public Long parseMoney(String money) {
        try {
            return Long.parseLong(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.MONEY_TYPE_ERROR.getMessage());
        }
    }

    public void validMoney(Long money) {
        if (money < Value.lottoPrice) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_MIN_PRICE_ERROR.getMessage());
        }
        if (money % Value.lottoPrice != 0) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_PRICE_ERROR.getMessage());
        }
    }

    public List<Integer> parseNumbers(String numbers) {
        try {
            return List.of(numbers.split(",")).stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.WINNING_NUMBER_TYPE_ERROR.getMessage());
        }
    }

    public void validWinningNumber(List<Integer> numbers) {
        if (numbers.size() != Value.lottoNumberCount) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_COUNT_ERROR.getMessage());
        }
        if (numbers.stream().anyMatch(number -> number < Value.lottoStartNumber || number > Value.lottoEndNumber)) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
        if (numbers.stream().distinct().count() != Value.lottoNumberCount) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    public Integer parseBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_TYPE_ERROR.getMessage());
        }
    }

    public void validBonusNumber(Integer bonusNumber) {
        if (bonusNumber < Value.lottoStartNumber || bonusNumber > Value.lottoEndNumber) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }
}
