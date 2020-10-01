package learning;

public interface UnsupervisedLearning extends Learning
{
    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public default double quantizedResponse(Tuple weight, Tuple input, double desiredResponse)
    {
        return 0;
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public default Tuple nextWeight(Tuple weight, Tuple input, double desiredResponse)
    {
        return Learning.super.nextWeight(weight, input, desiredResponse);
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public default void start(int numOfSteps, Tuple initialWeight, Tuple[] inputs,
            double[] desiredResponses)
    {
        Learning.super.start(numOfSteps, initialWeight, inputs, desiredResponses);
    }
}
