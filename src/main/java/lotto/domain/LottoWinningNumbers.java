package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.StringUtil;

public class LottoWinningNumbers {

    private static final String DELIMITER = ",";

    private final List<Integer> winningNumbers;
    private final String mainNumbers;
    private final String bonusNumber;

    public LottoWinningNumbers(String secondLine, String thridLine) {
        this.mainNumbers = secondLine;
        this.bonusNumber = thridLine;
        this.winningNumbers = new ArrayList<>();
    }

    public void generate() {
        String[] splitNumbers = mainNumbers.split(DELIMITER);
        for (String splitNumber : splitNumbers) {
            Integer number = StringUtil.parseToPositiveInt(splitNumber);
            winningNumbers.add(number);
        }

        Integer bonus = StringUtil.parseToPositiveInt(bonusNumber);
        winningNumbers.add(bonus);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
