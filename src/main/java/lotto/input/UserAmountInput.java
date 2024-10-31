package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class UserAmountInput {
    private int amount;
    private static final int TICKET_PRICE = 1000;

    public int validation() {
        while (true) {
            try {
                amount = parseInput(getInput());
                validate(amount);
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

    private int parseInput(String amountInput) {
        return Integer.parseInt(amountInput.trim().replaceAll("\\s*,\\s*", ""));
    }

    private void validate(int amount) {
        if (amount <= 0 || amount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 천 원단위의 양수여야 합니다.");
        }
    }
}