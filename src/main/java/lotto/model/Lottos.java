package lotto.model;

import java.util.ArrayList;
import java.util.List;

public record Lottos(List<Lotto> lottos) {
  public Lottos(List<Lotto> lottos) {
    this.lottos = new ArrayList<>(lottos);
  }

  @Override
  public List<Lotto> lottos() {
    return lottos;
  }

  public int size() {
    return lottos.size();
  }
}
