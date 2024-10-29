package lotto.view;

import lotto.domain.Lotteries;

public class OutputView {
    private static final String PURCHASE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";

    public void showPurchaseInputMessage() {
        System.out.println(PURCHASE_INPUT_MESSAGE);
    }


    public void showLottoCountAndNumbers(Lotteries lotteries) {
        showLottoCount(lotteries.getCount());
        showLottoNumbers(lotteries.getLottoNumbers());
    }

    private void showLottoCount(int count) {
        System.out.println(count + PURCHASE_COUNT_MESSAGE);
    }

    private void showLottoNumbers(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }
}
