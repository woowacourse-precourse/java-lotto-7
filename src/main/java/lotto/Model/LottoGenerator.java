package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generateLottos(int price){
        int lottoCount = price / 1000;

        List<Lotto> allLottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++){
            List<Integer> lottoNumbers = generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            allLottos.add(lotto);
        }
        return allLottos;
    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
