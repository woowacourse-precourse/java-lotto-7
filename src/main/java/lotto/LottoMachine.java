package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoMachine {
    public void run() {
        System.out.println("구입금액을 입력해 주세요.");

        int cost = Integer.parseInt(Console.readLine());

        System.out.println(cost/1000 + "개를 구매했습니다.");



    }
}
