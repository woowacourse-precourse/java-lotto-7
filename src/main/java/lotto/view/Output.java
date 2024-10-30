package lotto.view;

import lotto.domain.Wallet;
import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.RandomLottos;

public class Output {
    public static void printError(String error) {
        System.out.printf("[ERROR] %s \n", error);
    }

    public static void printPurchasedLottoList(Wallet wallet, RandomLottos randomLottos){
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n",wallet.getTicket());
        for(Lotto lotto : randomLottos.getLottos()){
            System.out.println(lotto);
        }


    }

}
