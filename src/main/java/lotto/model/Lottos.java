package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.utilities.Random;

public class Lottos {
  private final List<Lotto> lottos;

  private Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public static Lottos createLottos(int quantityOfLottos) {
    List<Lotto> lottos =
        IntStream.range(0, quantityOfLottos)
            .mapToObj(i -> new Lotto(Random.lottoGenerator()))
            .collect(Collectors.toList());
    return new Lottos(lottos);
  }

  public String allLottosToString() {
    StringBuilder sb = new StringBuilder();
    for (Lotto lotto : lottos) {
      sb.append(lotto.sortedNumbersToString()).append(System.lineSeparator());
    }
    return sb.toString();
  }

  public List<Lotto> getLottos() {
    return this.lottos;
  }
}
