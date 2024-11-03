package lotto.view;

import java.util.List;

public class OutputView {

    public void printPurchaseAmount(int lottoQuantity) {
        System.out.println();
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Integer> numbers){
        System.out.println(numbers);
    }

    public void printEnter() {
        System.out.println();
    }
}
