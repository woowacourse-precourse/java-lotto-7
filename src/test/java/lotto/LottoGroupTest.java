package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGroupTest {

    @Test
    void 로또그룹_생성() {
        assertThat(LottoGroup.create(5)).isInstanceOf(LottoGroup.class);
    }

    @Test
    void 로또그룹_로또_번호() {
        LottoGroup lottoGroup = new LottoGroup(List.of(
                Lotto.of("1,2,3,4,5,6"),
                Lotto.of("7,8,9,10,11,12"),
                Lotto.of("13,14,15,16,17,18"),
                Lotto.of("19,20,21,22,23,24")));

        assertThat(lottoGroup.getLottoNumbers()).contains(
                "[1, 2, 3, 4, 5, 6]",
                "[7, 8, 9, 10, 11, 12]",
                "[13, 14, 15, 16, 17, 18]",
                "[19, 20, 21, 22, 23, 24]"
        );
    }
}