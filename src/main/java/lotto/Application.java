package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // 1. 로또 구입 금액 입력
        int money;
        System.out.println("구입금액을 입력해 주세요.");
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 정수로만 입력할 수 있습니다. 다시 작성해 주세요.");
        }

        if (money % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 로또 하나를 구입하는 데에 필요한 금액은 1,000원입니다. 1,000원 단위로 다시 작성해 주세요.");
        }

        // 2. 로또 번호 추첨
        int count = money / 1000;

        List<List> purchaseLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> purchaseNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchaseLottos.add(purchaseNumbers);
        }

        // 3. 구매 로또 번호 수량 및 번호 출력
        String checkCount = "%d개를 구매했습니다.".formatted(count);
        System.out.println(checkCount);

        for (List<Integer> purchaseNumbers : purchaseLottos) {
            Collections.sort(purchaseNumbers);
            System.out.println(purchaseNumbers);
        }
    }
}
