package lotto.model.dto;

import java.util.stream.Collectors;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;

public record LottoNumbers(
        Lottos lottos
) {
    public String getLottoNumbers() {
        return lottos.getLottos().stream()
                .map(this::formatLottoNumbers)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String formatLottoNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .sorted()
                .toList()
                .toString();
    }
}
