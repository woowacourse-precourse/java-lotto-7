package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Validator;

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
                System.out.println("당첨 번호를 입력해주세요.");
                String winInput = Console.readLine();

            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }



}

