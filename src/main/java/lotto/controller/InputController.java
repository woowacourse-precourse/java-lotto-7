package lotto.controller;

import lotto.model.Lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputController {
    public static int getPurchaseAmount(){
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> getWinningNumber(){
        String inputNumbers = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        for (String num : inputNumbers.split(",")) {
            winningNumbers.add(Integer.parseInt(num.trim())); // 각 요소를 Integer로 변환해 리스트에 추가
        }
        Lotto.validate(winningNumbers);
        Lotto.validateDuplicationOfWinningNumbers(winningNumbers);
        Lotto.validateRange(winningNumbers);
        return winningNumbers;
    }


    public static int getBonusNumber(){
        //int bonusNumber = Integer.parseInt(Console.readLine());
        return Integer.parseInt(Console.readLine());
    }

    public static void compareDuplicationBetweenWinningAndBonus(List<Integer> numbers, int bonusNumber){
        Lotto.validateDuplicationBetweenWinningAndBonus(numbers, bonusNumber);
    }
}
