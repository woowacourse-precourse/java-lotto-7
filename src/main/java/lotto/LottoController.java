package lotto;

public class LottoController {
        private final LottoPurchaseView lottoPurchaseView = new LottoPurchaseView();
        private final LottoDAO lottoDAO = new LottoDAO();
        private final LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();

        public void raceMain() {
                try {
                   int  purchaseCost  =  lottoPurchaseView.getLottoPurchaseCost();
                   lottoDAO.setCost(purchaseCost);
                   lottoDAO.setPurchaseRound(lottoPurchaseService.getPurchaseCost(lottoDAO.getCost()));

                   System.out.println(lottoDAO.getCost());
                   System.out.println(lottoDAO.getPurchaseRound());

                } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        //throw e;
                }
        }
}
