package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public int getPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        return amount;
    }
}
