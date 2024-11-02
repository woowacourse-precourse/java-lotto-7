package lotto.validator;

import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.IllegalLottoNumberException;
import lotto.exception.LottoNumberFormatException;
import lotto.exception.LottoNumberQuantityException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumberValidator {

    public List<Integer> validateWinningNumbers(String input) throws IllegalLottoNumberException{
        String[] splitedWinningNums = validateQuantity(input);
        List<Integer> parsedWinningNums = new ArrayList<>();
        for (String winningNum : splitedWinningNums) {
            int parsedWinningNum = validateFormat(winningNum);
            parsedWinningNums.add(parsedWinningNum);
        }
        validateUniqueness(parsedWinningNums);
        return parsedWinningNums;
    }

    public int validateBonusNumber(List<Integer> winningNums, String input) throws IllegalLottoNumberException{
        int parsedBonusNum = validateFormat(input);
        validateUniqueness(winningNums, parsedBonusNum);
        return parsedBonusNum;
    }

    private int validateFormat(String number) {
        try {
            int parsedNum = Integer.parseInt(number);
            if (parsedNum <= 0 || parsedNum >= 46) {
                throw new NumberFormatException();
            }
            return parsedNum;
        } catch (NumberFormatException e) {
            throw new LottoNumberFormatException();
        }
    }

    private String[] validateQuantity(String winningNums) {
        String[] splitedWinningNums = winningNums.split(",");
        if (splitedWinningNums.length != 6) {
            throw new LottoNumberQuantityException();
        }
        return splitedWinningNums;
    }

    // 당첨 번호 중복 검사
    private void validateUniqueness(List<Integer> winningNums) {
        Set<Integer> tempWinningNums = new HashSet<>(winningNums);
        if (tempWinningNums.size() != winningNums.size()) {
            throw new DuplicateLottoNumberException();
        }
    }

    // 보너스 번호 중복 검사
    private void validateUniqueness(List<Integer> winningNums, int bonusNum) {
        if (winningNums.contains(bonusNum)) {
            throw new DuplicateLottoNumberException();
        }
    }
}
