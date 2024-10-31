package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.LottoConstant;
import lotto.constant.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;

public class WinningNumbersService {

    public WinningNumbers createWinningNumbers(String input) {
        return new WinningNumbers(convertToIntegerList(input));
    }
    private List<Integer> convertToIntegerList(String input) {
        return Arrays.stream(input.split(LottoConstant.LOTTO_NUMBER_INPUT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
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
