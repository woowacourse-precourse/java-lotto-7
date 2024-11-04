package lotto.week3.service;

import java.util.List;
import lotto.week3.domain.Lotto;
import lotto.week3.dto.PurchaseRequestDto;
import lotto.week3.dto.WinningNumberRequestDto;
import lotto.week3.model.LottoGenerator;
import lotto.week3.domain.LottoMatching;
import lotto.week3.model.LottoStatistics;


public class LottoService {


    // 로또 발행
    public LottoMatching generatorLottos(PurchaseRequestDto purchaseRequestDto) {
        List<Lotto> lottoList = LottoGenerator.generatorLottos(purchaseRequestDto.getCounts());
        LottoStatistics statistics = new LottoStatistics();
        return new LottoMatching(lottoList, statistics);
    }

    // 보너스 번호, 당첨번호 매칭
    public void calculateWinningStatistics(LottoMatching lottoMatching, WinningNumberRequestDto winningNumber) {
        lottoMatching.mathing(winningNumber.getWinningNumbers(), winningNumber.getBonusNumber());
    }

    /*
    로또 번호 매칭 - > 당첨번호랑 자동 발급된 번호 매칭 -> 확률 구현
     */
    public double calculateYied(LottoStatistics statistics, int purchaseAmount) {
        int totalPrize = statistics.calculateTotalPrize();
        return ((double) totalPrize / purchaseAmount) * 100;
    }

}
