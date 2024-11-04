package lotto.model;

import lotto.exception.WinningLottoNumberException;
import lotto.validation.WinningLottoNumberValidator;

import java.util.Arrays;
import java.util.List;

import static lotto.common.constant.ErrorMessage.WINNING_LOTTO_NUMBER_FORMAT_ERROR;

public class WinningLottoNumber {
    private final List<Integer> winningNumbers;
    private final String delimiter = ",";

    private WinningLottoNumber(String userInputWinningLottoNumber) {
        this.winningNumbers = parseUserInputWinningLottoNumber(userInputWinningLottoNumber);
    }

    public static WinningLottoNumber of(String userInputWinningLottoNumber) {
        WinningLottoNumberValidator.throwExceptionPrefixOrSuffixIsComma(userInputWinningLottoNumber);
        return new WinningLottoNumber(userInputWinningLottoNumber);
    }

    private List<Integer> parseUserInputWinningLottoNumber(String userInputWinningLottoNumber) {
        List<Integer> parsedWinningNumbers;
        try {
            parsedWinningNumbers = Arrays.stream(userInputWinningLottoNumber.split(delimiter))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (Exception e) {
            throw new WinningLottoNumberException(WINNING_LOTTO_NUMBER_FORMAT_ERROR);
        }

        WinningLottoNumberValidator.validateWinningLottoNumber(parsedWinningNumbers);
        return parsedWinningNumbers;
    }

    public boolean isContainInWinningLottoNumber(BonusNumber bonusNumber) {
        return winningNumbers.contains(bonusNumber.getBonusNumber());
    }

    public Long getMatchCountWithWinningLottoNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
