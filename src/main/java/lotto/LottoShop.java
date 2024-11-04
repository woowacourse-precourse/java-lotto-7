package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import java.util.stream.Collectors;

import static validator.InputValidator.*;

public class LottoShop {
    private static final int WIN_LOTTO_SIZE = 6;
    private static final int LOTTO_PRIZE = 1_000;
    private static final int PERCENTAGE = 100;
    private static final String ANNOUNCE_TEMPLATE = """
            당첨 통계
            ---
            3개 일치 (5,000원) - %d개
            4개 일치 (50,000원) - %d개
            5개 일치 (1,500,000원) - %d개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
            6개 일치 (2,000,000,000원) - %d개
            총 수익률은 %.1f%% 입니다.
            """;

    private List<Integer> winNumbers = new ArrayList<>(WIN_LOTTO_SIZE);
    private final LottoMachine lottoMachine;
    public int insert;

    public LottoShop() {
        this.lottoMachine = new LottoMachine();
    }

    public List<Lotto> sell(int amount) {
        int count = amount / LOTTO_PRIZE;
        return lottoMachine.drawLotto(count);
    }

    public int insertMoney() {
        System.out.println("구입 금액을 입력해주세요.");
        insert = Integer.parseInt(Console.readLine());

        validateInsertMoney(insert);

        return insert;
    }

    public void printLottoes(List<Lotto> lottoes) {
        System.out.println(lottoes.size() + "개를 구매했습니다");
        for (Lotto lotto : lottoes) {
            System.out.println(lotto.getNumbers());
        }
    }

    public List<Integer> winNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        validateWinNumbers(numbers);

        winNumbers = Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winNumbers;
    }
    public int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        validateBonusNumber(bonusNumber);

        return bonusNumber;
    }

    public String check(int amount, List<Integer> winNumbers, int bonusNumber, List<Lotto> lottos) {
        Map<Prize, Integer> prizeCountMap = new EnumMap<>(Prize.class);
        Arrays.stream(Prize.values()).forEach(prize -> prizeCountMap.put(prize, 0));

        lottos.forEach(lotto -> {
            int matchCount = lotto.countMatchNumbers(winNumbers);
            boolean hasBonus = lotto.hasBonus(bonusNumber);

            Prize prize = Prize.parse(matchCount, hasBonus);
            prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
        });
        int totalAmount = prizeCountMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getMoney() * entry.getValue())
                .sum();

        return ANNOUNCE_TEMPLATE.formatted(
                prizeCountMap.get(Prize.FIFTH),
                prizeCountMap.get(Prize.FOURTH),
                prizeCountMap.get(Prize.THIRD),
                prizeCountMap.get(Prize.SECOND),
                prizeCountMap.get(Prize.FIRST),
                (((double) totalAmount - amount) / amount) * PERCENTAGE
        );
    }
}
