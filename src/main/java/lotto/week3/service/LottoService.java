package lotto.week3.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.week3.dto.PurchaseRequestDto;

public class LottoService {

    public static List<List<Integer>> lottoNumberPrinting(PurchaseRequestDto purchase){
        List<List<Integer>> answer = new ArrayList<>();
            for(int i = 0; i < purchase.getLottoCount(); i++){
                List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                answer.add(integers);
            }
        return answer;
    }
}
