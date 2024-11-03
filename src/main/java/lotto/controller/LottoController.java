package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoWinningNumbers;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.service.LottoValidateService;
import lotto.service.LottoValidateServiceImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private LottoService lottoService;
    private LottoValidateService lottoValidateService;
    private InputView inputView;
    private OutputView outputView;

    public LottoController() {
        lottoService = new LottoServiceImpl();
        lottoValidateService = new LottoValidateServiceImpl();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {

        int lottoCost = inputLottoCost();

        int ticketCount = lottoService.purchaseLottoCount(lottoCost);
        List<Lotto> lottoTickets = lottoService.generateRandomLottoNumbers(ticketCount);
        outputView.printLottoTickets(lottoTickets, ticketCount);

        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputLottoBonusNumber();

        LottoWinningNumbers winningNumbersSet = lottoService.winningLotto(winningNumbers, bonusNumber);
        Map<LottoRank, Integer> lottoResultMap = processResults(ticketCount, winningNumbersSet);

        int amount = lottoService.sumAmount(lottoResultMap);
        double rate = lottoService.calculateRate(amount, lottoCost);
        lottoService.setLottoRate(rate);

        outputView.totalLotto(lottoService.getLottoResult());
    }

    private int inputLottoCost() {

        while (true) {
            try {
                String lottoCost = inputView.inputLottoCost();
                lottoValidateService.validateLottoCost(lottoCost);

                return lottoService.toInt(lottoCost);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> inputWinningNumbers() {

        while (true) {
            try {
                String winningNumbers = inputView.inputWinningNumbers();
                lottoValidateService.validateWinningNumbers(winningNumbers);

                return transformIntWinningNumbers(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> transformIntWinningNumbers(String winningNumbers) {

        List<String> splitWinningNumbers = lottoService.splitWinningNumbers(winningNumbers);
        List<String> trimWinningNumbers = lottoService.trimWinningNumbers(splitWinningNumbers);
        List<Integer> winningNumbersInt = lottoService.convertToInt(trimWinningNumbers);

        return winningNumbersInt;
    }

    private int inputLottoBonusNumber() {

        while (true) {
            try {
                String bonusNumber = inputView.inputLottoBonusNumber();
                lottoValidateService.validateBonusNumbers(bonusNumber);

                return lottoService.toInt(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private Map<LottoRank, Integer> processResults(int ticketCount, LottoWinningNumbers winningNumbersSet) {

        Map<LottoRank, Integer> lottoResultMap = lottoService.getResult();
        for (int i = 0; i < ticketCount; i++) {
            int countMatchingNumbers = lottoService.checkWinningNumbers(winningNumbersSet, i);
            LottoRank rankByMatchCount = LottoRank.getRankByMatchCount(countMatchingNumbers);
            // 당첨번호와 일치하는 개수로 LottoRank(enum)를 찾는다

            if (rankByMatchCount != null) {
                rankByMatchCount = lottoService.compareBonusNumber(rankByMatchCount, winningNumbersSet.getBonusNumber());
                lottoService.putLottoResultMap(rankByMatchCount, lottoResultMap);
            }
        }
        lottoService.putLottoResult(lottoResultMap);

        return lottoResultMap;
    }

}
