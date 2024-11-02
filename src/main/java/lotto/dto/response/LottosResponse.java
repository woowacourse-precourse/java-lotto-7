//package lotto.dto.response;
//
//import lotto.domain.PurchasedLottos;
//
//import java.util.List;
//
//public record LottosResponse(
//        int quantity,
//        List<LottoResponse> lottos
//) {
//    public static LottosResponse of(int quantity, PurchasedLottos purchasedLottos) {
//        List<LottoResponse> lottos = purchasedLottos.toLottoResponses();
//        return new LottosResponse(quantity, lottos);
//    }
//}
