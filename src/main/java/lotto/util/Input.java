package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.enumValue.CommonMessage;
import lotto.validation.BonusNumberValidation;
import lotto.validation.CommonValidation;
import lotto.validation.WinningNumberValidation;
import lotto.validation.MoneyValidation;

import java.util.List;

public class Input {
    public static int moneyTicket() {
        while (true) {
            System.out.println(CommonMessage.INPUT_MONEY.getMessange());
            try {
                int money = CommonValidation.isIntegerType(CommonValidation.isEmpty(Console.readLine()));
                MoneyValidation.isPositiveNumber(money);
                MoneyValidation.divide1000(money);
                int ticketNumber = money / 1000;
                Output.printTicketNumber(ticketNumber);

                return ticketNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> winningNumbers() {
        while (true) {
            System.out.println(CommonMessage.INPUT_WINNING_NUMBER.getMessange());
            try {
                List<Integer> lottoNumbers = WinningNumberValidation.isIntegerType(CommonValidation.isEmpty(Console.readLine()).split(","));
                WinningNumberValidation.number6(lottoNumbers);
                WinningNumberValidation.value1to45(lottoNumbers);
                WinningNumberValidation.duplicateChecker(lottoNumbers);

                return lottoNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int bonusNumber(List<Integer> winningNumbers) {
        while (true) {
            System.out.println(CommonMessage.INPUT_BONUS_NUMBER.getMessange());
            try {
                int bonusNumber = CommonValidation.isIntegerType(CommonValidation.isEmpty(Console.readLine()));
                BonusNumberValidation.duplicateChecker(bonusNumber, winningNumbers);
                CommonValidation.value1to45(bonusNumber);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
