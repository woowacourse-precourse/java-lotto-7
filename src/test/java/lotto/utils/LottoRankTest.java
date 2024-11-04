package lotto.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lotto.model.LottoRank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class LottoRankTest {
    @ParameterizedTest
    @EnumSource(LottoRank.class)
    void 등수별_상금과_설명_확인(LottoRank rank) {
        assertNotNull(rank.getDescription());
        assertTrue(rank.getPrize() >= 0);
    }
}
