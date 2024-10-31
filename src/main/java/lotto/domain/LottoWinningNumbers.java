package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.StringUtil;

public class LottoWinningNumbers {

    private static final String DELIMITER = ",";

    private String winningNumber;
    private String bonusNumber;

    public LottoWinningNumbers(String winningNumber, String bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> generate() {
        List<Integer> winningNumbers = new ArrayList<>();

        String[] splitNumbers = winningNumber.split(DELIMITER);
        for (String splitNumber : splitNumbers) {
            Integer number = StringUtil.parseToPositiveInt(splitNumber);
            winningNumbers.add(number);
        }

        Integer bonus = StringUtil.parseToPositiveInt(bonusNumber);
        winningNumbers.add(bonus);

        return winningNumbers;
    }
}
