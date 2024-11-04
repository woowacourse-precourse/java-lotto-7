package lotto.controller;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class OutputController {
    public static List<List<Integer>> getLottoNumbers(int purchaseQuantity){
        List<List<Integer>> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbersList.add(lottoNumbers);
        }
        return lottoNumbersList;
    }
}
