package lotto;

import java.util.HashMap;
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
        System.out.println("구입금액을 입력해 주세요.");
        int price = inputHandler.priceInput();
        int purchasedLottoCount = price / 1000;
        System.out.println(purchasedLottoCount + "개를 구매했습니다.");

        lottoTickets = lottoGenerator.generate(purchasedLottoCount);
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = inputHandler.winningNumbersInput();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = inputHandler.bonusNumberInput(winningNumbers);
    }
}
