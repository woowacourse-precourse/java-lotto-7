package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoService {

    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNumbers = null;
    private int bonusNumber = -1;

    public void run() {
        purchaseLotto();
        inputWinningNumbersAndBonusNumber();
        List<LottoRank> result = lottos.stream()
                .map(lotto -> lotto.checkRank(winningNumbers, bonusNumber))
                .toList();
        result.forEach(this::printStatus);
    }

    private void purchaseLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottos.add(new Lotto(numbers));
    }

    private void inputWinningNumbersAndBonusNumber() {
        // IllegalArgumentException 발생 시 오류 메시지 출력하고 다시 입력 받도록 함
        while (winningNumbers == null) {
            try {
                winningNumbers = inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (bonusNumber == -1) {
            try {
                bonusNumber = inputBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printStatus(LottoRank lottoRank) {
        System.out.println(lottoRank);
    }

    private List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            List<Integer> numbers = Stream.of(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
            LottoValidator.validateLottoNumber(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    private int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            int bonusNumber = Integer.parseInt(input.trim());
            LottoValidator.validateBonusNumber(winningNumbers, bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

}
