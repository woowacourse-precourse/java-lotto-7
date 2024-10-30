package lotto;

import constants.Constants;
import camp.nextstep.edu.missionutils.Console;

public class LottoInput {
    public int purchaseInput() {
        System.out.println("구입금액을 " + Constants.LOTTO_PRICE + " 원 단위로 입력해 주세요.");

        try {
            int purchasePrice = Integer.parseInt(Console.readLine());
            if (purchasePrice % Constants.LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 " + Constants.LOTTO_PRICE + " 원 단위로 입력해 주세요.");
            }
            if(purchasePrice <= Constants.LOTTO_PRICE) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 " + Constants.LOTTO_PRICE + " 원 이상이어야 합니다.");
            }
            return purchasePrice;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력해 주세요.");
            return purchaseInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseInput();
        }
    }
}
