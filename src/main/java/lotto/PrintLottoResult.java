package lotto;

public class PrintLottoResult {
    public void printResults(LottoResult lottoResult) {
        System.out.printf("3개 일치 (%d원) - %d개%n", LottoRank.FIFTH.getPrizeAmount(), lottoResult.getCount(LottoRank.FIFTH));
        System.out.printf("4개 일치 (%d원) - %d개%n", LottoRank.FOURTH.getPrizeAmount(), lottoResult.getCount(LottoRank.FOURTH));
        System.out.printf("5개 일치 (%d원) - %d개%n", LottoRank.THIRD.getPrizeAmount(), lottoResult.getCount(LottoRank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (%d원) - %d개%n", LottoRank.SECOND.getPrizeAmount(), lottoResult.getCount(LottoRank.SECOND));
        System.out.printf("6개 일치 (%d원) - %d개%n", LottoRank.FIRST.getPrizeAmount(), lottoResult.getCount(LottoRank.FIRST));
    }
}