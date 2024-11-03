package lotto.service;

import lotto.domain.Lotto;
import lotto.util.LottoNumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoService(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Lotto winningLottoNumbers() {
        try{
            return new Lotto(LottoNumberParser.parseLottoNumbers(inputView.inputWinningNumbers()));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return winningLottoNumbers();
        }
    }
}
