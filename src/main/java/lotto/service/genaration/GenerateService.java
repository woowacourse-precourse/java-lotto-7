package lotto.service.genaration;

import camp.nextstep.edu.missionutils.Randoms;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.util.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class GenerateService {
    int numberOfLotto;
    public GenerateService(int numberOfLotto) {
        this.numberOfLotto = numberOfLotto;
    }
    public Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < 6) {
            int randomInt = Randoms.pickNumberInRange(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER);
            if (numbers.contains(randomInt)) {
                continue;
            }
            numbers.add(randomInt);
        }
        return new Lotto(numbers);
    }
    public Lottos generateLotos()  {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }
}
