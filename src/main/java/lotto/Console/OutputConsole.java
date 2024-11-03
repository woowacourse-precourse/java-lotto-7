package lotto.Console;

import java.util.List;
import lotto.Lotto;

public class OutputConsole {

    public static void outputLottoList(List<Lotto> lottoList){
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

}