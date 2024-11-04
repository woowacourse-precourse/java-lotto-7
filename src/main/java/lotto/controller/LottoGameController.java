package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoRank;
import lotto.model.LottoStatisticsDto;
import lotto.model.LottoTickets;
import lotto.model.RandomNumberGenerator;
import lotto.model.WinningLotto;
import lotto.model.WinningNumbers;
import lotto.view.LottoGameInputView;
import lotto.view.LottoGameOutputView;

public class LottoGameController {

    public void run() {
        LottoTickets lottoTickets = new LottoTickets(LottoGameInputView.inputMoney());
        LottoGameOutputView.printTicketCount(lottoTickets);

        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());
        List<Lotto> lottos = lottoMachine.exchangeLotto(lottoTickets);
        LottoGameOutputView.printLottos(lottos);

        WinningNumbers winningNumbers = new WinningNumbers(LottoGameInputView.inputWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(LottoGameInputView.inputBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        List<LottoRank> lottoResult = lottos.stream().map(winningLotto::matchLotto).toList();

        LottoStatisticsDto lottoStatisticsDto = new LottoStatisticsDto(lottoResult, lottoTickets.getPurchasePrice());
        LottoGameOutputView.printLottoStatistics(lottoStatisticsDto);
    }
}
