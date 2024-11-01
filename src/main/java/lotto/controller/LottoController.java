package lotto.controller;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoBuy;
import lotto.view.LottoView;


public class LottoController {
    public void run() {
        try {
            BigInteger amount = LottoView.inputPurchaseAmount();
            LottoBuy purchase = new LottoBuy(amount);
            LottoView.printPurchaseResult(purchase.getNumberOfLottos());


            List<Lotto> lottos = generateLottos(purchase.getNumberOfLottos().intValue());
            lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));


            List<Integer> winningNumbers = LottoView.inputWinningNumbers();
            int bonusNumber = LottoView.inputBonusNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }


    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.generate());
        }
        return lottos;
    }
}
