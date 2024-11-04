package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String money = getMoney();

        List<Lotto> lottoList = getRandomLottos(money);

        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        lottoResultChecker.setWinningNumbers(getNumbers());
        lottoResultChecker.setBonusNumber(getNumber());

        Integer[] result = lottoResultChecker.getLottoResult(lottoList);

        ResultReport resultReport = new ResultReport(result);
        resultReport.printReport();
    }

    static String getMoney(){

        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        System.out.println();

        return input;
    }

    static List<Lotto> getRandomLottos(String money){
        LottoGenerator lottoGenerator = new LottoGenerator();

        try{
            lottoGenerator.purchaseLotto(money);
            System.out.println();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

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