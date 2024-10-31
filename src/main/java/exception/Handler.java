package exception;

public class Handler {
    public static int getMoney(io.Input input) {
        String inputString = input.getInput();
        int money = 1;

        try {
            money = Integer.parseInt(inputString);
        } catch (IllegalArgumentException ex) {
            //get Lotto Number에서 처리
        }
        return money;
    }

    private static boolean moneyIsValid(int money) {
        if (money % 1000 != 0) {
            Message message = new Message(Integer.toString(money));
            String exceptionMessage = message.getMessage(Message.INVALID_MONEY);
            throw new IllegalArgumentException(exceptionMessage);
        }
        return true;
    }

    public static int getLottoNumber() {
        int money = 0;
        boolean validity = false;

        while (!validity) {
            io.Input input = new io.Input();
            String inputString = input.getInput();
            try {
                money = exception.Handler.getMoney(input);
                validity = moneyIsValid(money);
            } catch (IllegalArgumentException ex) {
                exception.Handler.handleException(inputString);

            }

        }
        return money / 1000;
    }

    static void handleException(String inputString) {
        exception.Message message = new exception.Message(inputString);
        String exceptionMessage = message.getMessage(Message.INVALID_MONEY);
        io.Print printMessage = new io.Print(exceptionMessage);
        printMessage.print();
    }

}
