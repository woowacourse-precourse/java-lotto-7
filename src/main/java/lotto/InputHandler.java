package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private static final String PROMPT_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String PROMPT_WINNING = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS = "보너스 번호를 입력해 주세요.";

    public Payment getPayment() {
        Payment payment = null;
        while (payment == null) {
            System.out.println(PROMPT_PAYMENT);
            String input = Console.readLine();
            try {
                payment = Payment.from(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return payment;
    }

    public Winning getWinning() {
        Winning winning = null;
        while (winning == null) {
            System.out.println(PROMPT_WINNING);
            String input = Console.readLine();
            try {
                winning = Winning.from(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winning;
    }

    public Bonus getBonus(Winning winning) {
        Bonus bonus = null;
        while (bonus == null) {
            System.out.println(PROMPT_BONUS);
            String input = Console.readLine();
            try {
                bonus = Bonus.from(input);
                bonus.isDuplicated(winning);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonus;
    }
}
