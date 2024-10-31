package lotto.model.lotto;

import static java.util.Objects.isNull;
import static lotto.exception.ShouldNotBeNullException.nullArgument;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(final List<Lotto> lottos) {
        validateIsNull(lottos);
        return new Lottos(lottos);
    }

    private static void validateIsNull(final List<Lotto> lottos) {
        if (isNull(lottos)) {
            throw nullArgument();
        }
        boolean hasNullObj = lottos.stream()
                .anyMatch(Objects::isNull);
        if (hasNullObj) {
            throw nullArgument();
        }
    }

    public Stream<Lotto> initiateStream() {
        return lottos.stream();
    }

    @Override
    public String toString() {
        List<String> strLottos = lottos.stream()
                .map(lotto -> formatBrackets(lotto.toString()))
                .toList();
        return String.join("\n", strLottos);
    }

    private String formatBrackets(final String source) {
        return String.format("[%s]", source);
    }
}
