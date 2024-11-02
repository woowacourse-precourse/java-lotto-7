package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoWinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private LottoService lottoService;
    private InputView inputView;
    private OutputView outputView;

    public LottoController() {
        lottoService = new LottoService();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run(){
        int lottoCost = inputView.inputLottoCost();

        int ticketCount = lottoService.purchaseLottoCount(lottoCost);
        List<Lotto> lottoTickets = lottoService.generateRandomLottoNumbers(ticketCount);
        outputView.printLottoTickets(lottoTickets, ticketCount);

        LottoWinningNumbers winningNumbersSet = inputWinningNumbers();
        Map<LottoRank, Integer> lottoResultMap = processResults(ticketCount, lottoTickets, winningNumbersSet);

        int amount = lottoService.sumAmount(lottoResultMap);
        double rate = lottoService.calculateRate(amount, lottoCost);
        lottoService.setLottoRate(rate);

        outputView.totalLotto(lottoService.getLottoResult());
    }

    private LottoWinningNumbers inputWinningNumbers() {
        String winningNumbers = inputView.inputWinningNumbers();
        List<String> splitWinningNumbers = lottoService.splitWinningNumbers(winningNumbers);
        List<String> trimWinningNumbers = lottoService.trimWinningNumbers(splitWinningNumbers);
        List<Integer> winningNumbersInt = lottoService.convertToInt(trimWinningNumbers);
        int bonusNumber = inputView.inputLottoBonusNumber();
        return lottoService.winningLotto(winningNumbersInt, bonusNumber);
    }

    private Map<LottoRank, Integer> processResults(int ticketCount, List<Lotto> lottoTickets, LottoWinningNumbers winningNumbersSet) {
        Map<LottoRank, Integer> lottoResultMap = lottoService.getResult();
        for(int i=0; i<ticketCount; i++){
            int countMatchingNumbers = lottoService.checkWinningNumbers(winningNumbersSet, i);
            LottoRank rankByMatchCount = LottoRank.getRankByMatchCount(countMatchingNumbers);
            // 당첨번호와 일치하는 개수로 LottoRank(enum)를 찾는다

            if(rankByMatchCount != null){
                rankByMatchCount = lottoService.compareBonusNumber(rankByMatchCount, winningNumbersSet.getBonusNumber());
                lottoService.putLottoResultMap(rankByMatchCount, lottoResultMap);
            }
        }
        lottoService.putLottoResult(lottoResultMap);

        return lottoResultMap;
    }

}
