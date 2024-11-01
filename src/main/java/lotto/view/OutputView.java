package lotto.view;

import java.util.List;

public class OutputView {

    public void printLottoPurchaseCountMessage(int lottoCount) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottoCount);
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }
    
}
