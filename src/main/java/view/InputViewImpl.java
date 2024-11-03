package view;

import camp.nextstep.edu.missionutils.Console;
import dto.lottoWinningResultDto.LottoWinningResultRequest;
import policy.BonusNumberPolicy;
import policy.LottoPolicyImpl;
import util.StringParser;

public class InputViewImpl implements InputView {
    @Override
    public String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public LottoWinningResultRequest inputLottoWinningResult() {

        String winningNumbers = getWinningNumbers();
        String bonusNumber = getBonusNumber();

        return new LottoWinningResultRequest(winningNumbers, bonusNumber);
    }

    private String getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        try {
            new LottoPolicyImpl().checkLottoPolicy(StringParser.parse(winningNumbers));
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    private String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        String bonusNumber = Console.readLine();
        try {
            new BonusNumberPolicy().checkBonusNumberPolicy(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }
}
