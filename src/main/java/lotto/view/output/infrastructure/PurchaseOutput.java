package lotto.view.output.infrastructure;

import lotto.view.output.domain.PurchaseCountViewService;

public class PurchaseOutput implements PurchaseCountViewService {
    public void view(int count) {
        System.out.printf("%d개를 구매했습니다.", count);
        nextLine();
    }
    private void nextLine() {
        System.out.println();
    }
}
