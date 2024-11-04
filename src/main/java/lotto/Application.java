package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Application {
    static final String DATANAME_AMOUNT = "구입금액을";
    static final String DATANAME_WINNINGNUM = "당첨 번호를";
    static final String DATANAME_BONUSNUM = "보너스 번호를";

    static InputHandler inputHandler = new InputHandler();

    public static void main(String[] args) {
        String purchasePrice = inputHandler.inputData(DATANAME_AMOUNT);

        LottoGenerator lottoGenerator = new LottoGenerator(Integer.parseInt(purchasePrice));

        String winningNumbers = inputHandler.inputData(DATANAME_WINNINGNUM);
        String bonusNumber = inputHandler.inputData(DATANAME_BONUSNUM);

        new LottoAnalyzer(lottoGenerator.getLottoList(),
                Arrays.stream(winningNumbers.split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray(),
                Integer.parseInt(bonusNumber),
                Integer.parseInt(purchasePrice));
    }
}

class InputHandler {
    final String REQUEST_MESSAGE = " 입력해 주세요.";
    final String INPUT_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n";

    public String inputData(String dataName) {
        String input = null;
        while (true) {
            try {
                System.out.println();
                System.out.println(dataName + REQUEST_MESSAGE);
                input = camp.nextstep.edu.missionutils.Console.readLine();
                checkValidate(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(INPUT_ERROR_MESSAGE);
            }
        }
        return input;
    }

    private void checkValidate(String inputNumber) {
        String regex = "^(?:([1-9]|[1-3][0-9]|4[0-5])(,(?!$)|$))*$";

        if (!inputNumber.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}

class LottoGenerator {
    final int LOTTO_PRICE = 1000;
    final String PURCHASE_MASSAGE = "개를 구매했습니다.";

    private List<Lotto> lottoList = new ArrayList<>();
    private int purchaseAmount = 0;

    public LottoGenerator(int price) {
        this.purchaseAmount = calculateTickets(price);
        generateLotto(calculateTickets(price));
        printLottoList();
    }

    private int calculateTickets(int price) {
        return price / LOTTO_PRICE;
    }

    private void generateLotto(int tickets) {
        int count = 0;
        while(count < tickets) {
            lottoList.add(new Lotto());
            count++;
        }
    }

    private void printLottoList() {
        System.out.println();
        System.out.println(purchaseAmount + PURCHASE_MASSAGE);
        for (Lotto lotto : lottoList) {
            lotto.printLotto();
        }
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }
}

class LottoAnalyzer{
    private final HashMap<Prize, Integer> statistics = new HashMap<>();
    private int returnAmount = 0;

    public LottoAnalyzer(List<Lotto> lottoList, int[] winningNumbers, int bonusNumber, int purchaseAmount) {
        calculateStatistics(lottoList, winningNumbers, bonusNumber);
        calculateReturn(purchaseAmount);
        printResults();
    }

    private void calculateStatistics(List<Lotto> lottoList, int[] winningNumbers, int bonusNumber) {
        for(Lotto lotto : lottoList) {
            int count = lotto.countMatchNumbers(winningNumbers);
            if (count == 3) {
                statistics.put(Prize.THREE_MATCH, statistics.getOrDefault(Prize.THREE_MATCH, 0) + 1);
            }
            if (count == 4) {
                statistics.put(Prize.FOUR_MATCH, statistics.getOrDefault(Prize.FOUR_MATCH, 0) + 1);
            }
            if (count == 5 && !lotto.containBonusNumber(bonusNumber)) {
                statistics.put(Prize.FIVE_MATCH, statistics.getOrDefault(Prize.FIVE_MATCH, 0) + 1);
            }
            if (count == 5 && lotto.containBonusNumber(bonusNumber)) {
                statistics.put(Prize.FIVE_MATCH_BONUS, statistics.getOrDefault(Prize.FIVE_MATCH_BONUS, 0) + 1);
            }
            if (count == 6) {
                statistics.put(Prize.SIX_MATCH, statistics.getOrDefault(Prize.SIX_MATCH, 0) + 1);
            }
        }
    }

    private void calculateReturn(int purchaseAmount) {
        int sum = 0;
        for (Prize prize : Prize.values()) {
            sum += prize.getPrizePrice() * statistics.getOrDefault(prize, 0);
        }
        this.returnAmount = (sum - purchaseAmount) / purchaseAmount * 100;
    }

    private void printResults() {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---");

        for (Prize prize : Prize.values()) {
            System.out.println(prize.getCount() + "개 일치 (" + prize.getPrizePrice() + ") - " + statistics.getOrDefault(prize, 0));
        }

        System.out.println(" 총 수익률은 " + returnAmount + "%입니다.");
    }

    public HashMap<Prize, Integer> getStatistics() {
        return statistics;
    }
}

enum Prize {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_BONUS(5, 30000000),
    SIX_MATCH(6, 200000000);

    private final int prizePrice;
    private final int count;

    Prize(int count, int prizePrice) {
        this.prizePrice = prizePrice;
        this.count = count;
    }

    public int getPrizePrice() {
        return prizePrice;
    }

    public int getCount() {
        return count;
    }
}