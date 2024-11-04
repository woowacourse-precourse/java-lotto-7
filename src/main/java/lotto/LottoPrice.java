package lotto;

public class LottoPrice {
    PrintManager printManager = new PrintManager();
    InputHandler inputHandler = new InputHandler();

    public int getLottoPrice () {
        while (true) {
            printManager.printPriceNotice();
            String inputPrice = inputHandler.getInput();
            if (NumberValidator.isValidPrice(inputPrice)) {
                return Integer.parseInt(inputPrice);
            }
        }
    }
}
