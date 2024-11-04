package lotto;

import domain.Lotto;
import domain.LottoGame;
import domain.LottoRank;
import domain.LottoResult;
import validator.Validator;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();

            int purchaseAmount = inputView.inputPurchaseAmount();
            Validator.validatePurchaseAmount(purchaseAmount);
            int ticketCount = purchaseAmount / 1000;

            List<Lotto> lottos = generateLottos(ticketCount);
            outputView.printPurchaseCount(ticketCount);

            List<Integer> winningNumbers = inputView.inputLottoNumbers();
            Validator.validateLottoNumbers(winningNumbers);
            int bonusNumber = inputView.inputBonusNumber();

            LottoGame lottoGame = new LottoGame(lottos);
            LottoResult result = lottoGame.calculateResult(new Lotto(winningNumbers), bonusNumber);
            outputView.printResults(result.getResults()); // 0개 일치 항목은 이미 필터링됨

            double yield = calculateYield(result.getResults(), purchaseAmount);
            outputView.printTotalYield(yield);
        } catch (IOException e) {
            System.out.println("[ERROR] 입력 처리 중 오류가 발생했습니다.");
        }
    }

    private static List<Lotto> generateLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());
    }

    private static List<Integer> pickUniqueNumbersInRange(int min, int max, int quantity) {
        Random random = new Random();
        HashSet<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < quantity) {
            int number = random.nextInt(max - min + 1) + min; // min에서 max 사이의 랜덤 숫자 생성
            uniqueNumbers.add(number); // Set에 추가하여 중복을 자동으로 방지
        }
        return new ArrayList<>(uniqueNumbers); // Set을 List로 변환하여 반환
    }

    private static double calculateYield(Map<LottoRank, Integer> results, int purchaseAmount) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * entry.getKey().getPrize())
                .sum();
        return (totalPrize / (double) purchaseAmount) * 100;
    }
}
