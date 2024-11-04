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
        printLottoStatistics(LottoResults, lottoTickets);
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
        // 당첨 번호는 한 번만 입력 받고 보너스 번호가 중복되는 경우 다시 입력을 받는다
        WinningNumbers winningNumbers = inputValidWinningNumbers();
        BonusNumber bonusNumber;

        while (true) {
            try {
                bonusNumber = inputValidBonusNumber();
                return WinningLotto.of(winningNumbers, bonusNumber);
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

    private void printLottoStatistics(List<LottoRank> lottoResult, LottoTickets lottoTickets) {
        LottoStatisticsDto statisticsDto = new LottoStatisticsDto(lottoResult, lottoTickets);
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