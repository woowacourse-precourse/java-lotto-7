package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.StringUtil;

public class LottoWinningNumbers {

    private static final String DELIMITER = ",";

    private final List<Integer> winningNumbers;
    private final String mainNumbers;
    private final int bonusNumber;

    public LottoWinningNumbers(String secondLine, String thirdLine) {
        // 검증 메서드 필요 : DELIMITER 사용 했는지
        this.mainNumbers = secondLine;
        // 검증 메서드 필요 : secondLine != thirdLine
        Integer bonus = StringUtil.parseToPositiveInt(thirdLine);
        this.bonusNumber = bonus;
        this.winningNumbers = new ArrayList<>();
    }

    public void generate() {
        String[] splitNumbers = mainNumbers.split(DELIMITER);
        // 검증 메서드 필요 : splitNumbers의 길이가 6인지
        for (String splitNumber : splitNumbers) {
            Integer number = StringUtil.parseToPositiveInt(splitNumber);
            winningNumbers.add(number);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
