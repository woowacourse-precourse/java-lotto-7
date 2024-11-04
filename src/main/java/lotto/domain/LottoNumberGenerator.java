package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private Lotto generateLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(lottoNumbers);

        Lotto lotto = new Lotto(lottoNumbers);
        return lotto;
    }

    private List<Lotto> generateLottoNumbers(int amountOfLotto){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0 ; i < amountOfLotto ; i++){
            lottos.add(generateLotto());
        }
        return lottos;
    }
}
