package view;

import dto.lottoDto.LottoResponse;
import dto.lottoWinningResultDto.LottoWinningResultResponse;
import java.text.NumberFormat;
import model.Lotto;

public class OutputViewImpl implements OutputView {
    @Override
    public void printIssuedLotto(LottoResponse lottoResponse) {
        System.out.println(lottoResponse.lottoCount() + "개를 구매했습니다.");
        for (Lotto lotto : lottoResponse.issuedLotto()) {
            System.out.println(lotto.toString());
        }
    }

    @Override
    public void printLottoResult(LottoWinningResultResponse lottoWinningResultResponse) {
        NumberFormat f = NumberFormat.getInstance();
        f.setGroupingUsed(false);

        System.out.println("당첨 통계");
        System.out.println(
                "3개 일치 (5,000원) - " + lottoWinningResultResponse.lottoWinningResult().fifthPlaceNumber() + "개");
        System.out.println(
                "4개 일치 (50,000원) - " + lottoWinningResultResponse.lottoWinningResult().fourthPlaceNumber() + "개");
        System.out.println(
                "5개 일치 (1,500,000원) - " + lottoWinningResultResponse.lottoWinningResult().thirdPlaceNumber() + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoWinningResultResponse.lottoWinningResult().secondPlaceNumber()
                        + "개");
        System.out.println(
                "6개 일치 (2,000,000,000원) - " + lottoWinningResultResponse.lottoWinningResult().firstPlaceNumber() + "개");

        System.out.println("총 수익률은 " + lottoWinningResultResponse.winningAmount() + "%입니다.");

    }
}
