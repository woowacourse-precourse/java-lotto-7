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
}
