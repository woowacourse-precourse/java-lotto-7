package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.util.WinningResult;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public void run() {
        try {
            // 구매 금액 입력
            System.out.println("구입금액을 입력해 주세요.");
            int purchaseAmount = Integer.parseInt(readLine());

            // 로또 구매
            List<Lotto> lottos = lottoService.buyLotto(purchaseAmount);
            System.out.println(lottos.size() + "개를 구매했습니다.");
            lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));

            // 당첨 번호 입력
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String winningInput = readLine();
            Lotto winningLotto = lottoService.parseWinningNumbers(winningInput);

            // 보너스 번호 입력
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = Integer.parseInt(readLine());

            // 당첨 결과 계산 및 출력
            WinningResult result = lottoService.checkWinningResults(winningLotto, bonusNumber);
            System.out.println(result.generateWinningStatistics());

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]"+e.getMessage());
        }
    }
}
