package lotto;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        InputHandler handler = new InputHandler();
        LotteryMachine machine = new LotteryMachine();
        LottoResultCalculator calculator = new LottoResultCalculator();

        int price = handler.getPrice();

        ArrayList<Lotto> myLotto = machine.generateLottoList(price);

        List<Integer> winningNumberList = handler.getWinningNumbers();
        int bonusNumber = handler.getBonusNumber(winningNumberList);

        calculator.calculateWinnings(myLotto, winningNumberList, bonusNumber, price);
    }
}
