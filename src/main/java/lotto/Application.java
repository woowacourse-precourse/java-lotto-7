package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Price price = null;
        while (price == null) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            System.out.println();
            try {
                price = Price.from(input);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        LottoIssuer issuer = new LottoIssuer(price.getValue());
        int lottoCount = issuer.getLottoCount();
        System.out.println(lottoCount + "개를 구매했습니다.");

        String issuedLottoResult = issuer.getFormatLottos();
        System.out.println(issuedLottoResult);

        WinningNumber winningNumber = null;
        while (winningNumber == null) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            System.out.println();
            try {
                winningNumber = WinningNumber.from(input);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        BonusNumber bonusNumber = null;
        while(bonusNumber == null) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            try {
                bonusNumber = BonusNumber.from(input);
                bonusNumber.isDuplicated(winningNumber);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }

        System.out.println("당첨 통계\n---");
        Result result = new Result();
        result.calculate(winningNumber, bonusNumber, issuer);
        System.out.print(result.getFormattedWinningDetails());

        ReturnRate returnRate = new ReturnRate();
        String formattedReturnRate = returnRate.calculate(result, price);
        System.out.print("총 수익률은 " + formattedReturnRate + "입니다.");
    }
}
