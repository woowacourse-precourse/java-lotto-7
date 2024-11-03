package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Validator;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int priceInput(){
        while(true) {
            try {
                System.out.println("구입 금액을 입력해주세요.");
                String priceinput = Console.readLine();
                int price = Integer.parseInt(priceinput);
                Validator.validatePrice(price);
                return price;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> winInput(){
        while(true){
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winInput = Console.readLine();
                List<Integer> winNumbers = parseWinNumbers(winInput);
                Validator.validateWinNumbers(winNumbers);
                return winNumbers;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseWinNumbers(String winInput){
        String[] winNumbersArr  = winInput.split(",");
        List<Integer> parsedWinNumbers = new ArrayList<>();

        for(String winNumber : winNumbersArr){
            parsedWinNumbers.add(Integer.parseInt(winNumber.trim()));
        }
        return parsedWinNumbers;
    }

    public static int bonusInput(List<Integer> winNumbers){
        while(true) {
            try{
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusInput = Console.readLine();
                int bonus = Integer.parseInt(bonusInput.trim());
                Validator.validateBonusNumber(bonus, winNumbers);
                return bonus;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

