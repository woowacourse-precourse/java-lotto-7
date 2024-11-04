package lotto.domain;

import static lotto.view.ViewConstants.NEW_LINE;

import java.util.List;
import java.util.stream.Collectors;

public record LottoTicket(List<Lotto> lottos) {
    @Override
    public String toString() {
        return lottos.stream().map(Lotto::toString).collect(Collectors.joining(NEW_LINE));
    }
}
