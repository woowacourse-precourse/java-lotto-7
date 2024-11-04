package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = LottoNumberGenerator.generateLottoNumbers();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
