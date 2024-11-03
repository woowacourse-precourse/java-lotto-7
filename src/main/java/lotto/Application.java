package lotto;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        
    	try {    		
    		int purchaseAmount = InputView.requestPurchaseAmount();
        	int numberOfLottos = purchaseAmount/1000;
        	
        	List<Lotto> lottos = new ArrayList<>();
            for (int i = 0; i < numberOfLottos; i++) {
                lottos.add(LottoGenerator.generate());
            }
        	
            OutputView.printLottoPurchaseInfo(numberOfLottos, lottos);
        	
            
            
        	List<Integer> winningNumbers = InputView.requestWinningNumbers();
            int bonusNumber = InputView.requestBonusNumber();
                
            
            WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 메시지 출력
        }
    	
    }
}
