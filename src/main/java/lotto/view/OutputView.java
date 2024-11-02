package lotto.view;

import java.util.List;

public class OutputView {

    public static void showBuyLottos(int numberOfTickets, List<String> lottoNumbers) {
        System.out.println(numberOfTickets + "개를 구매했습니다.");
        for (String lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

}
