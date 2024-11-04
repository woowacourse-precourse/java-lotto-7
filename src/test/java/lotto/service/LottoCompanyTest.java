package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Match;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class LottoCompanyTest {

    LottoCompany lottoCompany = new LottoCompany();
    private final InputStream originalSystemIn = System.in;

    @AfterEach
    void setUp() {
        System.setIn(originalSystemIn);
    }

    @Test
    void 당첨_번호_설정_테스트() {
        String numbers = "1,2,4,3,5,6";
        System.setIn(new ByteArrayInputStream(numbers.getBytes()));
        Lotto expectWinningNumber = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        Lotto winningNumber = lottoCompany.setWinningNumber();

        assertThat(winningNumber).isEqualTo(expectWinningNumber);
    }

    @Test
    void 당첨_내역_테스트() {
        List<Lotto> lotteries = new ArrayList<>(
                Arrays.asList(
                        new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))),
                        new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8))),
                        new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 9))),
                        new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 8, 9, 10)))
                )
        );

        Lotto winningNumber = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Integer bonusNumber = 7;

        LottoCompany lottoCompany1 = new LottoCompany(winningNumber, bonusNumber);

        List<Match> matches = lottoCompany1.getWinningStatics(lotteries);
    }
}