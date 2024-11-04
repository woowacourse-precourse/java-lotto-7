package functions;

import enums.InputRegix;
import java.util.ArrayList;
import java.util.List;

public class InputValidation {

    public int checkNumberOfTickets(String purchase) {
        if (!purchase.matches(InputRegix.PURCHASE.getRegix())) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위의 숫자여야 합니다.");
        }

        return Integer.parseInt(purchase);
    }

    public List<Integer> checkWinningNumber(String winningNumberBeforeCheck) {
        List<Integer> winningNumber = new ArrayList<>();

        for (String number : winningNumberBeforeCheck.split(",")) {
            if (!number.matches(InputRegix.LOTTO.getRegix())) {
                throw new IllegalArgumentException("[ERROR] 모든 숫자는 1~45 사이여야 합니다.");
            }

            winningNumber.add(Integer.parseInt(number));
        }

        return winningNumber;
    }

    public int checkBonusNumber(String bonusNumberBeforeCheck, List<Integer> winningNumber) {
        if (!bonusNumberBeforeCheck.matches(InputRegix.LOTTO.getRegix())) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자여야 합니다.");
        }

        int bonusNumber = Integer.parseInt(bonusNumberBeforeCheck);
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }

        return bonusNumber;
    }

}
