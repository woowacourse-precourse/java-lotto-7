package lotto;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        LottoUtility utility = new LottoUtility();

        utility.printMessage("구입금액을 입력해 주세요.");
        LottoCreate lottoCreate = utility.getLottoCreate();

        String lottoCreateInfo = lottoCreate.getLottoCreateInfo();
        utility.printMessage("\n" + lottoCreateInfo);

        utility.printMessage("\n당첨 번호를 입력해 주세요.");
        Lotto winningLotto = utility.getWinningLotto();

        utility.printMessage("\n보너스 번호를 입력해 주세요.");
        int bonus = utility.getBonusNumber(winningLotto);

        utility.printMessage("\n당첨 통계");
        utility.printMessage("---");
        LottoWinningResult result = new LottoWinningResult();
        // 등수별 당첨 결과 세팅
        for(Lotto lotto : lottoCreate.getLottoList()) {
            int matchedNumberCount = lotto.getMatchingNumberCount(winningLotto.getNumbers());
            int matchedBonusNumberCount = (int) lotto.getNumbers().stream().filter(number -> number == bonus).count();
            LottoWinningStandard standard = utility.getLottoWinningStandard(matchedNumberCount, matchedBonusNumberCount);
            if(standard != null) {
                result.setWinningInfo(standard, result.getWinningInfoValueByKey(standard) + 1);
            }
        }
        // 총 수익금 계산
        long totalPrize = 0;
        for(Map.Entry<LottoWinningStandard, Integer> map : result.getWinningStandard().entrySet()) {
            String winningInfoMessage = utility.getWinningInfoMessage(map.getKey(), map.getValue());
            utility.printMessage(winningInfoMessage);
            totalPrize += utility.getTotalPrizeByLottoWinningStandard(map.getKey(), map.getValue());
        }
        // 총 수익률 계산 및 출력
        String returnRateString = utility.getReturnRateMessage((double) totalPrize, (double)lottoCreate.getAmount());
        utility.printMessage(returnRateString);
    }
}
