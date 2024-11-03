package lotto.controller;

import lotto.dao.LottoDAO;
import lotto.service.LottoCreateService;
import lotto.service.LottoMatchingSerivce;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoSelectService;
import lotto.view.LottoView;

public class LottoController {
        private final LottoView lottoView = new LottoView();
        private final LottoDAO lottoDAO = new LottoDAO();
        private final LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        private final LottoCreateService lottoCreateService=new LottoCreateService();
        private final LottoSelectService lottoSelectService=new LottoSelectService();
        private final LottoMatchingSerivce lottoMatchingSerivce= new LottoMatchingSerivce();

        public void lottoMain() {
                try {
                   int  purchaseCost  =  lottoView.getLottoPurchaseCost();
                   lottoDAO.setCost(purchaseCost);
                   lottoDAO.setPurchaseRound(lottoPurchaseService.getPurchaseCost(lottoDAO.getCost()));
                   lottoDAO.setLottoDatabase(lottoCreateService.getLotto(lottoDAO.getPurchaseRound()));
                   lottoView.printLotto(lottoDAO);
                   lottoDAO.setLottoSelect(lottoSelectService.getLottoSelect(lottoView.getLottoSelected()));
                   lottoDAO.setBonusNumber(lottoView.getLottoBonus());
                   lottoDAO.setLottoResult(lottoMatchingSerivce.getLottoResult(lottoDAO.getLottoDatabase(),lottoDAO.getLottoSelect(),lottoDAO.getBonusNumber()));
                   lottoDAO.setRateReturn(lottoMatchingSerivce.getRateReturn(lottoDAO.getLottoResult(),lottoDAO.getCost()));
                   lottoView.printLottoResult(lottoDAO.getLottoResult(),lottoDAO.getRateReturn());

                } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        //throw e;
                }
        }
}
