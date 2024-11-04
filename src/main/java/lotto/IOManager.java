package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IOManager {
    RandomLotto randomLotto = RandomLotto.getInstance();

    public int moneyInput() {
        printL("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int money = integerParser(input);
        randomLotto.countCalculator(money);
        return money;
    }

    public List<Integer> numbersInput() {
        printL("당첨 번호를 입력해 주세요.");
        String[] numbersString = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : numbersString) {
            int numberInt = integerParser(number.trim());
            winningNumbers.add(numberInt);
        }

        return winningNumbers;
    }

    public int bonusInput() {
        printL("보너스 번호를 입력해 주세요.");
        return integerParser(Console.readLine());
    }

    public void printNewLotto(int cnt, List<List<Integer>> lottos) {
        if (cnt != lottos.size()) {
            throw new IllegalArgumentException("[ERROR] 구매한 로또의 갯수와 생성된 로또의 갯수가 다릅니다.");
        }
        printL(cnt + "개를 구매했습니다.");
        for (List<Integer> lotto : lottos) {
            printLottoLine(lotto);
        }
    }

    public void printLottoLine(List<Integer> lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < lotto.size(); i++) {
            sb.append(lotto.get(i));
            if (i < lotto.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        printL(sb.toString());
    }

    public void printPrizeCount(double rate) {
        printL("당첨 통계");
        printL("---");
        Map<Prise, Integer> prizeCount = randomLotto.getPrizeCount();
        for (Prise prize : Prise.values()) {
            String message = messageBuilder(prize);
            printL(message + prizeCount.get(prize) + "개");
        }
        printL("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
    }

    public String messageBuilder(Prise prize) {
        StringBuilder sb = new StringBuilder();
        sb.append(prize.getMatch());
        sb.append("개 일치");
        if (prize == Prise.SECOND) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" ");
        sb.append(prize.getMoneyString());
        sb.append(" - ");
        return sb.toString();
    }

    public void printL(String message) {
        System.out.println(message);
    }

    public int integerParser(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 있습니다.");
        }
    }
}
