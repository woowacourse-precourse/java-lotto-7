package lotto.view;

import lotto.constant.LottoGuideMessage;
import lotto.dto.LottoIssueCount;
import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidPriceException;

public class LottoIO {
    public static LottoIssueCount getIssueCount() {
        System.out.println(LottoGuideMessage.GUIDE_MESSAGE_A);
        String userInput = Console.readLine();
        int price = Integer.parseInt(userInput);

        try {
            validatePrice(price);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getIssueCount();
        }

        return new LottoIssueCount(price);
    }

    private static boolean validatePrice(int price) throws IllegalArgumentException {
        if (price % 1000 > 0) {
            throw new InvalidPriceException();
        }

        return true;
    }
}