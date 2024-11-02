package lotto;

import java.util.List;

public class LottoMachine {
    private Data data;

    public LottoMachine() {
        this.data = new Data();
    }

    public void runMachine() {
        initData();
        issueLottoTickets();
    }

    private void initData() {
        initAmount();
    }

    private void initAmount() {
        Printer.printMessage(Constants.INFORM_INPUT_AMOUNT);
        try {
            int amount = Parser.parseAmount(Reader.readInput());
            data.setAmountAndTicketNum(amount);
            Printer.printMessage(data.getTicketNum() + Constants.INFORM_TICKET_NUMS);
        } catch (IllegalArgumentException e) {
            initAmount();
        }
    }

    private void issueLottoTickets() {
        for (int i = 0; i < data.getTicketNum(); i++) {
            Lotto newTicket = new Lotto(RandomPicker.pickLottoNumbers());
            data.addLottoTicket(newTicket);
            Printer.printIssueResult(newTicket);
        }
    }
}