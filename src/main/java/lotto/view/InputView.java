package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static final String INPUT_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String COMMA = ",";

    public static void  printRequestPurchaseAmountInput(){
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public static void printRequestLotto(){
        System.out.println(INPUT_WINNING_NUMBERS);
    }

    public static void printRequestBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static String getUserInput() {
        return Console.readLine();
    }

    public static String[] getUserInputSplitByComma(){
        return Console.readLine().split(COMMA);
    }

    public static List<Integer> makeArrayToList(String[] splitInput) {
        List<Integer> numbers = new ArrayList<>();
        for(String i: splitInput){
            numbers.add(Integer.parseInt(i));
        }
        return numbers;
    }

}
