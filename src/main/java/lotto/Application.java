package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Lotto> lottoList = getRandomLottoList();

        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        lottoResultChecker.setWinningNumbers();
        lottoResultChecker.setBonusNumber();

        Integer[] result = lottoResultChecker.getLottoResult(lottoList);

        ResultReport resultReport = new ResultReport(result);
        resultReport.printReport();
    }

    static List<Lotto> getRandomLottoList() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        lottoGenerator.purchaseLotto();
        System.out.println();

        return lottoGenerator.lottoList;
    }

    static String getNumbers(){

        System.out.println("당첨 번호를 입력해주세요.");
        String input1 = readLine();
        System.out.println();

        return input1;
    }

    static String getNumber(){

        System.out.println("보너스 번호를 입력해주세요.");
        String input2 = readLine();
        System.out.println();

        return input2;
    }

}