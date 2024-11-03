package lotto;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        
    	int purchaseAmount = InputView.requestPurchaseAmount();
    	int numberOfLottos = purchaseAmount/1000;
    	System.out.println(numberOfLottos + "개를 구매했습니다.");
    	
    	List<Integer> winningNumbers = InputView.requestWinningNumbers();
        int bonusNumber = InputView.requestBonusNumber();
    	
    }
}
