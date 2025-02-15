package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.LottoTransaction;
import lotto.model.PrizeRank;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.LottoTransactionView;

public class LottoTransactionController {
    final int LOTTO_PRICE = Lotto.getLottoPrice();

    final LottoTransaction lottoTransaction;
    final LottoTransactionView view;

    public LottoTransactionController() {
        this.lottoTransaction = new LottoTransaction();
        this.view = new LottoTransactionView();
    }

    public List<Lotto> sellAutoLotto(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        int count = amount / LOTTO_PRICE;
        PurchaseAmountValidator.validate(amount);

        while (lottos.size() < count) {
            Lotto lotto = produceLotto();
            lottos.add(lotto);
        }
        lottoTransaction.setPurchasedLottos(lottos);
        lottoTransaction.setAmount(amount);
        view.printPurchasedLottoNumbers(lottos);

        return lottos;
    }


    public List<Lotto> sellManualLotto(List<List<Integer>> lottoNumbers, int amount) {
        List<Lotto> lottos = new ArrayList<>();
        PurchaseAmountValidator.validate(amount);

        for (List<Integer> lottoNumber : lottoNumbers) {
            Lotto lotto = new Lotto(lottoNumber);
            lottos.add(lotto);
        }

        lottoTransaction.setPurchasedLottos(lottos);
        lottoTransaction.setAmount(amount);
        view.printPurchasedLottoNumbers(lottos);

        return lottos;
    }

    public Map<List<Integer>, PrizeRank> compareWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        Set<Integer> _winningNumbers = new HashSet<>(winningNumbers);
        Map<List<Integer>, PrizeRank> result = new HashMap<>();

        for (Lotto lotto : lottoTransaction.getPurchasedLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            Set<Integer> _numbers = new HashSet<>(numbers);

            _numbers.retainAll(_winningNumbers);
            PrizeRank prizeRank = PrizeRank.getPrizeRank(_numbers.size(), numbers.contains(bonusNumber));
            result.put(numbers, prizeRank);
            lottoTransaction.addRankCount(prizeRank);
        }
        return result;
    }

    public void showLottoStatistics() {

        int totalPrize = lottoTransaction.getRankCounts().entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        double rateOfReturn = (double) totalPrize / lottoTransaction.getAmount() * 100;

        view.printWinningLottoStatistics(lottoTransaction.getRankCounts());
        view.printRateOfReturn(rateOfReturn);
    }

    private Lotto produceLotto() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(numbers);
    }
}
