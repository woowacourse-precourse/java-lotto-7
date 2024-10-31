package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserView {

    public int inputLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 숫자이어야 합니다.");
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine();
        List<Integer> winningNumbersOutput = convertInputWinningNumbersToOutput(winningNumbersInput);
        return winningNumbersOutput;
    }

    public int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        validateBonusNumber(bonus);
        return bonus;
    }

    public void displayCountOfLottos(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void displayLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    private List<Integer> convertInputWinningNumbersToOutput(String winningNumbers) {
        String[] inputWinningNumbers = winningNumbers.split(",");

        List<Integer> winningNumbersList = new ArrayList<>();

        for (String inputWinningNumber : inputWinningNumbers) {
            winningNumbersList.add(Integer.parseInt(inputWinningNumber));
        }

        return winningNumbersList;
    }

    private void validateBonusNumber(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45까지의 숫자만 허용됩니다.");
        }
    }
}
