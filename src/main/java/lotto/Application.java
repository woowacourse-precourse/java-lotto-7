package lotto;

public class Application {
    public static void main(String[] args) {
        io.Print printMessage = new io.Print(io.Print.MONEY_INPUT_MESSAGE);
        printMessage.print();
        int lottoNumber = exception.Handler.getLottoNumber();

        printMessage = new io.Print(lottoNumber + io.Print.NUMBER_PRINT_MESSAGE);
        printMessage.print();
    }
}
