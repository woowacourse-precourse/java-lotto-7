package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class UserAmountInput {
    private int amount;
    private static final int TICKET_PRICE = 1000;

    public int validation() {
        while (true) {
            try {
                long input = parseInput(getInput());
                validate(input);
                System.out.println();

                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getLottoTicketCount() {
        return amount / TICKET_PRICE;
    }

    private String getInput() {
        System.out.println("구입금액을 입력해 주세요.");

        return Console.readLine();
    }

    private Long parseInput(String amountInput) {
        return Long.parseLong(amountInput.trim().replaceAll("\\s*,\\s*", ""));
    }

    private void validate(long input) {

        amount = maxValueValidate(input);
        unitValidate(amount);

    }

    private int maxValueValidate(long input) {
        if (input > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 너무 큽니다. 최대 값은 2,147,483,647입니다.");
        }

        return (int) input;
    }

    private void unitValidate(int amount) {
        if (amount <= 0 || amount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 천 원단위의 양수여야 합니다.");
        }
    }
}
