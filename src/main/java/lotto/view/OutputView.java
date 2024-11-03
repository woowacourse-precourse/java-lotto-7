package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";

    public void buyOutput(int price, List<Lotto> lottoNumber) {
        System.out.println(price + PURCHASE_MESSAGE);
        buyNumbersOutput(lottoNumber);
    }

    private void buyNumbersOutput(List<Lotto> lottoNumber) {
        lottoNumber.stream()
                .map(Lotto::getSortNumbers)
                .forEach(System.out::println);
        System.out.println();
    }

}
