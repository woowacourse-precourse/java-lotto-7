package lotto.dto;

import java.util.stream.Collectors;
import lotto.model.lotto.Lottos;

public record LottoNumbers(
        Lottos lottos
) {
    public String getLottoNumbers() {
        return lottos.getLottos().stream()
                .map(lotto -> lotto.getNumbers().toString())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
