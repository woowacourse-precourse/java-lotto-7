package lotto.validator;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberTypeValidator {

    public List<Integer> validateWinningNumbersType(String userInput) {
        try {
            String[] numbers = userInput.split(",");
            List<Integer> winningNumbers = new ArrayList<>();
            for (String number : numbers) {
                winningNumbers.add(Integer.parseInt(number.trim()));
            }
            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로 입력해주세요.\n");
        }
    }

    public int validateBonusNumberType(String userInput) {
        try {
            int bonusNumber = Integer.parseInt(userInput);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해주세요.\n");
        }
    }
}
