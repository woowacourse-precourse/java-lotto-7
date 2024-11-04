package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomNumber;
import static lotto.util.HandleException.hasDuplicate;

public class LottoMachine {
    public static List<List<Integer>> generateLotto(int purchase) {
        List<List<Integer>> lottoLists = new ArrayList<>();
        int count = purchase / 1000;

        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = RandomNumber.getRandomNumber();
            if (hasDuplicate(lottoNumbers)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복되는 숫자가 포함되어 있습니다: " + lottoNumbers);
            }
            lottoLists.add(lottoNumbers);
        }

        return lottoLists;
    }
}
