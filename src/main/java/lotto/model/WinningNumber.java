package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.service.CheckingWinningService;

public class WinningNumber {
    private static String DELIMITER = ",";

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public List<Integer> getWinningNumbers(String inputWinningNumbers) {
        validateSplitting(inputWinningNumbers);
        //1~45 숫자 유효성 검사 추가
        this.winningNumbers = splitWinningNumbers(inputWinningNumbers);
        return winningNumbers;
    }

    private void validateSplitting(String inputWinningNumbers) {
        //구조 이게 최선인가?
        try {
            this.winningNumbers = splitWinningNumbers(inputWinningNumbers);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자만 입력하세요.");
        }
    }

    public List<Integer> splitWinningNumbers(String inputWinningNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();

        for (String winningNumber : inputWinningNumbers.split(DELIMITER)) {
            winningNumbers.add(Integer.valueOf(winningNumber)); //예외 확인 필요
        }
        Collections.sort(winningNumbers);

        return winningNumbers;
    }

    public int getBonusNumber(String inputBonusNumber) {
        validateBonusNumber(inputBonusNumber);
        this.bonusNumber = Integer.parseInt(inputBonusNumber);
        return bonusNumber;
    }

    private void validateBonusNumber(String inputBonusNumber) {
        //1~45 숫자, winning과 중복 검사
    }
}
