package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        boolean isValid = false;
        InputManager inputManager= new InputManager();

        while (!isValid) {
            System.out.println("구입금액을 입력해 주세요.");
            inputManager.input();
            isValid = inputManager.amountInputValidate();
        }
        int amount = inputManager.stringToInt();

        Quickpicklotto quickpicklotto = new Quickpicklotto();
        List<List<Integer>> lottoTwoDList = quickpicklotto.randomLotto(amount/1000);

        System.out.println("\n"+amount/1000 + "개를 구매했습니다.");
        PrintingManager printingManager = new PrintingManager();
        printingManager.printing_TwoDList(lottoTwoDList);

        isValid = false;

        while (!isValid) {
            System.out.println("\n" + "당첨 번호를 입력해 주세요.");
            inputManager.input();
            isValid=inputManager.lottoInputValidate();
        }
        List<Integer> winningLottoNumber = inputManager.stringToInt_list();

        isValid = false;

        while (!isValid) {
            System.out.println("\n" + "보너스 번호를 입력해 주세요.");
            inputManager.input();
            isValid=inputManager.bonusInputValidate();
        }
        int sss_int = inputManager.stringToInt();
        LottoNumberMatching lottoNumberMatching = new LottoNumberMatching();
        List<Integer> lottoRank = lottoNumberMatching.matchingLottos(lottoTwoDList,winningLottoNumber,sss_int);

        CalculationReturn calculationReturn = new CalculationReturn();
        double lottoReturn = calculationReturn.calculateReturn(lottoRank,amount);
        List<Integer> countRank =calculationReturn.getCountRank();
        LottoRank[] ranks = LottoRank.values();
        System.out.println("\n당첨 통계\n---");
        int index = 0;

        for (int a = 0; a < 5; a++) {
            LottoRank rank = ranks[a];  // ranks 배열의 앞 5개 요소만 선택
            System.out.println(rank.getComment() + " - " + countRank.get(index) + "개");
            index++;
        }
        System.out.println("총 수익률은 "+lottoReturn+"%입니다.");
    }
}
