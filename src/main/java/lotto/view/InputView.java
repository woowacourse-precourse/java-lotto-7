package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    static final String INPUT_ORDER_PRICE = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    static final int LOTTO_PRICE = 1000;

    public static String inputOrderPrice() {
        System.out.println(INPUT_ORDER_PRICE);
        return Console.readLine();
    }

    public static String inputWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

    public static int parseOrder(String inputOrderPrice){
        // Valid 추가 ( 1000원 단위 )
        return Integer.parseInt(inputOrderPrice)/LOTTO_PRICE;
    }

    public static List<Integer> parseWinningNumber(String inputWinningNumber){
        return Arrays.stream(inputWinningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public static int parseBonusNumber(String inputBonusNumber) {
        return Integer.parseInt(inputBonusNumber);
    }
}
