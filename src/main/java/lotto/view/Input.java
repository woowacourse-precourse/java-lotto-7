package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.contants.message.NoticeMessage;
import lotto.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class Input {
    InputValidator inputVaildator;

    public Input() {
        inputVaildator = new InputValidator();
    }

    public int payment() {
        System.out.println(NoticeMessage.PAYMENT.getMessage());

        String payment = Console.readLine();
        while (!inputVaildator.payment(payment)) {
            payment = Console.readLine();
        }

        return Integer.parseInt(payment);
    }

    public List<Integer> prizeNumbers() {
        System.out.println(NoticeMessage.PRIZE_NUMBER.getMessage());

        String prizeNumbers = Console.readLine();
        String[] splitPrizeNumbers = prizeNumbers.split(",");

        while (!inputVaildator.prizeNumber(splitPrizeNumbers)) {
            prizeNumbers = Console.readLine();
            splitPrizeNumbers = prizeNumbers.split(",");
        }

        return convertToPrizeNumbers(splitPrizeNumbers);
    }

    public List<Integer> convertToPrizeNumbers(String[] splitPrizeNumbers) {
        List<Integer> winningNumberValues = new ArrayList<>();
        for (String str : splitPrizeNumbers) {
            winningNumberValues.add(Integer.parseInt(str));
        }

        return winningNumberValues;
    }

    public int bonusNumber(List<Integer> prizeNumbers) {
        System.out.println(NoticeMessage.BONUS_NUMBER.getMessage());
        String bonusNumber = Console.readLine();

        while (!inputVaildator.bonusNumber(prizeNumbers, bonusNumber)) {
            bonusNumber = Console.readLine();
        }

        return Integer.parseInt(bonusNumber);
    }

}
