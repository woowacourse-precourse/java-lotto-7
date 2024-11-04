package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.Message;

import java.util.List;

public class LottoView {

    public static String inputAmount(){
        System.out.println(Message.INPUT_AMOUNT);
        String input = Console.readLine();
        isDivisibleBy1000(input);
        isPositive(input);
        return input;
    }

    private static void isDivisibleBy1000(String input) {
        if(Integer.parseInt(input) % 1000 !=0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    private static void isPositive(String input) {
        if(Integer.parseInt(input) <= 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
    }
}
