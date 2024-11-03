package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private static List<Lotto> lottos = new ArrayList<>();
    private static Lotto winNumber;

    public void purchaseLottery() {
        String price = LottoView.inputPrice();
        createLotto(purchaseNumber(price));
    }

    public void printLottoNumber() {
        LottoView.printPurchaseCount(this.lottos.size());
        for(Lotto lotto : this.lottos) {
            LottoView.printLottos(lotto.getSortedLotto());
        }
    }

    public void winning() {
        String winnigNums = LottoView.inputWinningNumber();
        String bonusNumber = LottoView.inputBonusNumber();
    }

    private int purchaseNumber(String price) {
        return Integer.parseInt(price) / 1000;
    }

    private void createLotto(int count) {
        for(int i=0; i<count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            this.lottos.add(lotto);
        }
    }
}
