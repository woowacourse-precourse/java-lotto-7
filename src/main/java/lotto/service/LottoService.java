package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < 6) {
            int number = Randoms.pickNumberInRange(1, 45);
            if(!numbers.contains(number)){
                numbers.add(number);
            }
        }
        return numbers;
    }
}
