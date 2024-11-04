package lotto.model;

import lotto.Lotto;

import java.util.ArrayList;

public class DrawModel {
    public static DrawModel drawModel = new DrawModel();
    private static ArrayList<Lotto> lottos;

    private DrawModel() {}

    public static ArrayList<Lotto> getLottos() {
        return lottos;
    }

    public static void setLottos(ArrayList<Lotto> lottos) {
        DrawModel.lottos = lottos;
    }
}
