package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;
import lotto.service.ValidationService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static int getPurchaseAmount() {
        int purchaseAmount;
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                purchaseAmount = Integer.parseInt(Console.readLine());

                // ValidationService를 사용하여 유효성 검사 수행
                ValidationService.validatePurchaseAmount(purchaseAmount);
                break; // 유효한 입력 시 반복문 탈출
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력한 금액이 유효하지 않습니다. 숫자만 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount; // 유효한 입력 시 금액 반환
    }

    public static WinningLotto getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 유효성 검사: 당첨 번호 검증
        ValidationService.validateWinningNumbers(winningNumbers);

        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        // 유효성 검사: 보너스 번호 검증
        ValidationService.validateBonusNumber(winningNumbers, bonusNumber);

        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
