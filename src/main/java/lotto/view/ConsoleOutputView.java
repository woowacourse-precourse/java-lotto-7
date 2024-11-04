package lotto.view;

import lotto.model.BoughtLottos;
import lotto.model.outcome.LottoResult;

/** 출력값을 전달받아서 콘솔로 출력한다. */
public class ConsoleOutputView implements OutputView {
    
    private static final String GUIDE_AMOUNT_BUY = "개를 구매했습니다.";
    
    @Override
    public void printLottos(BoughtLottos boughtLottos) {
        System.out.println();
        System.out.println(boughtLottos.getSize() + GUIDE_AMOUNT_BUY);
        System.out.println(boughtLottos);
    }
    
    @Override
    public void printResult(LottoResult result) {
        System.out.println();
        System.out.println(result);
    }
    
}
