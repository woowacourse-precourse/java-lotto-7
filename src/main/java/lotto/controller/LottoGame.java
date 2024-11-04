package lotto.controller;

import lotto.entity.BonusNumber;
import lotto.entity.Lotto;
import lotto.entity.Price;
import lotto.entity.WinningNumber;
import lotto.enums.LottoPrize;
import lotto.model.LottoGenerator;
import lotto.model.LottoResult;
import lotto.view.output.LottoGeneratorOutputView;
import lotto.view.output.LottoResultOutputView;
import lotto.view.input.BonusNumberInputView;
import lotto.view.input.InputView;
import lotto.view.input.PriceInputView;
import lotto.view.input.WinningNumberInputView;

import java.util.HashMap;
import java.util.List;

public class LottoGame {
    public void start(){
        Price price = inputPrice(new PriceInputView());

        List<Lotto> lottos = getLottos(price);

        printLottos(lottos);

        WinningNumber winningNumber = inputWinningNumber(new WinningNumberInputView());
        BonusNumber bonusNumber = inputBonusNumber(new BonusNumberInputView());

        LottoResult lottoResult = new LottoResult(price, lottos, winningNumber, bonusNumber);

        printLottoResult(lottoResult.getWinningHistory(), lottoResult.getRateOfReturn());
    }

    private Price inputPrice(InputView view){
        Price price;

        try{
            price = new Price(view.input());
        }catch (IllegalArgumentException exception){
            price = inputPrice(view);
        }

        return price;
    }

    private List<Lotto> getLottos(Price price){
        return new LottoGenerator(price).getLottoList();
    }

    private void printLottos(List<Lotto> lottos){
        new LottoGeneratorOutputView(lottos).print();
    }

    private WinningNumber inputWinningNumber(InputView view){
        WinningNumber winningNumber;

        try{
            winningNumber = new WinningNumber(view.input());
        }catch (IllegalArgumentException exception){
            winningNumber = inputWinningNumber(view);
        }

        return winningNumber;
    }

    private BonusNumber inputBonusNumber(InputView view){
        BonusNumber bonusNumber;

        try{
            bonusNumber = new BonusNumber(view.input());
        }catch (IllegalArgumentException exception){
            bonusNumber = inputBonusNumber(view);
        }

        return bonusNumber;
    }

    private void printLottoResult(HashMap<LottoPrize, Integer> winningHistory, double rateOfReturn){
        new LottoResultOutputView(winningHistory, rateOfReturn).print();
    }
}
