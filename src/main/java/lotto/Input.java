package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

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

    public int [] readWinningNumber(){
        try {
            String input = readLine();

            return  Arrays.stream(input.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }

    public int readBonusNumber(){
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }
}
