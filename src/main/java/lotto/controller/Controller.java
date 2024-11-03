package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.LottoConstants;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class Controller {
    private final Input input;
    private final Output output;
    private final LottoService lottoService;

    public Controller(Input input, Output output, LottoService lottoService) {
        this.input = input;
        this.output = output;
        this.lottoService = lottoService;
    }

    public void run(){
        int amount = input.inputPurchaseAmount();
        int numberOfTickets = amount / LottoConstants.LOTTO_PRICE.getValue();

        List<Lotto> lottos = lottoService.createLotto(numberOfTickets);
        output.printLottoNumbers(lottos);

        Lotto winningLotto = input.inputWinningNumbers();
        int bonusNumber = input.inputBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);

        List<Prize> prizes = lottoService.countMatches(lottos, winningNumbers);
        output.printPrizeStatistics(prizes, amount);
    }
}
