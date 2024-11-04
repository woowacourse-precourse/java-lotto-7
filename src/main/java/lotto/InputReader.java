package lotto;

import camp.nextstep.edu.missionutils.Console;


public class InputReader {

    Validation validation = new Validation();
    public int readLottoPrice(){
        String lottoPrice = Console.readLine();
        validation.validateLottoPrice(lottoPrice);
        return Integer.parseInt(lottoPrice);
    }
}
