package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.generator.RandomIntegerListGenerator;
import lotto.domain.lotto.Investment;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoResult;
import lotto.domain.lotto.Rank;
import lotto.domain.lotto.WinningNumbers;
import lotto.domain.sorting.AscendingSorter;

public class LottoController {

    public void run() {

        System.out.println("구입 금액을 입력해 주세요.");

        int cost = Integer.parseInt(Console.readLine());

        Investment investment = new Investment(BigInteger.valueOf(cost));

        int lottoQuantity = investment.getQuantity();
        System.out.println();
        System.out.println(lottoQuantity + "개를 구매했습니다.");

        LottoBundle lottoBundle = new LottoBundle(new ArrayList<>(), new RandomIntegerListGenerator(),
                new AscendingSorter());

        lottoBundle.generate(lottoQuantity);

        for (Lotto lotto : lottoBundle.getLottoBundle()) {
            System.out.print("[");
            System.out.print(lotto);
            System.out.println("]");
        }

        System.out.println();

        System.out.println("당첨번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] splitInput = input.split(",");
        List<LottoNumber> preWinningNumbers = new ArrayList<>();
        for (String splitNumber : splitInput) {
            preWinningNumbers.add(new LottoNumber(Integer.parseInt(splitNumber)));
        }

        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        LottoNumber bonusNumber = new LottoNumber(Integer.parseInt(Console.readLine()));
        WinningNumbers winningNumbers = new WinningNumbers(preWinningNumbers, bonusNumber);
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");
        LottoResult lottoResult = new LottoResult(new EnumMap<>(Rank.class), BigInteger.ZERO);

        lottoResult.calculate(lottoBundle, winningNumbers);
        Map<Rank, Integer> rankCount = lottoResult.getRankCount();

        System.out.printf("3개 일치 (5,000원) - %d개%n", rankCount.get(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", rankCount.get(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", rankCount.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", rankCount.get(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", rankCount.get(Rank.FIRST));

        System.out.printf("총 수익률은 %.1f%%입니다.", lottoResult.calculateReturnRate(investment));

    }
}
