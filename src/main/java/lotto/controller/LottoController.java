package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGameInfo;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.service.LottoCalculator;
import lotto.service.LottoGenerator;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void startGame() {
        // 구매금액
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoGameInfo gameInfo = new LottoGameInfo();
        gameInfo.setPurchaseAmount(purchaseAmount);
        gameInfo.setLottotickets(purchaseAmount);

        //로또 생성
        int lottoTicketsCount = gameInfo.getLottotickets();
        OutputView.countLotto(lottoTicketsCount);
        List<Lotto> lottoTickets = LottoGenerator.generateLottoTickets(lottoTicketsCount);
        for (Lotto lotto : lottoTickets) {
            OutputView.lottoPrint(lotto);
        }

        //당첨 번호
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        gameInfo.setWinningNumber(winningNumbers);

        //보너스번호
        int bonusNumber = InputView.getBonusNumber(winningNumbers);
        gameInfo.setBonusNumber(bonusNumber);


        //당첨계산
        LottoResult lottoResult = new LottoResult();
        for (int i = 0; i < lottoTicketsCount; i++) {
            LottoRank rank = LottoCalculator.calculateRank(
                    lottoTickets.get(i),
                    gameInfo.getWinningNumber(),
                    gameInfo.getBonusNumber()
            );
            if (rank != LottoRank.LOSING) {
                lottoResult.incrementRankCount(rank);
            }
        }

        //결과 출력
        OutputView.lottoResult(lottoResult, lottoResult.getTotalPrizeAmount(), purchaseAmount);







    }
}
