package lotto.controller;

import java.util.List;
import lotto.model.domain.BonusNumber;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoMachine;
import lotto.model.domain.LottoRank;
import lotto.model.domain.LottoTickets;
import lotto.model.domain.WinningLotto;
import lotto.model.domain.WinningNumbers;
import lotto.model.dto.LottoStatisticsDto;
import lotto.model.generator.RandomNumberGenerator;
import lotto.view.LottoGameInputView;
import lotto.view.LottoGameOutputView;

public class LottoGameController {

    public void run() {
        LottoTickets lottoTickets = inputValidLottoTickets();

        List<Lotto> lottos = generateLottosFromTickets(lottoTickets);
        printGeneratedLottos(lottos);

        WinningLotto winningLotto = inputValidWinningLotto();

        List<LottoRank> LottoResults = matchLottosWithWinningLotto(lottos, winningLotto);
        printLottoStatistics(LottoResults, lottoTickets.getPurchasePrice());
    }

    private LottoTickets inputValidLottoTickets() {
        while (true) {
            try {
                return new LottoTickets(LottoGameInputView.inputMoney());
            } catch (IllegalArgumentException e) {
                LottoGameOutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Lotto> generateLottosFromTickets(LottoTickets lottoTickets) {
        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());
        return lottoMachine.generateLottos(lottoTickets);
    }

    private void printGeneratedLottos(List<Lotto> lottos) {
        LottoGameOutputView.printLottos(lottos);
    }

    private WinningLotto inputValidWinningLotto() {
        while (true) {
            try {
                WinningNumbers winningNumbers = inputValidWinningNumbers();
                BonusNumber bonusNumber = inputValidBonusNumber();
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                LottoGameOutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<LottoRank> matchLottosWithWinningLotto(List<Lotto> lottos, WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::determineRank)
                .toList();
    }

    private void printLottoStatistics(List<LottoRank> lottoResult, int purchasePrice) {
        LottoStatisticsDto statisticsDto = new LottoStatisticsDto(lottoResult, purchasePrice);
        LottoGameOutputView.printLottoStatistics(statisticsDto);
    }


    private WinningNumbers inputValidWinningNumbers() {
        while (true) {
            try {
                return new WinningNumbers(LottoGameInputView.inputWinningNumbers());
            } catch (IllegalArgumentException e) {
                LottoGameOutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumber inputValidBonusNumber() {
        while (true) {
            try {
                return new BonusNumber(LottoGameInputView.inputBonusNumber());
            } catch (IllegalArgumentException e) {
                LottoGameOutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}