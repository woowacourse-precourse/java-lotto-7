package lotto.controller;

import java.util.List;
import lotto.dto.BonusDTO;
import lotto.dto.BuyLottosDTO;
import lotto.dto.MoneyDTO;
import lotto.dto.WinningLottoDTO;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoBank;
import lotto.model.LottoResult;
import lotto.model.LottoSeller;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        MoneyDTO moneyDTO = inputView.readMoney();
        LottoSeller seller = new LottoSeller();
        List<Lotto> myLottos = seller.sell(moneyDTO);
        System.out.println();

        outputView.printLotto(myLottos.size());
        outputView.printLottoDetail(BuyLottosDTO.from(myLottos));
        System.out.println();

        WinningLottoDTO winningLottoDTO = inputView.readWinningLottoNumbers();
        WinningLotto winningLotto = new WinningLotto(winningLottoDTO.numbers());
        System.out.println();

        BonusDTO bonusDTO = inputView.readBonus();
        BonusNumber bonusNumber = new BonusNumber(bonusDTO.number());
        System.out.println();

        LottoBank lottoBank = new LottoBank();
        LottoResult lottoResult = lottoBank.evaluate(winningLotto, myLottos, bonusNumber);

        outputView.printLottoResult(lottoResult);
        double profitRate = lottoBank.calculateProfitRate(lottoResult, moneyDTO.money());
        outputView.printProfitRate(profitRate);
    }
}
