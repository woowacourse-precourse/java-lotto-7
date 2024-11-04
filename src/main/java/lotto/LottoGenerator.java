package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {

    public static List<Lotto> generateLottos(int lottoDrawCount) {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, lottoDrawCount).forEach(i -> lottos.add(new Lotto()));
        return lottos;
    }
}
