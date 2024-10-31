package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Validator;

public class InputView {
    public static int priceInput(){
        while(true) {
            try {
                System.out.println("구입 금액을 입력해주세요.");
                String input = Console.readLine();
                int price = Integer.parseInt(input);
                Validator.validatePrice(price);
                return price;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

