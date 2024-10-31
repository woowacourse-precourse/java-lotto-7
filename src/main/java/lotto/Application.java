package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int budget = Integer.parseInt(Console.readLine());
        if(budget<1000){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }

        int count = budget/1000;
        System.out.println();
        System.out.println(count+"개를 구매했습니다.");
    }
}
