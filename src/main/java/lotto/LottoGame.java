package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoGame {
    public void start() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());

        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.buyLottos(amount);
        printLottos(lottos);

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = parseInput(Console.readLine());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber, lottos);
        lottoResult.printResult();
    }

    private List<Integer> parseInput(String input) {
        return List.of(input.split(","))
                .stream()
                .map(Integer::parseInt)
                .toList();
    }

    private void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
