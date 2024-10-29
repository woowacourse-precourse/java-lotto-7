package lotto.view;

import lotto.dto.CreateLottoInfo;

public class OutputView {
    private static final String PURCHASE_MESSAGE_FORMAT = "%d개를 구매했습니다.";

    public void printCreateLottoInfo(CreateLottoInfo createLottoInfo) {
        System.out.println();
        System.out.println(getPurchaseMessageFormat(createLottoInfo.lottoCount()));
        System.out.println(createLottoInfo.lottos());
    }

    private String getPurchaseMessageFormat(long quantity) {
        return String.format(PURCHASE_MESSAGE_FORMAT, quantity);
    }
}
