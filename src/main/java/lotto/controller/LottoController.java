package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.Prize;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public Lottos generateLottos(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(generateLotto());
        }
        return new Lottos(lottoList);
    }

    public int getLottoPurchaseCount(int cost) {
        return cost / LOTTO_PRICE;
    }

    public List<Integer> splitWinningNumbers(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int checkCorrectCount(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public void checkResult(Lottos lottos, LottoResult lottoResult) {
        int resultPrize = 0;
        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = checkCorrectCount(lotto, lottoResult.getWinningNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(lottoResult.getBonusNumber());
            Prize prize = Prize.valueOf(matchCount, bonusMatch);
            resultPrize += prize.getResultPrize();
        }
        lottoResult.setTotalPrize(resultPrize);
    }

    public double checkProfitRate(LottoResult lottoResult) {
        int totalSpent = lottoResult.getLottoCost();
        int totalPrize = lottoResult.getTotalPrize();
        return (totalPrize - totalSpent) / (double) totalSpent * 100;
    }
}
