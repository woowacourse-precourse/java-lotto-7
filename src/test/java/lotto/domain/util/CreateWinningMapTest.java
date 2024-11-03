package lotto.domain.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import lotto.domain.Winning;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateWinningMapTest {

    @Test
    @DisplayName("당첨 내역을 Map 자료구조로 만드는지 확인한다.")
    void createWinningDetailTest() {
        Winning[] winnings = Winning.values();

        Map<String, Integer> winningDetail = CreateWinningMap.create();

        assertThat(winningDetail.size()).isEqualTo(winnings.length);
    }
}