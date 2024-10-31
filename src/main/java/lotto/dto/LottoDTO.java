package lotto.dto;

import java.util.Set;

public class LottoDTO {
    private final Set<Integer> lottoNumbers;

    public LottoDTO(Set<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "Lotto Numbers: " + lottoNumbers;
    }
}
