package lotto;

import lotto.view.*;
import lotto.controller.*;

import java.util.List;

import static lotto.view.InputView.printPurchaseQuantity;

//import Lotto;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price = InputView.purchaseAmount();
        int purchaseQuantity = price/1000;
        InputView.printPurchaseQuantity(price);
        OutputView.printLottoNumbers(purchaseQuantity);
        List<Integer> winningNumbers = InputView.winningNumber();
        int bonusNubmer = InputView.bonusNumber();
        Lotto.validateDuplicationBetweenWinningAndBonus(winningNumbers, bonusNubmer);


    }
}
