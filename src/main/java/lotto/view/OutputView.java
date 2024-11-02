package lotto.view;

import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;


public class OutputView {

    public void purchaseLottoMessage(int count, Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder("\n" + count + "개를 구매했습니다.\n");

        lottos.getLottos().stream()
                .forEach(lotto -> stringBuilder.append(lotto.getNumbers() + "\n"));

        System.out.println(stringBuilder);
    }

    public void amountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void winningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void bonusNumberMessage(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void resultMessage(LottoResult lottoResult, int lottoAmount){
        StringBuilder stringBuilder = new StringBuilder("\n당첨 통계\n---\n");
        stringBuilder.append("3개 일치 ("+ LottoPrize.FIFTH.getPrice()+"원) - "+lottoResult.prizeCount(LottoPrize.FIFTH)+"개\n")
                .append("4개 일치 ("+ LottoPrize.FOURTH.getPrice()+"원) - "+lottoResult.prizeCount(LottoPrize.FOURTH)+"개\n")
                .append("5개 일치 ("+ LottoPrize.THIRD.getPrice()+"원) - "+lottoResult.prizeCount(LottoPrize.THIRD)+"개\n")
                .append("5개 일치, 보너스 볼 일치 ("+ LottoPrize.SECOND.getPrice()+"원) - "+lottoResult.prizeCount(LottoPrize.SECOND)+"개\n")
                .append("6개 일치 ("+ LottoPrize.FIRST.getPrice()+"원) - "+lottoResult.prizeCount(LottoPrize.FIRST)+"개\n")
                .append(String.format("총 수익률은 %.1f%%입니다.", lottoResult.rateOfReturn(lottoAmount)));
        System.out.println(stringBuilder);
    }

}
