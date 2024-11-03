package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public int readLottoAmount(){
        try {
            int lottoAmount = Integer.parseInt(readLine());

            if(lottoAmount % 1000 != 0){
                throw new IllegalArgumentException("[ERROR] ");
            }

            return lottoAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }
}
