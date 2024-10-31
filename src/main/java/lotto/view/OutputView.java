package lotto.view;

import lotto.dto.LottoResponseDTO;
import lotto.dto.PurchaseResultDTO;

public class OutputView {

    public void showErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void showPurchasedLottos(PurchaseResultDTO result) {
        System.out.printf("%d개를 구매했습니다.\n", result.getCount());
        for (LottoResponseDTO lotto : result.getResults()) {
            System.out.println(lotto);
        }
    }
}
