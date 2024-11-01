package lotto.back.lotto.domain;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import lotto.back.lotto.config.LottoConfig;
import lotto.global.exception.CustomIllegalArgumentException;

public class Lottos {

    private final UUID uuid;

    private final List<Lotto> lottos;
    
    private final Integer price;

    private Lottos(UUID uuid, List<Lotto> lottos, Integer price) {
        this.uuid = uuid;
        this.lottos = lottos;
        this.price = price;
    }


    public static Lottos purchase(UUID uuid, Integer price) {
        validatePrice(price);
        Integer lottoCount = getLottoCount(price);
        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> Lotto.generateRandomLotto())
                .toList();

        return new Lottos(uuid, lottos, price);
    }

    private static void validatePrice(Integer price) {
        if ((price <= 0) || (price % LottoConfig.PRICE.get() != 0)) {
            throw new CustomIllegalArgumentException(
                    String.format("로또 가격은 개당 %d원입니다.", LottoConfig.PRICE.get())
            );
        }
    }

    private static Integer getLottoCount(Integer price) {
        return price / LottoConfig.PRICE.get();
    }


    public UUID getUuid() {
        return uuid;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Integer getPrice() {
        return price;
    }
}
