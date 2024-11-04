package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String REQUEST_LOTTO_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LOTTO_NUMBERS_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    private String input(String message){
        System.out.println(message);
        return Console.readLine().strip();
    }

    private Integer parseInteger(String message){
        return Integer.parseInt(message);
    }


    public String inputLottoAmount(){
        return input(REQUEST_LOTTO_AMOUNT_INPUT);
    }

    public String inputLottoNumbers() {
        printLine();
       return input(REQUEST_LOTTO_NUMBERS_INPUT);
    }

    public Integer inputLottoBonusNumber(){
        printLine();
        return parseInteger(input(REQUEST_LOTTO_BONUS_NUMBER));
    }

    private void printLine(){
        System.out.println();
    }

}
