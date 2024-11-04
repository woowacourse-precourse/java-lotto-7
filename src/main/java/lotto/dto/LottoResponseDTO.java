package lotto.dto;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResults;

public class LottoResponseDTO {
    private List<Lotto> userLottos;
    private LottoResults results;

    public LottoResponseDTO(List<Lotto> userLottos, LottoResults results) {
        this.userLottos = userLottos;
        this.results = results;
    }

    // Getters
    public List<Lotto> getUserLottos() {
        return userLottos;
    }

    public LottoResults getResults() {
        return results;
    }
}