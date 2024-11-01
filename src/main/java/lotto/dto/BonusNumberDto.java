package lotto.dto;

import lotto.util.ParseUtil;

public record BonusNumberDto(
        String bonusNumber
) {
    public int parseBonusNumber() {
        return ParseUtil.parseInt(bonusNumber);
    }
}
