package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.Displayable;

public class Lottos implements Displayable {
    private static final String LINE_BREAK = "\n";
    private final List<Lotto> lottos;

    Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public String toPrettyString() {
        return lottos.stream()
                .map(Lotto::toPrettyString)
                .collect(Collectors.joining(LINE_BREAK)) + LINE_BREAK;
    }

    public Integer getCount() {
        return lottos.size();
    }

    public Result matchNumbers(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::match)
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(
                                rank -> rank,
                                () -> new EnumMap<>(Rank.class),
                                Collectors.summingInt(r -> 1)),//Rank 기준으로 갯수 count
                        Result::new
                ));
    }
}
