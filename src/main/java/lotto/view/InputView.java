package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoService;

import java.util.List;


public class InputView {
    public static int inputBudget(){
        int budget;
        try{
            budget = Integer.parseInt(Console.readLine());
            ValidatorOfView.isValidBudget(budget);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBudget();
        }
        return budget;
    }

    public static List<Integer> inputWinningNumber(){
        List<Integer> winningNumbers ;
        try{
            String numbers = Console.readLine();
            winningNumbers = LottoService.parseWinningNumber(numbers);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
        return winningNumbers;
    }

    public static int inputBonusNumber(){
        int bonusNumber;
        try{
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
        return bonusNumber;
    }
}
