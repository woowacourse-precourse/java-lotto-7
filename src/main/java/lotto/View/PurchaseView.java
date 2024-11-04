package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.List;

public class PurchaseView {
    public PurchaseView() {}

    public String input() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneytoString = Console.readLine();
        return moneytoString;
    }

    public void output(int count, List<Lotto> lottos) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        for(int i = 0; i < count; i++) {
            Lotto lotto = lottos.get(i);
            List<Integer> numbers = lotto.getNumbers();
            System.out.println("[" + numbers.get(0) + ", " + numbers.get(1) + ", " + numbers.get(2) + ", " + numbers.get(3) + ", " + numbers.get(4) + ", " + numbers.get(5) + "]");
        }
    }
}
