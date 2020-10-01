package learning;

public class DiscretePerceptron implements SupervisedLearning
{
    double learningRate, threshold;

    public DiscretePerceptron(double learningRate, double threshold)
    {
        this.learningRate = learningRate;
        this.threshold    = threshold;
    }

    @Override
    public double activationFunction(double net)
    {
        return net >= 0 ? 1 : -1;
    }

    @Override
    public double learningRate()
    {
        return learningRate;
    }

    @Override
    public double threshold()
    {
        return threshold;
    }

    @Deprecated
    @Override
    public double derivativeOfActFun(double net)
    {
        /* Not used here. */
        return 0;
    }

    @Override
    public double quantizedResponse(Tuple weight, Tuple input, double desiredResponse)
    {
        return desiredResponse - activationFunction(net(weight, input));
    }
}
