package lotto;

import lotto.view.*;
import lotto.controller.*;

import java.util.List;

//import Lotto;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //Lotto lotto = new Lotto(lottoNumbers); // Lotto 객체 생성
        int price = InputView.purchaseAmount();


        List<Integer> winningNumbers = InputView.winningNumber();
        System.out.println(winningNumbers);

        int bonusNubmer = InputView.bonusNumber();
        System.out.println(bonusNubmer);

       Lotto.validateDuplicationBetweenWinningAndBonus(winningNumbers, bonusNubmer);


    }
}
