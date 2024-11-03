package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public List<Lotto> generateLottos(int count){
        List<Lotto> lottoNumbers= new ArrayList<>();
        for(int i = 0; i < count; i++){
            lottoNumbers.add(generateSingleLotto());
        }
        return lottoNumbers;
    }

    private Lotto generateSingleLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}