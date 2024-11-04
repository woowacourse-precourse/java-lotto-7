package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.lottery.Bonus;
import lotto.model.lottery.PurchasedLotto;
import lotto.model.payment.Payment;
import lotto.model.lottery.Winning;
import lotto.model.result.Result;
import lotto.model.result.ReturnRate;
import lotto.view.View;

public class Controller {
    private static final String PROMPT_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String PROMPT_WINNING = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS = "보너스 번호를 입력해 주세요.";

    private final View view;

    public Controller() {
        this.view = new View();
    }

    public void run() {
        Payment payment = getPayment();
        PurchasedLotto purchasedLotto = PurchasedLotto.from(payment);
        view.show(purchasedLotto);

        Winning winning = getWinning();
        Bonus bonus = getBonus(winning);

        Result result = Result.from(winning, bonus, purchasedLotto);
        view.show(result);

        ReturnRate returnRate = ReturnRate.from(result, payment);
        view.show(returnRate);
    }

    public Payment getPayment() {
        Payment payment = null;
        while (payment == null) {
            view.show(PROMPT_PAYMENT);
            String input = Console.readLine();
            try {
                payment = Payment.from(input);
                view.printLine();
            } catch (IllegalArgumentException e) {
                view.show(e.getMessage());
            }
        }
        return payment;
    }

    public Winning getWinning() {
        Winning winning = null;
        while (winning == null) {
            view.show(PROMPT_WINNING);
            String input = Console.readLine();
            try {
                winning = Winning.from(input);
                view.printLine();
            } catch (IllegalArgumentException e) {
                view.show(e.getMessage());
            }
        }
        return winning;
    }

    public Bonus getBonus(Winning winning) {
        Bonus bonus = null;
        while (bonus == null) {
            view.show(PROMPT_BONUS);
            String input = Console.readLine();
            try {
                bonus = Bonus.from(input);
                bonus.isDuplicated(winning);
                view.printLine();
            } catch (IllegalArgumentException e) {
                view.show(e.getMessage());
            }
        }
        return bonus;
    }
}
