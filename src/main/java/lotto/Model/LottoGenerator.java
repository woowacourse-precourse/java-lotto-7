package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<List<Integer>> generateLottos(int price){
        int lottoCount = price / 1000;

        List<List<Integer>> allLottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++){
            allLottos.add(generateLottoNumbers());
        }
        return allLottos;

    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
