package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private int purchase;
    private List<Lotto> lottos;
    private LottoChecker lottoChecker = new LottoChecker();
    public LottoManager() {
        this.lottos = new ArrayList<>();
    }

    public void run() {
        purchase = InputManager.purchaseAmount();
        purchaseLottos(purchase);
        lottoChecker.chooseWinningLotto();
        lottoChecker.chooseBonusNumber();
        lottoChecker.getResult(lottos);
    }

    private void purchaseLottos(int purchase) {
        try {
            for (int i = 0; i < purchase; i++) {
                List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                lottos.add(new Lotto(numbers));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(purchase + "개를 구매했습니다.");
        printLottos();
    }

    private void printLottos() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
