package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private InputHandler inputHandler;
    private LottoGenerator lottoGenerator;
    private List<Lotto> lottoTickets;
    private LottoResult lottoResult;

    public Application() {
        inputHandler = new InputHandler();
        lottoGenerator = new LottoGenerator();
        lottoResult = new LottoResult();
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
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<Rank,Integer> result = lottoResult.getFinalResult(lottoTickets,winningNumbers,bonusNumber);
        for(Rank rank : Rank.values()){
            if (rank==Rank.NONE){
                continue;
            }
            if (rank==Rank.SECOND){
                System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개",rank.getNumberMatch(),rank.getPrize(),result.get(rank));
                System.out.println();
                continue;
            }
            System.out.printf("%d개 일치 (%d원) - %d개",rank.getNumberMatch(),rank.getPrize(),result.get(rank));
            System.out.println();
        }
        System.out.printf("총 수익률은 %.1f%%입니다.",lottoResult.getRateOfReturn(result,price));
    }
}
