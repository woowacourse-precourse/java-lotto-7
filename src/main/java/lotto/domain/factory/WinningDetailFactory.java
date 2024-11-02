package lotto.domain.factory;

import java.util.EnumMap;
import java.util.Map;

import lotto.domain.entity.WinningDetail;
import lotto.domain.vo.WinningRank;

public class WinningDetailFactory {
    public static WinningDetail create() {
        Map<WinningRank, Integer> detail = new EnumMap<>(WinningRank.class);
        for (WinningRank rank : WinningRank.values()) {
            detail.put(rank, 0);
        }
        return new WinningDetail(detail);
    }
}