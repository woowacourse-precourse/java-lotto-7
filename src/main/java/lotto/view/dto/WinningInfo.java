package lotto.view.dto;

import java.util.Map;
import lotto.domain.WinResult;

public record WinningInfo(
        Map<String, Integer> matchCount
) {

    public int getValue(String key) {
        return matchCount.get(key);
    }

    public static WinningInfo from(WinResult winResult) {
        return new WinningInfo(winResult.getWinResult());
    }
}
