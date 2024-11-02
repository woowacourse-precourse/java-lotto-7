package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private List<Integer> randomNumber(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    public List<List<Integer>> generateLotto(int lottoCount){
        List<List<Integer>> lottos = new ArrayList<>();
        for(int i = 0 ; i < lottoCount ; i++) {
            List<Integer> lottoNumbers = randomNumber();
            lottos.add(lottoNumbers);
        }
        return lottos;
    }
}


