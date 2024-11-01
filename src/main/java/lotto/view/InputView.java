package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static final String INPUT_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String requestPurchaseAmountInput(){
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static List<Integer> requestLotto(){
        System.out.println(INPUT_WINNING_NUMBERS);
        List<Integer> numbers = new ArrayList<>();
        String [] splitInput =  Console.readLine().split(",");
        for(String i: splitInput){
            numbers.add(Integer.parseInt(i));
        }
        return numbers;
    }

    public static String requestBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

}
