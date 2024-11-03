package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class LottoInput {

    private static final Scanner scanner = new Scanner(System.in);

    public Integer getLottoPurchaseAmount() {
        // 로또 구입 금액 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();

        // 1000원 단위로 나누어 떨어지지 않는 경우 예외 처리
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }

        Integer lottoAmount = purchaseAmount / 1000;
        System.out.println(lottoAmount+"개를 구매했습니다.");

        return lottoAmount;
    }

    public Integer inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return scanner.nextInt();
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        String winningNumbersInput = scanner.nextLine();
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 당첨 번호 입니다.");
        }
        Collections.sort(winningNumbers);
        return winningNumbers;
    }
}
