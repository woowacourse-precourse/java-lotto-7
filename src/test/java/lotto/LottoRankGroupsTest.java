package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankGroupsTest {

    @Test
    void getPrize() {
        LottoRankGroups lottoRankGroups = new LottoRankGroups(List.of(LottoRank.FIRST, LottoRank.FIRST, LottoRank.SECOND));
        assertThat(lottoRankGroups.getPrize(LottoRank.FIRST)).isEqualTo(LottoRank.FIRST.getPrice() * 2);
        assertThat(lottoRankGroups.getPrize(LottoRank.SECOND)).isEqualTo(LottoRank.SECOND.getPrice());
    }
    @Test
    void getAllPrize(){
        LottoRankGroups lottoRankGroups = new LottoRankGroups(List.of(LottoRank.FIRST, LottoRank.FIRST, LottoRank.SECOND));
        assertThat(lottoRankGroups.getAllPrize())
                .isEqualTo(LottoRank.FIRST.getPrice()  + LottoRank.FIRST.getPrice() + LottoRank.SECOND.getPrice());
    }

    @Test
    void getCount(){
        LottoRankGroups lottoRankGroups = new LottoRankGroups(List.of(LottoRank.FIRST, LottoRank.FIRST, LottoRank.SECOND));
        assertThat(lottoRankGroups.getCount(LottoRank.FIRST)).isEqualTo(2);
        assertThat(lottoRankGroups.getCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(lottoRankGroups.getCount(LottoRank.THIRD)).isEqualTo(0);
    }
}