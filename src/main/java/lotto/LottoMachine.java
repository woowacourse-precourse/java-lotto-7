package lotto;

public class LottoMachine {
    public static void initData() {
        Data data = new Data();
        initAmount(data);
    }

    private static void initAmount(Data data) {
        Printer.printMessage(Constants.INFORM_INPUT_AMOUNT);
        try {
            int amount = Parser.parseAmount(Reader.readInput());
            data.setAmountAndTicketNum(amount);
            Printer.printMessage(data.getTicketNum() + Constants.INFORM_TICKET_NUMS);
        } catch (IllegalArgumentException e) {
            initAmount(data);
        }
    }
}