package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoStore;
import lotto.model.Prize;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PurchaseController {

    private final LottoStore lottoStore = new LottoStore();
    private List<Lotto> purchasedLottos = new ArrayList<>();

    public void purchaseLottos() {
        int amount = getUserAmount();
        int count = lottoStore.calculateLottoCount(amount);
        purchasedLottos = generateLottos(count);
    }

    public LottoResult calculateResult(List<Integer> winningNumbers, int bonusNumber) {
        Map<Prize, Integer> prizeResults = lottoStore.calculateResults(purchasedLottos, winningNumbers, bonusNumber);
        return new LottoResult(prizeResults);
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public int getUserAmount() {
        int amount = InputView.getAmount();
        validateAmount(amount);
        return amount;
    }

    private void validateAmount(int amount) {
        if (amount % LottoStore.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }
        return lottos;
    }
}
