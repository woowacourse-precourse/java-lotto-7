package lotto.dto;

import java.util.List;
import lotto.model.Lottos;

public class PurchaseResultDTO {
    private final List<LottoResponseDTO> results;
    private final int count;

    public PurchaseResultDTO(Lottos lottos) {
        this.results = lottos.getLottos().stream()
                .map(LottoResponseDTO::new)
                .toList();
        this.count = results.size();
    }

    public List<LottoResponseDTO> getResults() {
        return results;
    }

    public int getCount() {
        return count;
    }
}
