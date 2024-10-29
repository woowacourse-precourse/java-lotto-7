package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserView {

    public int inputLottoAmount() {
        System.out.println("구입금액을 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        String winningNumbersInput = Console.readLine();
        List<Integer> winningNumbersOutput = convertInputWinningNumbersToOutput(winningNumbersInput);
        return winningNumbersOutput;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public void displayCountOfLottos(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    private List<Integer> convertInputWinningNumbersToOutput(String winningNumbers) {
        String [] inputWinningNumbers = winningNumbers.split(",");
        List<Integer> winningNumbersList = new ArrayList<>();

        for (String stringWinningNumber : inputWinningNumbers) {
            winningNumbersList.add(Integer.parseInt(stringWinningNumber));
        }

        return winningNumbersList;
    }

}
