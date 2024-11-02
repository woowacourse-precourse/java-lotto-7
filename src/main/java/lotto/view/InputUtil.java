package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {
    private static final String PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    private static final String INPUT_NUMBER_ERROR = "[ERROR] 구입 금액은 숫자만 입력할 수 있습니다.";
    private static final String INPUT_UNDER_ERROR = "[ERROR] 구입 금액은 1,000원 이상이어야 합니다.";
    private static final String INPUT_UNIT_ERROR = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    private static final int MIN_PURCHASE_NUM = 1000;

    public static int getPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_INPUT);
        String inputMoney = Console.readLine();
        checkValidPurchaseAmount(inputMoney);
        return convertToInt(inputMoney);
    }

    private static void checkValidPurchaseAmount(String input){
        validateNumeric(input);
        validateMinimumAmount(input);
        validateUnit(input);
    }

    private static void validateUnit(String input) {
        if(Integer.parseInt(input) % MIN_PURCHASE_NUM  != 0){
            throw new IllegalArgumentException(INPUT_UNIT_ERROR);
        }
    }

    private static void validateMinimumAmount(String input) {
        if(Integer.parseInt(input)< MIN_PURCHASE_NUM ){
            throw new IllegalArgumentException(INPUT_UNDER_ERROR);
        }
    }

    private static void validateNumeric(String input) {
        if(!input.matches("\\d+")){
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR);
        }
    }

    private static int convertToInt(String input){
        return Integer.parseInt(input);
    }
}
