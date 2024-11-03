package utils;

import java.util.List;
import model.Lotto;

public class LottoFactory {
    public static List<Lotto> generateLotto(Integer count) {
        Lotto[] result = new Lotto[count];
        for (int i = 0; i < count; i++) {
            result[i] = new Lotto(LottoNumbersGenerator.generate());
        }
        return List.of(result);
    }
}
