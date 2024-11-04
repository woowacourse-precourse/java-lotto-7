package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void insertLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public Result getResult(Lotto targetLotto, int targetBonus) {
        return new Result(convertLottosToPrizes(targetLotto, targetBonus)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        prize -> prize,
                        Collectors.summingInt(prize -> 1)
                )));
    }

    private Stream<Prize> convertLottosToPrizes(Lotto targetLotto, int targetBonus) {
        return lottos.stream()
                .map(lotto -> lotto.lottoToPrize(
                        lotto.countHit(targetLotto),
                        lotto.checkBonus(targetBonus)))
                .filter(Objects::nonNull);
    }

    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public int purchaseNumber() {
        return lottos.size();
    }
}
