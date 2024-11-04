package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoView {
    LottoController lottoController;
    private List<Lotto> purchasedLottos = new ArrayList<>();
    public LottoController purchaseAmountInput() {
        while (true) {
            try{
                System.out.println("구입금액을 입력해 주세요.");
                this.lottoController = new LottoController(Console.readLine());
                System.out.println();
                return lottoController;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void lottoWinningNumbersInput() {
        while(true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String[] inputLottoWinningNumbers = Console.readLine().split(",");
                lottoController.parseLottoWinningNumbers(inputLottoWinningNumbers);
                System.out.println();
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void lottoBonusInput() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                lottoController.setLottoBonusNumber(Console.readLine());
                System.out.println();
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void printPurchasedLottosInfo() {
        purchasedLottos = lottoController.getPurchasedLottos();
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for(Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printLottoRanksInfo() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for(LottoRank lottoRank : LottoRank.VALUES) {
            if(!lottoRank.getBonusMatched()) {
                System.out.println(lottoRank.getMatchCount() + "개 일치 (" + String.format("%,d", lottoRank.getPrizeAmount()) + "원) - " + lottoRank.getCount() + "개");
                continue;
            }
            System.out.println(lottoRank.getMatchCount() + "개 일치, 보너스 볼 일치 (" + String.format("%,d", lottoRank.getPrizeAmount()) + "원) - " + lottoRank.getCount() + "개");
        }
    }

}
