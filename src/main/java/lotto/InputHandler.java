package lotto;

import static lotto.LottoRule.LOTTO_PRICE;
import static lotto.LottoRule.RANGE_HIGH;
import static lotto.LottoRule.RANGE_LOW;

import java.util.ArrayList;
import java.util.List;

/**
 * InputHandler
 */
public class InputHandler {

    public int parsePurchaseAmount(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input);

            if (purchaseAmount % LOTTO_PRICE != 0)
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 합니다.");

            return purchaseAmount;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액 형식입니다.");
        }
    }

    public List<Integer> parseWinningNumbers(String input) {
       try {
            List<Integer> winningNumbers = new ArrayList<>(6);
            String[] segments = input.split(",");

            if (segments.length != 6)
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 정확히 6개여야 합니다. ");

            boolean[] check = new boolean[RANGE_HIGH];

            for (String segment : segments) {
                int number = Integer.parseInt(segment);

                if (number < RANGE_LOW || number > RANGE_HIGH)
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + RANGE_LOW + " 부터 " + RANGE_HIGH + " 사이여야 합니다.");

                if (check[number])
                    throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복이 있으면 안됩니다.");

                check[number] = true;
                winningNumbers.add(number);
            }

            return winningNumbers;
       } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 번호 형식입니다.");
       } 
    }

    public int parseBonusNumber(String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            if (bonusNumber < RANGE_LOW || bonusNumber > RANGE_HIGH)
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + RANGE_LOW + " 부터 " + RANGE_HIGH + " 사이여야 합니다.");

            return bonusNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 보너스 번호 형식입니다.");
        }
    }

    
}
