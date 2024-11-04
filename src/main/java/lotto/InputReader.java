package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {
    public void readLottoPrice(){
        String lottoPrice = Console.readLine();
        validateLottoPrice(lottoPrice);
    }
}
