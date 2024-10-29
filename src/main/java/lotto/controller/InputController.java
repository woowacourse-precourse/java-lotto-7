package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class InputController {

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        //1000원 단위 검증
        return purchaseAmount / 1000;
    }

    public ArrayList<Integer> getWinningNumbers(int lottoAmount) {
        System.out.println("당첨 번호를 입력해 주세요.");

        String[] winningNumberInput = Console.readLine().split(",");

        ArrayList<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumber : winningNumberInput) {
            winningNumbers.add(Integer.parseInt(winningNumber));
        }

        return winningNumbers;
    }

    public int getBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
