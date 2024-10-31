package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.PrintTicketCount;

public class UserAmountInput {
    private int amount;
    private int lottoTicketCount;
    private final int TICKET_PRICE = 1000;

    public void userAmountInput() {
        while (true) {
            try {
                getInputAndParse();
                validate();
                lottoTicketCount = setLottoTicketCount();
                System.out.println();
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력이 잘못되었습니다. 로또 구입 금액은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public PrintTicketCount createPrintTicket() {
        return new PrintTicketCount(lottoTicketCount);
    }

    public void printEarningsRate(double earnings) {
        double earningsRate = ((earnings / amount) * 100);
        System.out.printf("총 수익률은 %.1f%%입니다.", earningsRate);
    }

    private void getInputAndParse() {
        String amountInput = userInput();
        amount = parseAmount(amountInput);
    }

    private String userInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private int parseAmount(String amountInput) {
        return Integer.parseInt(amountInput.trim().replaceAll("\\s*,\\s*", ""));
    }

    private void validate() {
        if (amount <= 0 || amount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 입력이 잘못되었습니다. 로또 구입 금액은 천 원단위의 양수여야 합니다.");
        }
    }

    private int setLottoTicketCount() {
        return amount / TICKET_PRICE;
    }
}


