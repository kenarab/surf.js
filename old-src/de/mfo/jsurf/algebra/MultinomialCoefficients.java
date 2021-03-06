/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.mfo.jsurf.algebra;

/**
 *
 * @author stussak
 */
public class MultinomialCoefficients
{

    static final int[][] binomialCoeffs; // lookup table for all binomial coeffs up to n = N and k = K
    static final int N= 100;
    static final int K= 100;

    static
    {
	binomialCoeffs= new int[N + 1][K + 1];

	// base cases
	for (int k= 1; k <= K; k++)
	    binomialCoeffs[0][k]= 0;
	for (int n= 0; n <= N; n++)
	    binomialCoeffs[n][0]= 1;

	// bottom-up dynamic programming
	for (int n= 1; n <= N; n++)
	    for (int k= 1; k <= K; k++)
		binomialCoeffs[n][k]= binomialCoeffs[n - 1][k - 1] + binomialCoeffs[n - 1][k];
    }

    public static int binomialCoefficient(int n, int k)
    {
	if (n <= N && k <= K) // return cached value
	    return binomialCoeffs[n][k];
	else
	    // more expensive recursive computation
	    return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }

    public static int multinomialCoefficient(int... k)
    {
	if (k.length == 0)
	    return 1;

	int result= 1;
	int k_sum= k[0];
	for (int i= 1; i < k.length; ++i)
	{
	    k_sum+= k[i];
	    result*= binomialCoefficient(k_sum, k[i]);
	}
	return result;
    }

    public static int trinomialCoefficient(int k1, int k2, int k3)
    {
	return multinomialCoefficient(makeArray(k1, k2, k3));
    }

    public static int quadrinomialCoefficient(int k1, int k2, int k3, int k4)
    {
	return multinomialCoefficient(makeArray(k1, k2, k3, k4));
    }

    private static int[] makeArray(int... i)
    {
	return i;
    }
}
