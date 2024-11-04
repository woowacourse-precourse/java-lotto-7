package lotto;

import java.util.ArrayList;

public class LottoMachine {
    private Data data;

    public LottoMachine() {
        this.data = new Data();
    }

    public void runMachine() {
        initAmountAndTicketNumber();
        issueLottoTickets();
        initUserPick();
        ResultCalculator.calculateResult(data);
        Printer.printCalculateResult(data);
    }

    public Data getData() { return data; }

    private void initAmountAndTicketNumber() {
        int amount = getAmount();
        data.setAmountAndTicketNumber(amount);
        Printer.printMessage(data.getTicketNumber() + Constants.INFORM_TICKET_NUMBERS);
    }

    private int getAmount() {
        while (true) {
            Printer.printMessage(Constants.INFORM_INPUT_AMOUNT);
            try {
                return Parser.parseAmount(Reader.readInput());
            } catch (IllegalArgumentException e) {
                Printer.printErrorMessage(e.getMessage());
            }
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
        ArrayList<Integer> numbers = getUserPickNumbers();
        int bonus = getUserPickBonus(numbers);
        UserPick userPick = new UserPick(numbers, bonus);
        data.setUserPick(userPick);
    }

    private ArrayList<Integer> getUserPickNumbers() {
        while (true) {
            Printer.printMessage(Constants.INFORM_INPUT_USER_PICK_NUMBERS);
            try {
                return Parser.parseUserPickNumbers(Reader.readInput());
            } catch (IllegalArgumentException e) {
                Printer.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getUserPickBonus(ArrayList<Integer> numbers) {
        while (true) {
            Printer.printMessage(Constants.INFORM_INPUT_USER_PICK_BONUS);
            try {
                return Parser.parseUserPickBonus(Reader.readInput(), numbers);
            } catch (IllegalArgumentException e) {
                Printer.printErrorMessage(e.getMessage());
            }
        }
    }
}