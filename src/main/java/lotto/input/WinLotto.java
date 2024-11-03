package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinLotto {

    public static List<Integer> inputWinLotto() {
        System.out.println("당첨 번호를 입력하세요.");
        String winnerLine = Console.readLine();
        String[] winnerNumbers = winnerLine.split(",");

        if (winnerNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        List<Integer> winNumbers = new ArrayList<>();
        for (String num : winnerNumbers) {
            int number = parseAndValidateNumber(num.trim());
            winNumbers.add(number);
        }

        return winNumbers;
    }

    public static int inputBonusLotto(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력하세요.");
        String bonusNum = Console.readLine();
        int bonusNumber = parseAndValidateNumber(bonusNum);

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(InputValidationMessage.MESSAGE_BONUS_NUMBER_CANNOT_DUPLICATE.getMessage());
        }
        return bonusNumber;
    }

    private static int parseAndValidateNumber(String numStr) {
        try {
            int number = Integer.parseInt(numStr);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(InputValidationMessage.MESSAGE_NUMBER_RANGE.getMessage());
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputValidationMessage.MESSAGE_NUMBER_FORMMAT.getMessage());
        }
    }
}
