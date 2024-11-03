package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.GenerateRandomNumbers;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoRange.*;

public class LottoMachine {

    public Lottos publishLottos(long quantity) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int count = 1; count <= quantity; count++) {
            List<Integer> numbers = GenerateRandomNumbers.generate();
            lottoList.add(new Lotto(numbers));
        }
        return new Lottos(lottoList);
    }
}
