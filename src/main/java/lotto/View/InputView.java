package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int priceInput(){
        System.out.println("구입 금액을 입력해주세요.");
        String input = Console.readLine();
        int price = Integer.parseInt(input);

    }
}
