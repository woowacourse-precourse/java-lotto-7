package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.LottoResultService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoResultTest {

    @Test
    @DisplayName("로또 번호와 당첨 번호가 6개 일치할 경우 match count는 6이 나온다.")
    public void lottoMatchSix(){
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto publicLotto = new Lotto(lottoNumbers);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);

        Integer count = winningLotto.getMatchCount(winningLotto);

        assertThat(count).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호와 보너스 번호가 일치할 경우 true가 나온다.")
    public void lottoBonusMatch(){
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto publicLotto = new Lotto(lottoNumbers);
        Integer bonusNumber = 1;

        boolean bonusMatch = publicLotto.getBonusMatch(bonusNumber);

        assertThat(bonusMatch).isEqualTo(true);
    }

    @Test
    @DisplayName("로또 번호와 보너스 번호가 불일치 할 경우 false가 나온다.")
    public void lottoBonusNotMatch(){
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto publicLotto = new Lotto(lottoNumbers);
        Integer bonusNumber = 9;

        boolean bonusMatch = publicLotto.getBonusMatch(bonusNumber);

        assertThat(bonusMatch).isEqualTo(false);
    }

    @Test
    @DisplayName("로또 번호가 6개 당첨된 경우 LottoRank FIRST가 저장된다.")
    public void lottoRankFirst(){
        //given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto publicLotto = new Lotto(lottoNumbers);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        Integer bonusNum = 7;

        Integer count = publicLotto.getMatchCount(winningLotto);
        boolean bonusMatch = publicLotto.getBonusMatch(bonusNum);
        LottoRank rank = LottoRank.getRank(count, bonusMatch);

        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("로또 번호가 5개 및 보너스 당첨된 경우 LottoRank SECOND가 저장된다.")
    public void lottoRankSecond(){
        //given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        Lotto publicLotto = new Lotto(lottoNumbers);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        Integer bonusNum = 7;

        Integer count = publicLotto.getMatchCount(winningLotto);
        boolean bonusMatch = publicLotto.getBonusMatch(bonusNum);
        LottoRank rank = LottoRank.getRank(count, bonusMatch);

        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("로또 번호가 5개가 당첨된 경우 LottoRank THIRD 저장된다.")
    public void lottoRankTHIRD(){
        //given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 9);
        Lotto publicLotto = new Lotto(lottoNumbers);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        Integer bonusNum = 7;

        Integer count = publicLotto.getMatchCount(winningLotto);
        boolean bonusMatch = publicLotto.getBonusMatch(bonusNum);
        LottoRank rank = LottoRank.getRank(count, bonusMatch);

        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("로또 번호가 4개 당첨된 경우 LottoRank FOURTH 저장된다.")
    public void lottoRankFourth(){
        //given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 9, 10);
        Lotto publicLotto = new Lotto(lottoNumbers);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        Integer bonusNum = 7;

        Integer count = publicLotto.getMatchCount(winningLotto);
        boolean bonusMatch = publicLotto.getBonusMatch(bonusNum);
        LottoRank rank = LottoRank.getRank(count, bonusMatch);

        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("로또 번호가 3개 당첨된 경우 LottoRank FIFTH 저장된다.")
    public void lottoRankFifth(){
        //given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 9, 10, 11);
        Lotto publicLotto = new Lotto(lottoNumbers);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        Integer bonusNum = 7;

        Integer count = publicLotto.getMatchCount(winningLotto);
        boolean bonusMatch = publicLotto.getBonusMatch(bonusNum);
        LottoRank rank = LottoRank.getRank(count, bonusMatch);

        assertThat(rank).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("1개의 로또가 번호가 3개 당첨된 경우 수익은 5,000원이다.")
    public void lottoProfitFifth(){
        Map<LottoRank, Integer> lottoResult = new HashMap<>();
        LottoResultService lottoResultService = new LottoResultService();

        lottoResult.put(LottoRank.FIFTH, 1);
        double profit = lottoResultService.getProfit(lottoResult);

        assertThat(profit).isEqualTo(5000);
    }

    @Test
    @DisplayName("2개의 로또를 사 5,4등이 당첨되면 수익률은 5250%이다.")
    public void lottoProfitRateFifthAndFourth(){
        Map<LottoRank, Integer> lottoResult = new HashMap<>();
        LottoResultService lottoResultService = new LottoResultService();

        lottoResult.put(LottoRank.FIFTH, 1);
        lottoResult.put(LottoRank.FOURTH, 2);
        double profitRate = lottoResultService.getProfitRate(lottoResult, 2);

        assertThat(profitRate).isEqualTo(5250);
    }

}
