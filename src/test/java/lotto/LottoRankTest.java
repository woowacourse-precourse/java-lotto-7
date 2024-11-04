package lotto;
import lotto.model.LottoRank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoRankTest {

    @Test
    void 로또번호6개_모두_맞춘_경우_1등(){
        assertThat(LottoRank.FIRST).isEqualTo(LottoRank.getLottoRank(6,false));
    }

    @Test
    void 로또번호5개_보너스번호까지_맞춘_경우_2등(){
        assertThat(LottoRank.SECOND).isEqualTo(LottoRank.getLottoRank(5,true));
    }

    @Test
    void 로또번호_5개_맞춘_경우_3등(){
        assertThat(LottoRank.THIRD).isEqualTo(LottoRank.getLottoRank(5,false));
    }

    @Test
    void 로또번호_4개_맞춘_경우_4등(){
        assertThat(LottoRank.FOURTH).isEqualTo(LottoRank.getLottoRank(4,false));
    }

    @Test
    void 로또번호_3개_맞춘_경우_5등(){
        assertThat(LottoRank.FIFTH).isEqualTo(LottoRank.getLottoRank(3,false));
    }

    @Test
    void 로또번호_2개이하는_낙첨(){
        assertThat(LottoRank.MISS).isEqualTo(LottoRank.getLottoRank(2,false));
    }

}
