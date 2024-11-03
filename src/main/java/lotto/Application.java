package lotto;

import java.util.List;

public class Application {
    private InputHandler inputHandler;
    private LottoGenerator lottoGenerator;
    private List<Lotto> lottoTickets;

    public Application() {
        inputHandler = new InputHandler();
        lottoGenerator = new LottoGenerator();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        int price = inputHandler.priceInput();
        int purchasedLottoCount = price / 1000;
        System.out.println(purchasedLottoCount + "개를 구매했습니다.");

        lottoTickets = lottoGenerator.generate(purchasedLottoCount);
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
        List<Integer> winningNumbers = inputHandler.winningNumbersInput();
        int bonusNumber = inputHandler.bonusNumberInput();
    }
}
