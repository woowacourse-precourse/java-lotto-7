package lotto.controller;

import lotto.entity.BonusNumber;
import lotto.entity.Lotto;
import lotto.entity.Price;
import lotto.entity.WinningNumber;
import lotto.model.LottoGenerator;
import lotto.model.LottoResult;
import lotto.view.output.LottoGeneratorOutputView;
import lotto.view.output.LottoResultOutputView;
import lotto.view.output.OutputView;
import lotto.view.input.BonusNumberInputView;
import lotto.view.input.InputView;
import lotto.view.input.PriceInputView;
import lotto.view.input.WinningNumberInputView;

import java.util.List;

public class LottoGame {
    public void start(){
        InputView priceInputView = new PriceInputView();
        Price price = inputPrice(priceInputView);

        InputView winningNumberInputView = new WinningNumberInputView();
        InputView bonusNumberInputView = new BonusNumberInputView();

        List<Lotto> lottos = new LottoGenerator(price).getLottoList();

        OutputView lottoGeneratorOutputView = new LottoGeneratorOutputView(lottos);
        lottoGeneratorOutputView.print();

        WinningNumber winningNumber = new WinningNumber(winningNumberInputView.input());
        BonusNumber bonusNumber = new BonusNumber(bonusNumberInputView.input());

        LottoResult lottoResult = new LottoResult(price, lottos, winningNumber, bonusNumber);

        LottoResultOutputView outputView = new LottoResultOutputView(lottoResult.getWinningHistory(), lottoResult.getRateOfReturn());
        outputView.print();
    }

    private Price inputPrice(InputView view){
        Price price = null;

        try{
            price = new Price(view.input());
        }catch (IllegalArgumentException exception){
            inputPrice(view);
        }

        return price;
    }
}
