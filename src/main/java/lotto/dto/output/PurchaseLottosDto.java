package lotto.dto.output;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class PurchaseLottosDto {
    private final String COMMA = ", ";
    private final String LOTTO_NUMBER_START = "[";
    private final String LOTTO_NUMBER_END = "]";

    private final List<String> lottos;

    public PurchaseLottosDto(List<Lotto> lottos) {
        this.lottos = lottos.stream()
                .map(this::transformDto)
                .toList();
    }

    private String transformDto(Lotto lotto) {
        String lottoNumbers = lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA));
        return LOTTO_NUMBER_START + lottoNumbers + LOTTO_NUMBER_END;
    }

    public List<String> getLottos() {
        return lottos.stream().toList();
    }
}
