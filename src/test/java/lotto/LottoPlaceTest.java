package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoPlaceTest {
    @Test
    public void 당첨인_등수만_반환() throws Exception{
        List<LottoPlace> winningPlaces = LottoPlace.getWinningPlaces();
        assertThat(winningPlaces.size()).isEqualTo(5);
    }
}
