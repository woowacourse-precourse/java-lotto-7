package lotto.view;


import camp.nextstep.edu.missionutils.Console;


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

}
