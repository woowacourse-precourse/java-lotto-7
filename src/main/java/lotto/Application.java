package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        Parser parser = new Parser();

        //입력 받기
        Output.printConsole("구입금액을 입력해 주세요.");
        Integer moneyAmount = Input.getUserInputAsInteger();
        Validate.checkBuyAmountValidate(moneyAmount);
        Integer lottoAmount = AmountCalculator.getLottoAmount(moneyAmount);
        Output.printConsole(lottoAmount + "개를 구매했습니다.");

        //로또 번호 뽑는 과정
        List<Lotto> lottoFullSets = LottoCalculator.getLottoSetsAsInputAmount(lottoAmount);

        //로또 자동 결과 출력
        Output.printLottoSets(lottoFullSets, lottoAmount);

        //당첨 번호 입력 받기
        Output.printConsole("당첨 번호를 입력해 주세요.");
        Lotto numberList= new Lotto(null);
        try {
            numberList = new Lotto(parser.parseStringToIntegerList(Input.readConsole()));
        }catch (NumberFormatException e){
            ErrorException.runError("숫자사이는 ,표로만 분리하여 작성하여야합니다.");
        }
        Validate.checkWinNumbersValidate(numberList);

        //보너스 번호 입력받기
        Output.printConsole("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = parser.parseStringToInteger(Input.readConsole());
        Validate.checkALottoNumberValidate(bonusNumber);
        Validate.checkBonusNumberAlreadySelected(bonusNumber, numberList);

        //당첨 결과 계산
        List<LottoWinner> lottoResult = LottoCalculator.getFullLottoResult(lottoFullSets, numberList, bonusNumber);

        //당첨 결과 출력
        Output.printConsole("당첨 통계");
        Output.printConsole("---");
        for (int i = 0; i < lottoResult.size(); i++) {
            LottoWinner lottoWinnerData = lottoResult.get(i);
            Output.printConsole(lottoWinnerData.getAmountCriteria() + lottoWinnerData.getBonusBallMent() + " ("
                    + parser.parseIntegerToProcessedInteger(lottoWinnerData.getWinPrize()) + "원) - "
                    + lottoWinnerData.getWinAmount() + "개");
        }

        //총 수익률 출력
        EarnCalculator.getEarnRate(moneyAmount, lottoResult);
        EarnCalculator.getEarn(lottoResult);
        Output.printConsole("총 수익률은 " + EarnCalculator.getEarnRate(moneyAmount, lottoResult) + "%입니다.");
    }
}
