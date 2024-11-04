package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String ERROR_NULL_EXCEPTION = "[ERROR] null값 입력입니다";
    private static final String ASK_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputLottoPurchase(){
        System.out.println(ASK_PURCHASE_MONEY);
        return inputString();
    }
    public static String inputLottoNumber(){
        System.out.println(ASK_LOTTO_NUMBER);
        return inputString();
    }
    public static String inputBunusNumber(){
        System.out.println(ASK_BONUS_NUMBER);
        return inputString();
    }


    private static String inputString(){
        String input = Console.readLine();
        vaildateNull(input);
        return input;
    }
    private static void vaildateNull(String input){
        if(input == null || input.isEmpty())
            throw new IllegalArgumentException(ERROR_NULL_EXCEPTION);
    }
}
