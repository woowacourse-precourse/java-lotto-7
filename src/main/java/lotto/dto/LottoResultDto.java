package lotto.dto;

import java.util.Map;
import lotto.domain.constant.LottoRank;

public class LottoResultDto {
    private final String description;

    private LottoResultDto(String description) {
        this.description = description;
    }

    public static LottoResultDto from(Map.Entry<LottoRank, Integer> entry) {
        LottoRank rank = entry.getKey();
        int count = entry.getValue();
        String description = rank.getDescription() + " - " + count + "개";
        return new LottoResultDto(description);
    }

    public String getDescription() {
        return description;
    }
}
