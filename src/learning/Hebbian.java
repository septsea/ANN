package learning;

import learning.functional.UnivariateFunction;

public class Hebbian implements UnsupervisedLearning
{
    UnivariateFunction actFun;
    double             learningRate, threshold;

    public Hebbian(UnivariateFunction actFun, double learningRate, double threshold)
    {
        this.actFun       = actFun::func;
        this.learningRate = learningRate;
        this.threshold    = threshold;
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

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public double derivativeOfActFun(double net)
    {
        /* Not used here. */
        return 0;
    }

    @Override
    public double activationFunction(double net)
    {
        return actFun.func(net);
    }

    @Override
    public double quantizedResponse(Tuple weight, Tuple input)
    {
        return activationFunction(net(weight, input));
    }
}
