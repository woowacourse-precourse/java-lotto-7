package lotto;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        InputHandler handler = new InputHandler();
        LotteryMachine machine = new LotteryMachine();
        LottoResultCalculator calculator = new LottoResultCalculator();

        int price = handler.getPrice();
        Lotto winningLotto = handler.getWinningNumbers();
        int bonusNumber = handler.getBonusNumber(winningLotto);

        ArrayList<Lotto> myLotto = machine.generateLottoList(price);

        calculator.calculateWinnings(myLotto, winningLotto, bonusNumber, price);
    }
}
