package lotto.service;

import lotto.ErrorCode;
import lotto.domain.LottoResult;
import lotto.domain.WinningInfo;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class WinningChecker {
    private static final Pattern isWinningNumberPattern = Pattern.compile("^(0?[1-9]|[1-3][0-9]|4[0-5])(,(0?[1-9]|[1-3][0-9]|4[0-5])){5}$");
    private static final String COMMA = ",";

    private final Lotto winningNumber;
    private final Integer bonusNumber;
    private final LottoResult result;

    public WinningChecker(String winningNumber, String bonusNumber, LottoResult result) {
        validateWinningNumber(winningNumber);
        validateBonusNumber(bonusNumber);
        this.winningNumber = Lotto.generateWinningNumber(winningNumber, COMMA);
        this.bonusNumber = Integer.parseInt(bonusNumber);
        this.result = result;
    }

    public void calculate(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Integer count = lotto.howManyMatches(winningNumber);
            WinningInfo winningInfo = WinningInfo.getWinningInfo(count);
            if (winningInfo.equals(WinningInfo.UNDEFINED)) {
                winningInfo = checkBonusNumber(lotto);
            }
            result.updateResult(winningInfo);
        }
    }

    private WinningInfo checkBonusNumber(Lotto lotto) {
        if (lotto.contains(bonusNumber)) {
            return WinningInfo.SECOND_WINNER;
        }
        if (!lotto.contains(bonusNumber)) {
            return WinningInfo.THIRD_WINNER;
        }
        return WinningInfo.NOT_MATCH;
    }

    private void validateWinningNumber(String winningNumber) throws IllegalArgumentException {
        validateWinningNumberRightFormat(winningNumber);
        validateWinningNumberDuplicate(winningNumber);
    }

    private void validateBonusNumber(String bonusNumber) throws IllegalArgumentException {
        validateInputNumeric(bonusNumber);
        validateBonusNumberInRange(bonusNumber);
        validateBonusNumberDuplicate(bonusNumber);
    }

    private void validateInputNumeric(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorCode.PRICE_POSITIVE_INTEGER.getErrorMessage());
        }
    }

    private void validateWinningNumberRightFormat(String input) {
        if (!isWinningNumberPattern.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorCode.WIN_NUMBER_PROPER.getErrorMessage());
        }
    }

    private void validateWinningNumberDuplicate(String input) {
        List<Integer> numbers = Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorCode.WIN_NUMBER_DUPLICATE.getErrorMessage());
        }
    }


    private void validateBonusNumberInRange(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (!(bonusNumber > 0 && bonusNumber < 46)) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_IN_RANGE.getErrorMessage());
        }
    }

    private void validateBonusNumberDuplicate(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_DUPLICATE.getErrorMessage());
        }
    }

}
