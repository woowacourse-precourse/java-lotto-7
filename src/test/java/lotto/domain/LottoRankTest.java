package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoRankTest {
    @Test
    void findLottoRank() {
        assertThat(LottoRank.findLottoRank(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.findLottoRank(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.findLottoRank(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.findLottoRank(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.findLottoRank(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.findLottoRank(2, false)).isEqualTo(LottoRank.NONE);
    }

    @Test
    void getWinningCount() {
        assertThat(LottoRank.FIRST.getWinningCount()).isEqualTo(6);
        assertThat(LottoRank.SECOND.getWinningCount()).isEqualTo(5);
        assertThat(LottoRank.THIRD.getWinningCount()).isEqualTo(5);
        assertThat(LottoRank.FOURTH.getWinningCount()).isEqualTo(4);
        assertThat(LottoRank.FIFTH.getWinningCount()).isEqualTo(3);
        assertThat(LottoRank.NONE.getWinningCount()).isEqualTo(0);
    }

    @Test
    void isBonusNumberMatched() {
        assertThat(LottoRank.FIRST.isBonusNumberMatched()).isFalse();
        assertThat(LottoRank.SECOND.isBonusNumberMatched()).isTrue();
        assertThat(LottoRank.THIRD.isBonusNumberMatched()).isFalse();
        assertThat(LottoRank.FOURTH.isBonusNumberMatched()).isFalse();
        assertThat(LottoRank.FIFTH.isBonusNumberMatched()).isFalse();
        assertThat(LottoRank.NONE.isBonusNumberMatched()).isFalse();
    }

    @Test
    void getPrice() {
        assertThat(LottoRank.FIRST.getPrice()).isEqualTo(2_000_000_000);
        assertThat(LottoRank.SECOND.getPrice()).isEqualTo(30_000_000);
        assertThat(LottoRank.THIRD.getPrice()).isEqualTo(1_500_000);
        assertThat(LottoRank.FOURTH.getPrice()).isEqualTo(50_000);
        assertThat(LottoRank.FIFTH.getPrice()).isEqualTo(5_000);
        assertThat(LottoRank.NONE.getPrice()).isEqualTo(0);
    }

    @Test
    void getPrintMessages() {
        assertThat(LottoRank.FIRST.getPrintMessages()).isEqualTo("6개 일치 (2,000,000,000원) - %d개");
        assertThat(LottoRank.SECOND.getPrintMessages()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개");
        assertThat(LottoRank.THIRD.getPrintMessages()).isEqualTo("5개 일치 (1,500,000원) - %d개");
        assertThat(LottoRank.FOURTH.getPrintMessages()).isEqualTo("4개 일치 (50,000원) - %d개");
        assertThat(LottoRank.FIFTH.getPrintMessages()).isEqualTo("3개 일치 (5,000원) - %d개");
        assertThat(LottoRank.NONE.getPrintMessages()).isEqualTo("");
    }
}