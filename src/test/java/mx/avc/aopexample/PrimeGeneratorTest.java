/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.avc.aopexample;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author alexv
 */
public class PrimeGeneratorTest
        extends GeneratorTestHelper<PrimeGenerator> {

    private static final Collection<Integer> primeNumbers =
            Collections.unmodifiableCollection(
            Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
            37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79));

    @Before
    public void initialize() {
        setSequenceGenerator(new PrimeGenerator());

    } // initialize()

    @Test
    public void primes() {
        performTest(primeNumbers);

    } // primes()

} // class PrimeGeneratorTest