package lotto;

import java.util.List;

public class LottoPrint {
    //발행된 로또 번호 출력
    public static void printNumbers(List<Lotto> lottoList){
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
}
