package lotto;

public class LottoMachineFixture {
    public static LottoMachine createLottoMachine() {
        return new LottoMachine(LottoNumberGeneratorFixture.createLottoNumberGenerator());
    }
}
