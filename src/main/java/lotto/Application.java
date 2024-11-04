package lotto;

import lotto.controller.Controller;
import lotto.model.BonusNumber;
import lotto.model.Seller;
import lotto.model.WinningNumber;
import lotto.view.Input;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        Seller seller = new Seller();
        WinningNumber winningNumber = new WinningNumber();
        BonusNumber bonusNumber = new BonusNumber();
        
        Controller controller = new Controller(input, output, seller, winningNumber, bonusNumber);

        controller.run();
    }
}
