package lotto;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void checkResult() {
        // given
        ArrayList<Lotto> lotteries = new ArrayList<>();
        lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 16)));
        lotteries.add(new Lotto(List.of(1, 2, 3, 4, 15, 16)));
        lotteries.add(new Lotto(List.of(1, 2, 3, 14, 15, 16)));
        lotteries.add(new Lotto(List.of(1, 2, 3, 14, 15, 16)));
        lotteries.add(new Lotto(List.of(1, 2, 3, 14, 15, 16)));
        LottoTickets lottoTickets = new LottoTickets(lotteries);

        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;
        LottoNumbers lottoNumbers = new LottoNumbers(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult(lottoTickets, lottoNumbers);

        // when
        lottoResult.checkResult();

        // then
        assertThat(lottoResult.getCountOfRank(1)).isEqualTo(1);
        assertThat(lottoResult.getCountOfRank(2)).isEqualTo(0);
        assertThat(lottoResult.getCountOfRank(3)).isEqualTo(1);
        assertThat(lottoResult.getCountOfRank(4)).isEqualTo(1);
        assertThat(lottoResult.getCountOfRank(5)).isEqualTo(3);
    }

    @Test
    void update() {
        // given
        ArrayList<Lotto> lotteries = new ArrayList<>();
        LottoTickets lottoTickets = new LottoTickets(lotteries);

        ArrayList<Integer> winningNumbers = new ArrayList<>();
        int bonusNumber = 10;
        LottoNumbers lottoNumbers = new LottoNumbers(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult(lottoTickets, lottoNumbers);

        int matchCount = 6;
        boolean hasBonusNumber = false;

        assertThat(lottoResult.getCountOfRank(1)).isEqualTo(0);

        // when
        lottoResult.update(matchCount, hasBonusNumber);

        // then
        assertThat(lottoResult.getCountOfRank(1)).isEqualTo(1);
    }

    @Test
    void calculateRank() {
        // given
        ArrayList<Lotto> lotteries = new ArrayList<>();
        LottoTickets lottoTickets = new LottoTickets(lotteries);

        ArrayList<Integer> winningNumbers = new ArrayList<>();
        int bonusNumber = 10;
        LottoNumbers lottoNumbers = new LottoNumbers(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult(lottoTickets, lottoNumbers);

        int matchCount = 6;
        boolean hasBonusNumber = false;
        // then
        assertThat(lottoResult.calculateRank(matchCount, hasBonusNumber)).isEqualTo(1);

        matchCount = 5;
        hasBonusNumber = true;
        // then
        assertThat(lottoResult.calculateRank(matchCount, hasBonusNumber)).isEqualTo(2);

        matchCount = 5;
        hasBonusNumber = false;
        // then
        assertThat(lottoResult.calculateRank(matchCount, hasBonusNumber)).isEqualTo(3);

        matchCount = 4;
        hasBonusNumber = false;
        // then
        assertThat(lottoResult.calculateRank(matchCount, hasBonusNumber)).isEqualTo(4);

        matchCount = 3;
        hasBonusNumber = false;
        // then
        assertThat(lottoResult.calculateRank(matchCount, hasBonusNumber)).isEqualTo(5);

        matchCount = 2;
        hasBonusNumber = false;
        // then
        assertThat(lottoResult.calculateRank(matchCount, hasBonusNumber)).isEqualTo(-1);
    }

    @Test
    void calculateRankTwoOrThree() {
        //given
        ArrayList<Lotto> lotteries = new ArrayList<>();
        LottoTickets lottoTickets = new LottoTickets(lotteries);

        ArrayList<Integer> winningNumbers = new ArrayList<>();
        int bonusNumber = 10;
        LottoNumbers lottoNumbers = new LottoNumbers(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult(lottoTickets, lottoNumbers);


        boolean hasBonusNumber = true;
        // then
        assertThat(lottoResult.calculateRankTwoOrThree(hasBonusNumber)).isEqualTo(2);

        hasBonusNumber = false;
        // then
        assertThat(lottoResult.calculateRankTwoOrThree(hasBonusNumber)).isEqualTo(3);
    }

    @Test
    void getEarningRate() {
        // given
        ArrayList<Lotto> lotteries = new ArrayList<>();
        lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        LottoTickets lottoTickets = new LottoTickets(lotteries);

        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(11, 12, 13, 4, 5, 6));
        int bonusNumber = 10;
        LottoNumbers lottoNumbers = new LottoNumbers(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult(lottoTickets, lottoNumbers);

        lottoResult.checkResult();

        // then
        assertThat(lottoResult.getEarningRate()).isEqualTo(500);
    }

    @Test
    void roundToOneDecimal() {
        // given
        ArrayList<Lotto> lotteries = new ArrayList<>();
        LottoTickets lottoTickets = new LottoTickets(lotteries);

        ArrayList<Integer> winningNumbers = new ArrayList<>();
        int bonusNumber = 10;
        LottoNumbers lottoNumbers = new LottoNumbers(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult(lottoTickets, lottoNumbers);

        // then
        assertThat(lottoResult.roundToOneDecimal(3.65)).isEqualTo(3.7);
    }

    @Test
    void getEarning() {
        // given
        ArrayList<Lotto> lotteries = new ArrayList<>();
        lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        LottoTickets lottoTickets = new LottoTickets(lotteries);

        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(11, 12, 13, 4, 5, 6));
        int bonusNumber = 10;
        LottoNumbers lottoNumbers = new LottoNumbers(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult(lottoTickets, lottoNumbers);

        lottoResult.checkResult();

        // then
        assertThat(lottoResult.getEarning()).isEqualTo(5000);
    }
}