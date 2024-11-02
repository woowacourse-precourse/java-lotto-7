package lotto;


import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;


public class LottoMachine {
    private static int totalSpent;

    public static List<Lotto> makeLotto() {
        totalSpent = InputView.getInputMoney();
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

    public static WinningLotto makeWinningLotto() {
        List<Integer> winLottoNumbers = InputView.getInputWinLottoNumbers();
        int bonus = InputView.getInputBonusNumber(winLottoNumbers);

        return new WinningLotto(winLottoNumbers, bonus);
    }


    public static Map<Lotto,Prize> compareWin2Lotto(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Lotto,Prize> lottoPrizeMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            int machCount = winningLotto.getMatchCount(lotto);
            boolean bonusMatch = winningLotto.isBonusMatch(lotto);
            Prize prize = selectPrize(machCount, bonusMatch);
            lottoPrizeMap.put(lotto, prize);
        }
        return lottoPrizeMap;
    }

    private static Prize selectPrize(int matchCount, boolean bonusMatch) {
        for(Prize prize : Prize.values()) {
            if(prize.getNormalNumber() == matchCount && prize.getBonusNumber() == bonusMatch) {
                return prize;
            }
        }
        return null;
    }

    public static Map<Prize, Integer> calculatePrizeCounts(Map<Lotto, Prize> lottoPrizeMap) {
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

    public static double calculateTotalReturnRate(Map<Prize, Integer> prizeCountMap) {
        int totalPrize = 0;
        for (Map.Entry<Prize, Integer> entry : prizeCountMap.entrySet()) {
            Prize prize = entry.getKey();
            int count = entry.getValue();
            totalPrize += prize.getMoney() * count;
        }

        return ((double) totalPrize / totalSpent) * 100;
    }

    public static void run() {
        try {
            List<Lotto> lottos = makeLotto();
            WinningLotto winningLotto = makeWinningLotto();
            Map<Lotto, Prize> lottoPrizeMap = compareWin2Lotto(lottos, winningLotto);
            Map<Prize, Integer> prizeCountMap = calculatePrizeCounts(lottoPrizeMap);
            OutputView.printResult(prizeCountMap,calculateTotalReturnRate(prizeCountMap));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
