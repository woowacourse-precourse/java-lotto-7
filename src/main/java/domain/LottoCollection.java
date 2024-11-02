package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCollection {

    public static List<List<Integer>> generateLottos(int countOfLotto) {
        List<List<Integer>> lottoCollection = new ArrayList<>();

        for (int i = 0; i < countOfLotto; i++) {
            List<Integer> randomNumbers = SixRandomNumberGenerator.generateSixRandomNumber();
            Lotto lotto = new Lotto(randomNumbers);
            lottoCollection.add(lotto.getLotto());
        }
        return lottoCollection;
    }
}
