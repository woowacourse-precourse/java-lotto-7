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




}
