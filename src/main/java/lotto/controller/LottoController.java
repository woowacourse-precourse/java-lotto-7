package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.util.Calculator;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView input;
    private final OutputView output;


    public LottoController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void proceed(){
        int lottoAmount = inputLottoAmount();
        int lottoTicketNumber = Calculator.calculateLottoTicketNumber(lottoAmount);
        List<Lotto> userLotto = LottoMachineController.issueLotto(lottoTicketNumber);
        output.printLottoTicket(userLotto,lottoTicketNumber);

        List<Integer> winningLotto = inputWinningNumber();
        int bonusNumber = inputBonusNumber(winningLotto);

        // 발행된 로또와 당첨 로또, 보너스 비교
    }

    public int inputLottoAmount(){
        try{
            return input.inputLottoAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoAmount();
        }
    }

    public List<Integer> inputWinningNumber(){
        try{
            return input.inputWinningNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
    }

    public int inputBonusNumber(List<Integer> winningLotto){
        try{
            int bonusNumber = input.inputBonusNumber();
            Validator.validateBonusDuplicate(winningLotto, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningLotto);
        }
    }
}
