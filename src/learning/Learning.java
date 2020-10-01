package learning;

public interface Learning
{
    /**
     * This is supposed to be constant.
     * 
     * @return the learning rate, which is a number x such that 0 <= x <= 1.
     */
    public double learningRate();

    /**
     * This is supposed to be constant.
     * 
     * @return the threshold.
     */
    public double threshold();

    /**
     * Gives the value of the activation function at {@code net}.
     * 
     * @param net
     *        the net input.
     * @return the value of the activation function at {@code net}.
     */
    public double activationFunction(double net);

    /**
     * Gives the value of the derivative of the activation function at {@code net}. If this is not
     * used, just implement it however you like.
     * 
     * @param net
     *        the net input.
     * @return the value of the derivative of the activation function at {@code net}.
     */
    public double derivativeOfActFun(double net);

    public default double net(Tuple weight, Tuple input)
    {
        return weight.innerProduct(input) - threshold();
    }

    /**
     * Gives the quantized response. Implement this method if it is in an unsupervised manner.
     * 
     * @param weight
     *        the weight.
     * @param input
     *        the input.
     * @return the quantized response.
     */
    public double quantizedResponse(Tuple weight, Tuple input);

    /**
     * Gives the quantized response. Implement this method if it is in a supervised manner.
     * 
     * @param weight
     *        the weight.
     * @param input
     *        the input.
     * @param desiredResponse
     *        the desired response.
     * @return the quantized response.
     */
    public double quantizedResponse(Tuple weight, Tuple input, double desiredResponse);

    public default Tuple nextWeight(Tuple weight, Tuple input)
    {
        return weight.plus(input.times(learningRate() * quantizedResponse(weight, input)));
    }

    public default Tuple nextWeight(Tuple weight, Tuple input, double desiredResponse)
    {
        return weight.plus(
                input.times(learningRate() * quantizedResponse(weight, input, desiredResponse)));
    }

    public default void start(int numOfSteps, Tuple initialWeight, Tuple[] inputs)
    {
        var w     = new Tuple(initialWeight);
        var input = inputs[0];
        for (int k = 0, n = inputs.length; k < numOfSteps; k -= -1)
        {
            if (k < n)
            {
                input = inputs[k];
            }
            System.out.println(String.format("net(%s) = %s", k + 1, net(w, input)));
            w = new Tuple(nextWeight(w, input));
            System.out.println(String.format("W(%s) = %s", k + 1, w));
        }
    }

    public default void start(int numOfSteps, Tuple initialWeight, Tuple[] inputs,
            double[] desiredResponses)
    {
        var w               = new Tuple(initialWeight);
        var input           = inputs[0];
        var desiredResponse = desiredResponses[0];
        for (int k = 0, n = inputs.length; k < numOfSteps; k -= -1)
        {
            if (k < n)
            {
                input           = inputs[k];
                desiredResponse = desiredResponses[k];
            }
            var net = net(w, input);
            System.out.println(String.format("net(%s) = %s", k + 1, net));
            System.out.println(String.format("error(%s) = f(net(%s)) - desiredResponse(%s) = %s",
                    k + 1, k + 1, k + 1, activationFunction(net) - desiredResponse));
            w = new Tuple(nextWeight(w, input, desiredResponse));
            System.out.println(String.format("W(%s) = %s", k + 1, w));
        }
    }
}
