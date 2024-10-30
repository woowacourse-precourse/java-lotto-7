package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserAmountInput {
    private String amountInput;
    private int amount;
    private int lottoTicketCount;

    public void userAmountInput() {
        while (true) {
            try {
                userInput();
                parseAmount();
                validate();
                setLottoTicketCount();
                break;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 입력이 잘못되었습니다. 로또 구입 금액은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public PrintTicketCount createPrintTicket() {
        return new PrintTicketCount(lottoTicketCount);
    }

    private void userInput() {
        System.out.println("구입금액을 입력해 주세요.");
        amountInput = Console.readLine();
    }

    private void parseAmount() {
        amount = Integer.parseInt(amountInput.trim().replaceAll("\\s*,\\s*", ""));
    }

    private void validate() {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력이 잘못되었습니다. 로또 구입 금액은 천 원단위의 양수여야 합니다.");
        }
    }

    private void setLottoTicketCount() {
        lottoTicketCount = amount / 1000;
    }
}


