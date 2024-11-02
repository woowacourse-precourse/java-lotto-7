package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputHandler {
    public int priceInput() {
        while(true) {
            try {
                int price = Integer.parseInt(Console.readLine());
                priceInputValidator(price);
                return price;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void priceInputValidator(int price){
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000단위만 가능합니다.");
        }
    }

}
