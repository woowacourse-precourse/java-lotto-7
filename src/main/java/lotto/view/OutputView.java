package lotto.view;

import lotto.repository.LottoRepository;
import lotto.util.Utils;

public class OutputView {
    private static OutputView outputView;

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void printGuide(){
        System.out.println(Utils.Purchase_AMOUNT);
    }

    public void printCount(Integer count){
        System.out.println();
        System.out.println(count+Utils.Purchase_LOTTO_COUNT);
    }

    public void printLottoNumber(){
        LottoRepository.lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printWinningNumber(){
        System.out.println();
        System.out.println(Utils.WINNING_NUMBER);
    }
}
