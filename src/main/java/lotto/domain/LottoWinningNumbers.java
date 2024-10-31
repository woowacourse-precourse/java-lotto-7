package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.StringUtil;

public class LottoWinningNumbers {

    private static final String DELIMITER = ",";

    private List<Integer> winningNumbers;
    private String mainNumbers;
    private String bonusNumber;

    public LottoWinningNumbers(String secondLine, String thridLine) {
        this.mainNumbers = secondLine;
        this.bonusNumber = thridLine;
        this.winningNumbers = new ArrayList<>();
    }

    public List<Integer> generate() {
        String[] splitNumbers = mainNumbers.split(DELIMITER);
        for (String splitNumber : splitNumbers) {
            Integer number = StringUtil.parseToPositiveInt(splitNumber);
            winningNumbers.add(number);
        }

        Integer bonus = StringUtil.parseToPositiveInt(bonusNumber);
        winningNumbers.add(bonus);

        return winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
