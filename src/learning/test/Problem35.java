/* @formatter:off */

package learning.test                                                                               ;

import static learning.Accessories.c                                                                ;
import learning.DiscretePerceptron                                                                  ;
import learning.Tuple                                                                               ;

public class Problem35                                                                              {
    public static void main(String... args)                                                         {
        var type1            = c(
                                    new Tuple(-1, 0.8, 0.5, 0),
                                    new Tuple(-1, 0.9, 0.7, 0.3),
                                    new Tuple(-1, 1, 0.8, 0.5)
                                )                                                                   ;
        var type2            = c(
                                    new Tuple(-1, 0, 0.2, 0.3),
                                    new Tuple(-1, 0.2, 0.1, 1.3),
                                    new Tuple(-1, 0.2, 0.7, 0.8)
                                )                                                                   ;
        var n                = type1.length + type2.length                                          ;
        /* combine type1 & type2 */
        var inputs           = new Tuple[n]                                                         ;
        var desiredResponses = new double[n]                                                        ;
        var i                = 0                                                                    ;
        for (var input : type1)                                                                     {
            inputs[i]            =  input                                                           ;
            desiredResponses[i]  =  1                                                               ;
            i                   -=- 1                                                               ;}
        for (var input : type2)                                                                     {
            inputs[i]            =  input                                                           ;
            desiredResponses[i]  =  -1                                                              ;
            i                   -=- 1                                                               ;}
        /* Set the initial threshold to be 1 */
        var initialWeight = new Tuple(1, 0, 0, 0)                                                   ;
        var example       = new DiscretePerceptron(1, 0)                                            ;
        example.start(n, initialWeight, inputs, desiredResponses)                                   ;}}
