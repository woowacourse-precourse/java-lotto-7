package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constants;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.*;

public class LottoGenerator {

    public List<Lotto> generateLottos(int lottoCount){
        List<Lotto> lottos=new ArrayList<>();

        while(lottos.size()<lottoCount){
            List<Integer> lottoNumbers = generateLotto();
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

    private List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, PICK_NUMBER);
    }
}
