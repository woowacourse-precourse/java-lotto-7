package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HistoryTest {

    @Test
    void hitCount가_6이면_20억_반환(){
        History history = new History();
        history.addHistory(6,0);

        Assertions.assertThat(history.getTotalPrizeMoney()).isEqualTo(2000000000/100);
    }

}