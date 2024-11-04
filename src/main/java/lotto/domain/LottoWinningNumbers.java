package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.util.StringUtil;

public class LottoWinningNumbers {

    private static final String DELIMITER = ",";

    private final List<Integer> winningNumbers;
    private String[] mainNumbers;
    private int bonusNumber;

    public LottoWinningNumbers() {
        this.winningNumbers = new ArrayList<>();
    }

    public void generate() {
        for (String splitNumber : mainNumbers) {
            Integer number = StringUtil.parseToPositiveInt(splitNumber);
            winningNumbers.add(number);
        }
    }

    public void setMainNumbers(String secondLine) {
        StringUtil.checkIfNull(secondLine);

        validateDelimiter(secondLine);

        String[] splitNumbers = secondLine.split(DELIMITER);
        validateDuplicateInput(splitNumbers);

        checkIfSixNumbers(splitNumbers);

        this.mainNumbers = splitNumbers;
    }

    public void setBonusNumber(String thirdLine) {
        StringUtil.checkIfNull(thirdLine);

        checkIfBonusNumberDuplicated(thirdLine);
        this.bonusNumber = StringUtil.parseToPositiveInt(thirdLine);
    }

    private void validateDelimiter(String input){
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 쉼표를 구분자로 사용해 주세요.");
        }
    }

    private void validateDuplicateInput(String[] firstInput){
        long count = Arrays.stream(firstInput)
                .filter(o -> Collections.frequency(Arrays.asList(firstInput), o) > 1)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복 될 수 없습니다.");
        }
    }

    private void checkIfBonusNumberDuplicated(String thirdLine) {
        for (String mainNumber : mainNumbers) {
            if(mainNumber.equals(thirdLine)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호로 사용된 번호와 같을 수 없습니다.");
            }
        }
    }

    private void checkIfSixNumbers(String[] splitNumbers){
        if (splitNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자를 입력해야 합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
