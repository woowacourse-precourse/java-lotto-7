package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("6개 번호가 일치하면 1등")
    @Test
    void 여섯_개_번호_일치하면_1등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult result = new LottoResult(lotto, List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(result.getRank()).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개 번호 일치, 보너스 번호 일치하면 2등")
    @Test
    void 다섯_개_번호_일치하고_보너스_번호_일치하면_2등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoResult result = new LottoResult(lotto, List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(result.getRank()).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개 번호만 일치하면 3등")
    @Test
    void 다섯_개_번호_만_일치하면_3등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        LottoResult result = new LottoResult(lotto, List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(result.getRank()).isEqualTo(Rank.THIRD);
    }

    @DisplayName("보너스 번호가 있더라도 일치하는 번호가 5개가 아니면 보너스 번호를 확인하지 않음")
    @Test
    void 다섯_개가_아닌_경우_보너스_번호를_확인하지_않음() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        LottoResult result = new LottoResult(lotto, List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(result.getRank()).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3개 번호가 일치하면 5등")
    @Test
    void 세_개_번호_일치하면_5등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        LottoResult result = new LottoResult(lotto, List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(result.getRank()).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2개 이하 일치하면 미당첨")
    @Test
    void 두_개_이하_일치하면_미당첨() {
        Lotto lotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        LottoResult result = new LottoResult(lotto, List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(result.getRank()).isEqualTo(Rank.NONE);
    }
}
