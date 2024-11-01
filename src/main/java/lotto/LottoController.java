package lotto;

public class LottoController {
        private final LottoView lottoView = new LottoView();
        private final LottoDAO lottoDAO = new LottoDAO();
        private final LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        private final LottoCreateService lottoCreateService=new LottoCreateService();
        private final LottoSelectService lottoSelectService=new LottoSelectService();

        public void lottoMain() {
                try {
                   int  purchaseCost  =  lottoView.getLottoPurchaseCost();
                   lottoDAO.setCost(purchaseCost);
                   lottoDAO.setPurchaseRound(lottoPurchaseService.getPurchaseCost(lottoDAO.getCost()));
                   lottoDAO.setLottoDatabase(lottoCreateService.getLotto(lottoDAO.getPurchaseRound()));
                   lottoView.printLotto(lottoDAO);
                   lottoDAO.setLottoSelect(lottoSelectService.getLottoSelect(lottoView.getLottoSelected()));
                   lottoDAO.setBonusNumber(lottoView.getLottoBonus());


                } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        //throw e;
                }
        }
}
