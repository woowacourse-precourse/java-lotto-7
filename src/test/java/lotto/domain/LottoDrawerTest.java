package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDrawerTest {
    List<List<Integer>> lottos = List.of(List.of(1,2,3,4,5,7));
    List<Integer> winningNumber = List.of(1,2,3,4,5,6);
    Map<WinningPrize, Integer> rank = Map.of(WinningPrize.SECOND, 1);
    
    @DisplayName("저장되는 값이 올바른지 확인")
    @Test
    void rankTest(){
        LottoDrawer lottoDrawer = new LottoDrawer(lottos,winningNumber,7);
        assertEquals(rank, lottoDrawer.checkWinningNumbers());
    }



}
