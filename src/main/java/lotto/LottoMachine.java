package lotto;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoMachine {
    private final int PRICE_PER_LOTTO = 1000;
    private final Validation validation = new Validation(PRICE_PER_LOTTO);
    private final InputReader inputReader = new InputReader(validation);
    private final MatchCalculator matchCalculator = new MatchCalculator();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final ErrorHandler errorHandler = new ErrorHandler();

    private ArrayList<Lotto> lottos = new ArrayList<>();
    private Map<MatchCount, Integer> result = new HashMap<>();
    private Lotto winningLotto;
    private int bonusNumber;
    private int lottoPrice;
    private int numberOfTickets;

    public void run() {
        System.out.println("구입 금액을 입력해 주세요.");
        errorHandler.continueNotToCatchError(()->{
            lottoPrice = inputReader.readLottoPrice();
        });
        System.out.println(lottoPrice + "\n");

        numberOfTickets = calculateNumberOfTickets(lottoPrice);
        System.out.println(numberOfTickets + "개를 구매했습니다.");

        vendorTicket(numberOfTickets);

        System.out.println("당첨 번호를 입력해 주세요.");
        errorHandler.continueNotToCatchError(()->{
            winningLotto = inputReader.readWinningNumbers();
        });
        System.out.println(winningLotto.getNumbers()+"\n");

        System.out.println("보너스 번호를 입력해 주세요.");
        errorHandler.continueNotToCatchError(()->{
            bonusNumber = inputReader.readBonusNumber(winningLotto);
        });
        System.out.println(bonusNumber+"\n");

        System.out.println("당첨 통계\n---");
        showMatchResult();
        showYield();
    }

    private void showYield() {
        int winningMoney = 0;
        for(Map.Entry<MatchCount, Integer> entry : result.entrySet()){
           winningMoney += Integer.parseInt(entry.getKey().getMoney()) * entry.getValue();
        }
        double yield = matchCalculator.calculateYield(lottoPrice, winningMoney);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }

    private void showMatchResult() {
       for(Lotto lotto : lottos){
           MatchCount matchCount = matchCalculator.calculateMatchCount(winningLotto, lotto, bonusNumber);
           result.put(matchCount, result.getOrDefault(matchCount,0)+1);
       }
        System.out.println("3개 일치 (5,000원) - " + result.getOrDefault(MatchCount.THREE_MATCH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getOrDefault(MatchCount.FOUR_MATCH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getOrDefault(MatchCount.FIVE_MATCH, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getOrDefault(MatchCount.FIVE_MATCH_WITH_BONUS_NUMBER, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getOrDefault(MatchCount.SIX_MATCH, 0) + "개");
    }

    private void vendorTicket(int numberOfTickets) {
        for (int i = 0; i < numberOfTickets; ++i) {
            Lotto ticket = lottoGenerator.generateLotto();
            lottos.add(ticket);
            System.out.println(ticket.getNumbers());
        }
        System.out.println();
    }

    private int calculateNumberOfTickets(int totalPrice) {
        return totalPrice / PRICE_PER_LOTTO;
    }

}
