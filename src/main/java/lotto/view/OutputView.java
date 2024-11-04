package lotto.view;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.OutputController;
import java.util.Collections;

public class OutputView {
    public static List<List<Integer>> printLottoNumbers(int purchaseQuantity){
        List<List<Integer>> lottoNumbersList= OutputController.getLottoNumbers(purchaseQuantity);
        for (List<Integer> lottoNumbers : lottoNumbersList) {
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers); // 각 로또 번호 리스트 출력
        }
        return lottoNumbersList;
    }


}
