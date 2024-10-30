package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseView {
    public PurchaseView() {}

    public String input() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneytoString = Console.readLine();
        return moneytoString;
    }

    public void output(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }
}
