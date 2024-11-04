package lotto;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        
    	try {    		
    		// 구입 금액 입력 받기
    		int purchaseAmount = InputView.requestPurchaseAmount();
        	int numberOfLottos = purchaseAmount/1000;
        	
        	// 로또 번호 생성
        	List<Lotto> lottos = new ArrayList<>();
            for (int i = 0; i < numberOfLottos; i++) {
                lottos.add(LottoGenerator.generate());
            }
        	
            // 로또 구매 정보 출력
            OutputView.printLottoPurchaseInfo(numberOfLottos, lottos);
        	
            // 당첨 번호 및 보너스 번호 입력 받기
        	List<Integer> winningNumbers = InputView.requestWinningNumbers();
            int bonusNumber = InputView.requestBonusNumber();
                
            // 당첨 로또 정보 생성
            WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
            
            // 당첨 결과 계산
            LottoResult result = new LottoResult(lottos, winningLotto);
            
            // 결과 출력
            OutputView.printWinningStatistics(result);
            OutputView.printRateOfReturn(result.calculateProfitRate(purchaseAmount));
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 메시지 출력
        }
    }
}
