package lotto.model;

import java.util.List;
import lotto.utilities.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
  public static List<Lotto> createLottos(int quantityOfLottos) {
    return IntStream.range(0, quantityOfLottos)
        .mapToObj(i -> new Lotto(Random.lottoGenerator()))
        .collect(Collectors.toList());
  }
}
