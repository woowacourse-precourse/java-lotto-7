package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoService {
    static List<Lotto> lottoList = new ArrayList<>();

    public static List<Lotto> generateLotto(int number) {
        for (int i = 0; i < number; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public static int[] matchLotto(int[] winningNumbers, int bonusNumber, List<Lotto> lottolist, int number) {
        int[] matchResult = new int[5];

        for (Lotto lotto : lottolist) {
           
        }

        return matchResult;
    }
}
