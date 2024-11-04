package lotto.controller;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResult;
import lotto.model.WinningNumbers;
import lotto.view.output.GeneratedLottoOutputView;
import lotto.view.output.LottoResultOutputView;
import lotto.view.output.OutputView;

public class Controller {
    private final LottoMachine lottoMachine;

    public Controller(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public OutputView purchaseLotto(int purchaseAmount) {
        List<Lotto> lottos = lottoMachine.generateLotto(purchaseAmount);
        LottoDto lottoDto = new LottoDto(lottos);

        return new GeneratedLottoOutputView(lottoDto);
    }

    public OutputView matchWinningNumbers(List<Integer> numbers, int bonusBall) {
        Lotto lotto = new Lotto(numbers);
        WinningNumbers winningNumbers = new WinningNumbers(lotto, bonusBall);

        LottoResult result = lottoMachine.match(winningNumbers);
        LottoResultDto lottoResultDto = new LottoResultDto(result);

        return new LottoResultOutputView(lottoResultDto);
    }
}
