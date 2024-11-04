package lotto.controller;

import lotto.View.Input.Input;
import lotto.View.Output.Output;
import lotto.model.Lotto;
import lotto.model.PrizeType;

import java.util.List;


public class IOController {
    private Input input;
    private Output output;

    public IOController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public int inputCash() {
        output.printInputCash();
        return input.inputCash();
    }

    public void printPurchaseLotto(List<Lotto> winningLotto, int lottoCount){
        output.printLottoCount(lottoCount);
        output.printGeneratedLotto(winningLotto);
    }

    public List<Integer> inputExpectedLotto() {
        List<Integer> lottoByUser = lottoByUser();
        return lottoByUser;
    }

    public int inputBonusBall(){
        return bonusByUser();
    }

    public void printWinningResult(List<PrizeType> prizes, double rateOfReturn){
        //당첨통계 출력
        output.printWinningPrize(prizes);
        //수익률 출력
        output.printRateOfReturn(rateOfReturn);
    }

    private List<Integer> lottoByUser() {
        output.printInputLottoNum();
        return input.inputLottoNum();
    }

    private int bonusByUser() {
        output.printInputBonusNum();
        return input.inputBonusNum();
    }

}
