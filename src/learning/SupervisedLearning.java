package learning;

public interface SupervisedLearning extends Learning
{
    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public default double quantizedResponse(Tuple weight, Tuple input)
    {
        return 0;
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public default Tuple nextWeight(Tuple weight, Tuple input)
    {
        return Learning.super.nextWeight(weight, input);
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public default void start(int numOfSteps, Tuple initialWeight, Tuple[] inputs)
    {
        Learning.super.start(numOfSteps, initialWeight, inputs);
    }
}
