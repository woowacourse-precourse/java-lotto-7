package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public record LottoDto(int count, List<String> lottos) {
    private static final String DELIMITER = ", ";

    public LottoDto(List<Lotto> lottos) {
        this(lottos.size(), lottos.stream()
                .map(LottoDto::joinLottoNumbers)
                .collect(Collectors.toList()));
    }

    private static String joinLottoNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
    }

    @Override
    public List<String> lottos() {
        return List.copyOf(lottos);
    }
}
