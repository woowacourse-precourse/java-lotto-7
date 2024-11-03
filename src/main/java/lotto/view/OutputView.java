package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String OUTPUT_LOTTO_COUNT = "개를 구매했습니다.";

    public void printInputPurchaseAmount(){
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public void printInputWinnerNumber(){
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public void printInputBonusNumber(){
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void printOutputLottoCount(int lottoCount){
        System.out.println();
        System.out.println(lottoCount + OUTPUT_LOTTO_COUNT);
    }

    public void printOutputLottoNumbers(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            System.out.println(lotto);
        }
    }
}
