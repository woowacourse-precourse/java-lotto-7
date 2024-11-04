package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private static final int lotto_Price = 1000;
    private List<Lotto> purchasedLottos = new ArrayList<>();

    public void run() {

    }
    //로또 구입 메서드 구현
    private int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요");
        int amount = Integer.parseInt(Console.readLine());
        if(amount % lotto_Price == 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        return amount;
    }
    //로또 구입 갯수 메서드 구현
    private void purchaseLottos(int amount) {
        int count = amount / lotto_Price;
        System.out.printf("%d개를 구매했습니다.\n", count);
        for (int i = 0; i < count; i++) {
            purchasedLottos.add(Lotto.generateRandomNumbers());
        }
    }
}

