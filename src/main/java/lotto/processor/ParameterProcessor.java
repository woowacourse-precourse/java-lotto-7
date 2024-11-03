package lotto.processor;

public abstract class ParameterProcessor<T, P> extends Processor<T>{
    protected final P parameter;

    protected ParameterProcessor(P parameter) {
        this.parameter = parameter;
    }
}
