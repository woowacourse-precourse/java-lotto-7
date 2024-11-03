package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.utils.NumberConstants;

public class LottoDrawer {
    public List<List<Integer>> generateRandomValues(int numberOfLotto){
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for(int i = 0; i < numberOfLotto; i++){
            lottoNumbers.add(drawRandomNumbers());
        }

        return lottoNumbers;
    }
    private List<Integer> drawRandomNumbers(){
        return Randoms.
                pickUniqueNumbersInRange(NumberConstants.START_NUMBER.getNumber(),
                NumberConstants.END_NUMBER.getNumber(),
                NumberConstants.LOTTO_COUNT.getNumber());
    }
}
