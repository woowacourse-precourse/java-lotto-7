package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.View.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void run() {
        try {
            int purchaseAmount = InputView.inputPurchaseAmount();
            int numberOfLottos = purchaseAmount / 1000;

            List<Integer> winningNumbers = InputView.inputWinningNumbers();
            int bonusNumber = InputView.inputBonusNumber();

            List<Lotto> purchasedLottos = purchaseLottos(numberOfLottos);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Lotto> purchaseLottos(int numberOfLottos) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLottos.add(new Lotto(lottoNumbers));
        }
        return purchasedLottos;
    }
}
