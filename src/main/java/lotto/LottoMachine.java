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
        ResultCalculator.calculateResult(data);
        Printer.printCalculateResult(data);
    }

    public Data getData() { return data; }

    private void initAmount() {
        while (true) {
            Printer.printMessage(Constants.INFORM_INPUT_AMOUNT);
            try {
                int amount = Parser.parseAmount(Reader.readInput());
                data.setAmountAndTicketNumber(amount);
                Printer.printMessage(data.getTicketNumber() + Constants.INFORM_TICKET_NUMBERS);
                break;
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
        ArrayList<Integer> numbers = initUserPickNumbers();
        int bonus = initUserPickBonus(numbers);
        UserPick userPick = new UserPick(numbers, bonus);
        data.setUserPick(userPick);
    }

    private ArrayList<Integer> initUserPickNumbers() {
        ArrayList<Integer> numbers;
        while (true) {
            Printer.printMessage(Constants.INFORM_INPUT_USER_PICK_NUMBERS);
            try {
                numbers = Parser.parseUserPickNumbers(Reader.readInput());
                break;
            } catch (IllegalArgumentException e) {
                Printer.printErrorMessage(e.getMessage());
            }
        }
        return numbers;
    }

    private int initUserPickBonus(ArrayList<Integer> numbers) {
        int bonus = 0;
        while (true) {
            Printer.printMessage(Constants.INFORM_INPUT_USER_PICK_BONUS);
            try {
                bonus = Parser.parseUserPickBonus(Reader.readInput(), numbers);
                break;
            } catch (IllegalArgumentException e) {
                Printer.printErrorMessage(e.getMessage());
            }
        }
        return bonus;
    }
}