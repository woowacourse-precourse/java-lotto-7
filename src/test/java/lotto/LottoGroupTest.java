package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGroupTest {

    @Test
    void 로또그룹_생성() {
        assertThat(LottoGroup.create(5)).isInstanceOf(LottoGroup.class);
    }
}