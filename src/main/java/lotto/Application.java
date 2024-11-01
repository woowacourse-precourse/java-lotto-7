package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입급액을 입력해 주세요.");
        int purchaseAmount = 0;
        try {
            purchaseAmount = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액 형식입니다.");
        }

        final int LOTTO_PRICE = 1000;
        if (purchaseAmount % LOTTO_PRICE != 0)
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 합니다.");
        int lottoAmount = purchaseAmount / LOTTO_PRICE;

        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottoAmount);
        List<Lotto> lottos = new ArrayList<>(lottoAmount);
        LottoMachine machine = new LottoMachine();
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(machine.issue());
        }

        for (Lotto lotto : lottos) {
            System.out.println(lotto.describe());
        }

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumberInput = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>(6);
        String[] segments = winningNumberInput.split(",");
        for (String segment : segments) {
            winningNumbers.add(Integer.parseInt(segment));
        }

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        // calculate prize
        int[] winningCount = new int[6];
        int[] winningPrizeTable = {
            0,
            2_000_000_000,
            30_000_000,
            1_500_000,
            50_000,
            5_000
        };
        String[] winningPlaceDescriptionFormats = {
            "",
            "6개 일치 (2,000,000,000원) - %d개\n",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
            "5개 일치 (1,500,000원) - %d개\n",
            "4개 일치 (50,000원) - %d개\n",
            "3개 일치 (5,000원) - %d개\n",
        };
        for (Lotto lotto : lottos) {
            int place = lotto.getPlace(winningNumbers, bonusNumber);
            winningCount[place] += 1;
        }
        int totalPrize = 0;
        for (int i = 1; i < 6; i++) {
            totalPrize += winningCount[i] * winningPrizeTable[i];
        }
        float rateOfReturn = ((float)totalPrize / purchaseAmount) * 100;

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 5; i > 0; i--) {
            System.out.printf(winningPlaceDescriptionFormats[i], winningCount[i]);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}
