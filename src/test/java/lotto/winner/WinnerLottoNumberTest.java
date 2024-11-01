package lotto.winner;

import lotto.number.LottoNumber;
import org.junit.jupiter.api.Test;

import static lotto.winner.WinnerLottoNumber.createOfWinnerLottoNumber;
import static org.assertj.core.api.Assertions.assertThat;

public class WinnerLottoNumberTest {

    @Test
    void 로또_당첨_번호_포함_여부_테스트() {
        WinnerLottoNumber winnerLottoNumber = createOfWinnerLottoNumber("1,2,3,4,5,6");
        assertThat(winnerLottoNumber.contains(new LottoNumber(1))).isTrue();
    }

    @Test
    void 로또_당첨_번호_미_포함_여부_테스트() {
        WinnerLottoNumber winnerLottoNumber = createOfWinnerLottoNumber("1,2,3,4,5,6");
        assertThat(winnerLottoNumber.contains(new LottoNumber(7))).isFalse();
    }

}
