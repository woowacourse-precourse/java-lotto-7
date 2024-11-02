package lotto.view;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;

public class OutView {

    private final static String GENERATEDLOTTOMESSAGE = "개를 구매했습니다.";

    public static void generatedLottoPrint(int lottoCount, Lottos lottos){
        System.out.println(lottoCount+GENERATEDLOTTOMESSAGE);

        for (Lotto lotto : lottos.getLottos()){
            System.out.println(lotto.getNumbers());
        }
    }



}
