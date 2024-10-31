package view;

import lotto.Lotto;
import model.LottoAmount;
import model.LottoCollection;

public class OutputView {

    private static final String PRINT_LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public OutputView() {

    }

    public void printLottoAmount(LottoAmount lottoAmount) {
        System.out.println(System.lineSeparator()+lottoAmount.getCount() + PRINT_LOTTO_AMOUNT_MESSAGE);
    }

    public void printLottos(LottoCollection lottoCollection){
        for(Lotto lotto: lottoCollection.getLottos())
            System.out.println(lotto);
    }
}
