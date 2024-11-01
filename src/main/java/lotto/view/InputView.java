package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchasePrice;

public class InputView {

    public PurchasePrice receivePurchasePrice() {
        while(true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int inputPrice = Integer.parseInt(Console.readLine().trim());
                return new PurchasePrice(inputPrice);
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.NOT_A_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }


    }
}
