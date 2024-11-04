package lotto.controller;

import lotto.model.Lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class InputController {
    public static int getPurchaseAmount(){
        String input = InputView.purchaseAmount();
        int price = Lotto.parseInt(input);
        return price;
    }

    public static List<Integer> getWinningNumber(){
        String inputNumbers = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        for (String num : inputNumbers.split(",")) {
            winningNumbers.add(Integer.parseInt(num.trim()));
        }
        Lotto.validate(winningNumbers);
        Lotto.validateDuplicationOfWinningNumbers(winningNumbers);
        Lotto.validateRange(winningNumbers);
        return winningNumbers;
    }


    public static int getBonusNumber(){
        return Integer.parseInt(Console.readLine());
    }

    public static void compareDuplicationBetweenWinningAndBonus(List<Integer> numbers, int bonusNumber){
        Lotto.validateDuplicationBetweenWinningAndBonus(numbers, bonusNumber);
    }
}
