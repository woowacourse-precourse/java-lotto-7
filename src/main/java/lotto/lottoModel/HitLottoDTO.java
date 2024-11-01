package lotto.lottoModel;

import java.util.List;

public class HitLottoDTO {
    private List<Integer> allHitNumbers;

    public HitLottoDTO(List<Integer> allHitNumbers) {
        this.allHitNumbers = allHitNumbers;
    }

    public List<Integer> getAllHitNumbers() {
        return allHitNumbers;
    }

}
