package lotto.week3.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {


    public static int purchaseAmountInput(){
        System.out.println("로또 구입 금액 1000원 단위로 입력 해주세요");
        return Integer.parseInt(Console.readLine().trim());
    }



}
