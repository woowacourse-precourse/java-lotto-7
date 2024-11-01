package lotto;

import lotto.dto.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.printPurchaseAmountMessage();

        InputView inputView = new InputView();

        // 테스트할 입력값들을 배열에 추가
        String[] testInputs = {
                "5000",         // 정상 입력
                "abc",          // 숫자가 아님
                "-100",         // 음수 값
                "100000001",    // 최대 한도 초과
                "1500",         // 1,000원 단위 아님
                "2500",         // 1,000원 단위 아님
                "300",          // 1,000원 단위 아님
                "15000"          // 정상 입력
        };

        for (String input : testInputs) {
            try {
                System.out.println("테스트 입력값: " + input);
                PurchaseAmount purchaseAmount = PurchaseAmount.from(input);
                System.out.println("입력된 금액: " + purchaseAmount.amount());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("------------------------");
        }

        for (String input : testInputs) {
            try {
                System.out.println("테스트 입력값: " + input);

                // PurchaseAmount 객체 생성
                PurchaseAmount purchaseAmount = PurchaseAmount.from(input);

                // 로또 티켓 개수 계산 (예: 1,000원 당 1개 구매 가능)
                int ticketCount = purchaseAmount.amount() / 1000;

                // 개수를 출력
                outputView.printPurchasedTicketCount(ticketCount);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("------------------------");
        }
    }
}
