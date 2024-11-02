package lotto;

public class Application {
    public static void main(String[] args) {
        PrintManager printManager = new PrintManager();
        InputHandler inputHandler = new InputHandler();
       
        int lottoPrice = processPrice(printManager, inputHandler);
 
    }

    public static int processPrice(PrintManager printManager, InputHandler inputHandler) {
        while (true) {
            printManager.printPriceNotice();
            String inputPrice = inputHandler.getInput();
            if (inputHandler.isValidInt(inputPrice)) {
                return Integer.parseInt(inputPrice);
            }
        }
    }
}
