package lotto.controller;

import static lotto.view.InputView.WINNING_LOTTO_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.Prize;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Integer::compareTo);
        return new Lotto(numbers);
    }

    public Lottos generateLottos(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(generateLotto());
        }
        return new Lottos(lottoList);
    }

    public int getLottoPurchaseCount(int cost) {
        return cost / LOTTO_PRICE;
    }

    public List<Integer> splitWinningNumbers(String winningNumber) {
        while (true) {
            try {
                List<Integer> numbers = Arrays.stream(winningNumber.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                if (numbers.size() != 6) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");

                }
                Set<Integer> uniqueNumbers = new HashSet<>(numbers);
                if (uniqueNumbers.size() != 6) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복이 없어야 합니다.");
                }
                
                return numbers; // 올바른 번호 개수면 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력
                System.out.println(WINNING_LOTTO_MESSAGE);
                winningNumber = Console.readLine(); // 새로 입력받기
            }
        }
    }

    public int checkCorrectCount(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public void checkResult(Lottos lottos, LottoResult lottoResult) {
        int resultPrize = 0;
        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = checkCorrectCount(lotto, lottoResult.getWinningNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(lottoResult.getBonusNumber());
            Prize prize = Prize.valueOf(matchCount, bonusMatch);
            lottoResult.increasePrizeCount(prize);
            resultPrize += prize.getResultPrize();
        }
        lottoResult.setTotalPrize(resultPrize);
    }

    public double checkProfitRate(LottoResult lottoResult) {
        int totalSpent = lottoResult.getLottoCost();
        int totalPrize = lottoResult.getTotalPrize();
        return (totalPrize - totalSpent) / (double) totalSpent * 100;
    }
}
