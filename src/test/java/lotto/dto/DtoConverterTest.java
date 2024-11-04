package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.UserLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DtoConverterTest {
    DtoConverter converter = new DtoConverter();

    private Lotto lotto1, lotto2;
    private List<Lotto> lotteries;
    private UserLotto userLotto;
    private float profitRate;

    @BeforeEach
    void setUp(){
        lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        lotteries = List.of(lotto1, lotto2);
        userLotto = new UserLotto(lotteries);
        profitRate = 50.5f;
    }

    @Test
    void Lotteries를_LotteriesResponse로_변환() {
        // when
        LotteriesResponse response = converter.toLotteriesResponse(lotteries);
        // then


        Assertions.assertThat(response.lotteriesCount()).isEqualTo(2);
        Assertions.assertThat(response.lotteries().get(0)).isEqualTo(lotto1.getNumbers());
        Assertions.assertThat(response.lotteries().get(1)).isEqualTo(lotto2.getNumbers());
    }

    @Test
    void UserLotto를_WinningResultResponse로_변환() {
        // when
        WinningResultResponse response = converter.toWinningResultResponse(userLotto, profitRate);
        // then
        Assertions.assertThat(response.firstWinningCount()).isEqualTo(0);
        Assertions.assertThat(response.profitRate()).isEqualTo(profitRate);
    }
}