package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbersPrint {
    public List<List<Integer>> printLottoNumbers(int price) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        System.out.println("\n" + price/1000 + "개를 구매했습니다.");

        for (int i = 0; i < price/1000; i++) {
            List<Integer> tempNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(tempNumbers);
            lottoNumbers.add(tempNumbers);
        }

        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }

        return lottoNumbers;
    }
}
