package lotto;

import java.util.List;

public class IOHandler {
    InputHandler inputHandler = new InputHandler();
    OutputHandler outputHandler = new OutputHandler();

    public int getPayment() {
        while (true) {
            try {
                outputHandler.showCommentForPaymentInput();
                int payment = inputHandler.getPaymentInput();

                outputHandler.showBlankLine();
                return payment;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입금액은 1000의 배수여야 합니다.");
            }
        }
    }

    public void showGeneratedTickets(LottoTickets tickets) {
        List<LottoTicket> ticketList = tickets.getTickets();
        outputHandler.showTicketsOf(ticketList);
    }


    public List<Integer> getLottoNumber() {
        while (true) {
            try {
                outputHandler.showCommentForLottoNumberInput();
                List<Integer> lottoNumber = inputHandler.getLottoNumberInput();

                outputHandler.showBlankLine();
                return lottoNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 공백 문자가 없고 쉼표로 구분된 6개의 숫자여야 합니다.");
            }
        }
    }

    public int getBonusNumber(List<Integer> numbers) {
        while (true) {
            try {
                outputHandler.showCommentForBonusNumberInput();
                int bonusNumber = inputHandler.getBonusNumberInput(numbers);

                outputHandler.showBlankLine();
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호는 로또 번호에 없는 1 ~ 45 까지의 숫자 중 하나여야 합니다.");
            }
        }
    }

    public void showLottoResult(LottoTickets tickets) {
        outputHandler.showLottoResultSummary(tickets);
    }
}
