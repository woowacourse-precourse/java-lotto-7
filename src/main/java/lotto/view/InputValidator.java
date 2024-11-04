package lotto.view;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.view.Input;

public class InputValidator {
    private Input input = new Input();
    public int readBuyLotto(){
        while (true) {
            try {
                return input.readLottoAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto readWinningLotto(){
        while (true) {
            try {
                return new Lotto(input.readWinningNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void makeBonusNumber(Lotto winningLotto){
        while (true) {
            try {
                new BonusNumber(input.readBonusNumber(), winningLotto);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
