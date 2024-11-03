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
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력한 금액이 유효하지 않습니다. 숫자만 입력해 주세요.");
            return inputBudget();
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

    public static int inputBonusNumber(List<Integer> winningNumbers){
        int bonusNumber;
        try{
            bonusNumber = Integer.parseInt(Console.readLine());
            ValidatorOfView.isValidBonusNumber(winningNumbers,bonusNumber);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }
        return bonusNumber;
    }
}
