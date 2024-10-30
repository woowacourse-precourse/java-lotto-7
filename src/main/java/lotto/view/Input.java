package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try{
            return Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("구입 금액은 숫자로 입력해주세요.");
        }
    }
}
