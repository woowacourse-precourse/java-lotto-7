package lotto;

import java.util.List;
import java.util.ArrayList;

public class LottoMachine {
    private Data data;

    public LottoMachine() {
        this.data = new Data();
    }

    public void runMachine() {
        initAmount();
        issueLottoTickets();
        initUserPick();
    }

    public Data getData() { return data; }

    private void initAmount() {
        Printer.printMessage(Constants.INFORM_INPUT_AMOUNT);
        try {
            int amount = Parser.parseAmount(Reader.readInput());
            data.setAmountAndTicketNumber(amount);
            Printer.printMessage(data.getTicketNumber() + Constants.INFORM_TICKET_NUMBERS);
        } catch (IllegalArgumentException e) {
            initAmount();
        }
    }

    private void issueLottoTickets() {
        for (int i = 0; i < data.getTicketNumber(); i++) {
            Lotto newTicket = new Lotto(RandomPicker.pickLottoNumbers());
            data.addLottoTicket(newTicket);
            Printer.printIssueResult(newTicket);
        }
    }

    private void initUserPick() {
        ArrayList<Integer> numbers = initUserPickNumbers();
        UserPick userPick = new UserPick(numbers, 1);
        data.setUserPick(userPick);
    }

    private ArrayList<Integer> initUserPickNumbers() {
        Printer.printMessage(Constants.INFORM_INPUT_USER_PICK_NUMBERS);
        ArrayList<Integer> numbers;
        try {
            numbers = Parser.parseUserPickNumbers(Reader.readInput());
        } catch (IllegalArgumentException e) {
            numbers = initUserPickNumbers();
        }
        return numbers;
    }
}