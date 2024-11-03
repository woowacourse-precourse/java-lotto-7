package lotto;

import java.util.List;

public class OutputConsole {

    public static void outputLottoList(List<Lotto> lottoList){
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

}