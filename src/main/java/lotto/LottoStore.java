package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_PRICE = 1_000;

    public void run() {
        int amount = inputAmount();
        List<Lotto> lottoList = buyLotto(amount);

        WinningNumber winningNumber = new WinningNumber();
        winningNumber.inputWinningNumber();
        winningNumber.inputBonusNumber();

        LottoDraw lottoDraw = new LottoDraw();
        lottoList.forEach(lotto -> lottoDraw.countWinningResult(lotto, winningNumber));
        lottoDraw.printResults(amount);
    }

    public int inputAmount() {
        while(true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String input = Console.readLine();
                int amount = parseAmount(input);
                validateAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseAmount(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액 입력이 잘못되었습니다.");
        }
    }

    private void validateAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public List<Lotto> buyLotto(int amount) {
        int ticketCount = amount / LOTTO_PRICE;
        List<Lotto> lottos = generateLotto(ticketCount);
        printPurchaseResult(ticketCount, lottos);
        return lottos;
    }

    private List<Lotto> generateLotto(int ticketCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
        }
        return lottoList;
    }

    private void printPurchaseResult(int ticketCount, List<Lotto> lottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", ticketCount);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}