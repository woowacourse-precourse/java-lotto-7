package lotto.view;

import lotto.controller.dto.LottoPurchaseResponse;
import lotto.domain.Lotto;

import java.util.List;

public class Output {

    public static final String NUMBER_OF_LOTTO_PURCHASES = "\n%d개를 구매하셨습니다.\n";
    public static final String WINNING_STATISTICS_OUTPUT_MESSAGE = "당첨 통계\n---\n";

    public void printPurchaseLotto(LottoPurchaseResponse response) {
        System.out.printf(NUMBER_OF_LOTTO_PURCHASES, response.amount());
        List<Lotto> lottoList = response.lottoList();

        for (int i = 0; i < response.amount(); i++) {
            System.out.println(lottoList.get(i).getNumbers());
        }
    }
}
