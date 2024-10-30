package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseView {
    public PurchaseView() {}

    public int input() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        return Integer.parseInt(money);
    }

    public void output(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }
}
