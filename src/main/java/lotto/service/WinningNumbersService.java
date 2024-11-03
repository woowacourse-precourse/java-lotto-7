package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ExceptionConstant;
import lotto.constant.LottoConstant;
import lotto.constant.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;

public class WinningNumbersService {

    public WinningNumbers createWinningNumbers(String input) {
        inputValidate(input);
        return new WinningNumbers(convertToIntegerList(input));
    }

    private List<Integer> convertToIntegerList(String input) {
        return Arrays.stream(input.split(LottoConstant.LOTTO_NUMBER_INPUT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void inputValidate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionConstant.NULL_OR_EMPTY);
        }
        if (!input.contains(LottoConstant.LOTTO_NUMBER_INPUT_DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 구분자를 입력해주시기 바랍니다.");
        }
        if (input.endsWith(LottoConstant.LOTTO_NUMBER_INPUT_DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 마지막에 구분자를 입력하지 마십시오.");
        }
        boolean allNumbers = Arrays.stream(input.split(LottoConstant.LOTTO_NUMBER_INPUT_DELIMITER))
                .allMatch(str -> str.matches("\\d+"));
        if (!allNumbers) {
            throw new IllegalArgumentException(ExceptionConstant.CONTAINS_INVALID_CHARACTER);
        }
    }

    public LottoRank getLottoRank(Lotto lotto, WinningNumbers winningNumbers, int bonus) {
        int actual = getMatchingPoint(lotto, winningNumbers);
        boolean bonusNumberCheck = false;
        if (actual == 5) {
            bonusNumberCheck = contain(lotto, bonus);
        }
        return LottoRank.getRank(actual, bonusNumberCheck);
    }

    private int getMatchingPoint(Lotto lotto, WinningNumbers winningNumbers) {
        return winningNumbers.calculateMatchingCount(lotto);
    }

    private boolean contain(Lotto lotto, int bonusNumber) {
        return lotto.streamNumbers().anyMatch(n -> n == bonusNumber);
    }

}
