package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoUtils {

    public static List<List<Integer>> generate(int purchaseAmount) {
        int purchaseCount = purchaseAmount / 1000;
        List<List<Integer>> purchaseLottoNumbers = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
            sortedLottoNumbers.sort(Integer::compareTo);
            purchaseLottoNumbers.add(sortedLottoNumbers);
        }

        return purchaseLottoNumbers;
    }
}
