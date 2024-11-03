package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> generateUniqueNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    public List<List<Integer>> generateLottoNumbers(int lottoCount){
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i=0; i<lottoCount; i++){
            lottos.add(generateUniqueNumbers());
        }
        return  lottos;
    }
}
