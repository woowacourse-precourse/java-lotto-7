//package lotto.domain;
//
//
//public class Output {
//    private static final String START_SHOW_RESULT = "당첨 통계";
//    private static final String DELIMITER = "---";
//
//    private final StringBuilder output;
//
//    public Output() {
//        this.output = new StringBuilder();
//    }
//
//    public Output displayBuyLottos(Lottos lottos) {
//        long lottoAmount = lottos.getSize();
//        System.out.println(lottoAmount + "개를 구매했습니다.");
//        return lottos.result();
//    }
//
//    public String displayWinningResult(LottoResult lottoResult) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(START_SHOW_RESULT).append("\n");
//        sb.append(DELIMITER).append("\n");
//        sb = lottoResult.result(sb);
//        sb.append("총 수익률은 ").append(lottoResult.computeProfitRate()).append("% 입니다.");
//        return sb.toString();
//    }
//}
