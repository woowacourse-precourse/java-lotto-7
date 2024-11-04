package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.input.BonusNumber;
import lotto.input.Cost;
import lotto.input.Input;
import lotto.input.WinningNumber;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LottoExecutor {

    private final Cost cost;
    private final WinningNumber winningNumber;
    private BonusNumber bonusNumber;
    private final List<Lotto> lottoList;

    public LottoExecutor() {
        this.cost = new Cost();
        this.winningNumber = new WinningNumber();
        this.lottoList = new ArrayList<>();
    }

    public void run() {
        inputValues();
        printStatus();
    }

    private void inputValues() {
        System.out.println("구입금액을 입력해 주세요.");
        validateInput(cost);
        System.out.println("\n" + (cost.getCost() / 1000) + "개를 구매했습니다.");
        publishLotto(cost.getCost(), lottoList);

        System.out.println("당첨 번호를 입력해 주세요.");
        validateInput(winningNumber);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonusNumber = new BonusNumber(winningNumber.getLotto().getNumbers());
        validateInput(bonusNumber);
    }

    private void printStatus() {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        DecimalFormat formatter = new DecimalFormat("#,###");
        WinningStatus winningStatus = new WinningStatus(winningNumber, bonusNumber);

        winningStatus.matchLotto(lottoList);
        sb.append("\n당첨 통계\n---\n");

        for (Match match : Match.values()) {
            sb.append(match.matchToString(formatter)).append("\n");
            sum += (match.getValue() * match.getCount());
        }
        sb.append("총 수익률은 ").append(String.format("%.1f%%입니다.", calculateRate(sum, cost)));
        System.out.println(sb);
    }

    private double calculateRate(int sum, Cost cost) {
        return (double) sum / cost.getCost() * 100;
    }

    private void publishLotto(int cost, List<Lotto> lottoList) {
        StringBuilder sb = new StringBuilder();
        int count = cost / 1000;

        for (int i = 0; i < count; i++) {
            List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(list));
            printLotto(lottoList.get(i).getNumbers(), sb);
        }

        System.out.println(sb);
    }

    private void printLotto(List<Integer> list, StringBuilder sb) {
        sb.append("[");

        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i)).append(", ");
        }
        sb.append(list.getLast()).append("]\n");
    }

    private void validateInput(Input input) {

        boolean success = false;

        while (!success) {
            try {
                input.validate(Console.readLine());
                success = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
