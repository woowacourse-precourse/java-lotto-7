package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.LottoStore;

import java.util.ArrayList;
import java.util.List;

public class PurchaseController {

    private final LottoStore lottoStore = new LottoStore();

    public void purchaseLottos() {
        int amount = getUserAmount();
        int count = calculateLottoCount(amount);

        List<Lotto> lottos = generateLottos(count);
        printLottos(lottos, count);
    }

    private int getUserAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());

        validateAmount(amount);
        return amount;
    }

    private void validateAmount(int amount) {
        if (amount % LottoStore.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private int calculateLottoCount(int amount) {
        return lottoStore.calculateLottoCount(amount);
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }
        return lottos;
    }

    private void printLottos(List<Lotto> lottos, int count) {
        System.out.println(count + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
