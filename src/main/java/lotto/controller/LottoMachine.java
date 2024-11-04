package lotto.controller;


import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoMachine {

    private List<Lotto> makeLotto(int totalSpent) {
        int count = InputView.getLottoNumber(totalSpent);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> createNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            createNumber.sort(Integer::compareTo);
            lottos.add(new Lotto(createNumber));
        }
        OutputView.printPickNumber(lottos);
        return lottos;
    }

    private WinningLotto makeWinningLotto() {
        List<Integer> winLottoNumbers = InputView.getInputWinLottoNumbers();
        int bonus = InputView.getInputBonusNumber(winLottoNumbers);

        return new WinningLotto(winLottoNumbers, bonus);
    }


    private Map<Lotto, Prize> compareWin2Lotto(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Lotto,Prize> lottoPrizeMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            int machCount = winningLotto.getMatchCount(lotto);
            boolean bonusMatch = winningLotto.isBonusMatch(lotto);
            Prize prize = Prize.getPrize(machCount, bonusMatch);
            lottoPrizeMap.put(lotto, prize);
        }
        return lottoPrizeMap;
    }


    private Map<Prize, Integer> calculatePrizeCounts(Map<Lotto, Prize> lottoPrizeMap) {
        Map<Prize, Integer> prizeCountMap = new HashMap<>();
        for (Prize prize : Prize.values()) {
            prizeCountMap.put(prize, 0);
        }

        for (Prize prize : lottoPrizeMap.values()) {
            if (prize != null) {
                prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
            }
        }
        return prizeCountMap;
    }

    private double calculateTotalReturnRate(Map<Prize, Integer> prizeCountMap, int totalSpent) {
        int totalPrize = 0;
        for (Map.Entry<Prize, Integer> entry : prizeCountMap.entrySet()) {
            Prize prize = entry.getKey();
            int count = entry.getValue();
            totalPrize += prize.getMoney() * count;
        }

        return ((double) totalPrize / totalSpent) * 100;
    }

    public void run() {
        List<Lotto> lottos;
        WinningLotto winningLotto;
        int totalSpent;
        try {
            totalSpent = InputView.getInputMoney();
            lottos = makeLotto(totalSpent);
            winningLotto = makeWinningLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        Map<Lotto, Prize> lottoPrizeMap = compareWin2Lotto(lottos, winningLotto);
        Map<Prize, Integer> prizeCountMap = calculatePrizeCounts(lottoPrizeMap);
        double totalReturnRate = calculateTotalReturnRate(prizeCountMap, totalSpent);
        OutputView.printResult(prizeCountMap, totalReturnRate);
    }

}
