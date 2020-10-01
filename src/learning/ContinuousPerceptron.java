package learning;

import learning.functional.UnivariateFunction;

public class ContinuousPerceptron implements SupervisedLearning
{
    UnivariateFunction actFun, diff;
    double             learningRate, threshold;

    public ContinuousPerceptron(UnivariateFunction actFun, UnivariateFunction diff,
            double learningRate, double threshold)
    {
        this.actFun       = actFun::func;
        this.diff         = diff::func;
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

    @Override
    public double activationFunction(double net)
    {
        return actFun.func(net);
    }

    @Override
    public double derivativeOfActFun(double net)
    {
        return diff.func(net);
    }

    @Override
    public double quantizedResponse(Tuple weight, Tuple input, double desiredResponse)
    {
        var net = net(weight, input);
        return (desiredResponse - activationFunction(net)) * derivativeOfActFun(net);
    }
}
