package lotto;

import static lotto.LottoRule.LOTTO_PRICE;
import static lotto.LottoRule.NUMBER_LENGTH;
import static lotto.LottoRule.RANGE_HIGH;
import static lotto.LottoRule.RANGE_LOW;

import java.util.ArrayList;
import java.util.List;

/**
 * InputHandler
 */
public abstract class InputHandler {

    public static int parsePurchaseAmount(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input);

            if (purchaseAmount % LOTTO_PRICE != 0) {
                String message = String.format("구입금액은 %,d원 단위여야 합니다.", LOTTO_PRICE);
                throw ExceptionBuilder.argumentException(message, input);
            }
            return purchaseAmount;

        } catch (NumberFormatException e) {
            throw ExceptionBuilder.argumentException("잘못된 금액 형식입니다.", input);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static List<Integer> parseWinningNumbers(String input) {
       try {
            List<Integer> winningNumbers = new ArrayList<>(NUMBER_LENGTH);
            String[] segments = input.split("\\s*,\\s*");

            if (segments.length != NUMBER_LENGTH) {
                String message = String.format("당첨 번호는 정확히 %d개여야 합니다.", NUMBER_LENGTH);
                throw ExceptionBuilder.argumentException(message, input);
            }

            boolean[] check = new boolean[RANGE_HIGH];

            for (String segment : segments) {
                int number = Integer.parseInt(segment);

                if (number < RANGE_LOW || number > RANGE_HIGH) {
                    String message = String.format("당첨 번호는 %d 부터 %d 사이여야 합니다. ", RANGE_LOW, RANGE_HIGH);
                    throw ExceptionBuilder.argumentException(message, input);
                }

                if (check[number])
                    throw ExceptionBuilder.argumentException("당첨 번호에 중복이 있으면 안됩니다.", input);

                check[number] = true;
                winningNumbers.add(number);
            }
            return winningNumbers;

       } catch (NumberFormatException e) {
            throw ExceptionBuilder.argumentException("잘못된 번호 형식입니다.", input);
       } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static int parseBonusNumber(String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            if (bonusNumber < RANGE_LOW || bonusNumber > RANGE_HIGH) {
                String message = String.format("당첨 번호는 %d 부터 %d 사이여야 합니다. ", RANGE_LOW, RANGE_HIGH);
                throw ExceptionBuilder.argumentException(message, input);
            }
            return bonusNumber;

        } catch (NumberFormatException e) {
            throw ExceptionBuilder.argumentException("잘못된 보너스 변호 형식입니다.", input);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

}
