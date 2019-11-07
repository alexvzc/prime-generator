/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.avc.aopexample;

import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author alexv
 */
public class PrimeGenerator implements SequenceGenerator {

    private SortedSet<Integer> generatedPrimes;

    private int topPrime;

    private int topPrimeSquared;

    private Set<Integer> primesToTest;

    public PrimeGenerator() {
        reset();

    } // PrimeGenerator()

    public void reset() {
        if(generatedPrimes == null || !generatedPrimes.isEmpty()) {
            generatedPrimes = new TreeSet<Integer>();
            topPrime = 3;
            topPrimeSquared = 9;
            primesToTest = Collections.emptySet();

        } // if(generatedPrimes == null || !generatedPrimes.isEmpty())

    } // reset()

    public int next() {
        if(generatedPrimes.isEmpty()) {
            generatedPrimes.add(2);

        } else if(generatedPrimes.last() == 2) {
            generatedPrimes.add(3);

        } else {
            boolean prime_found = false;
            PRIME_LOOP:
            for(int next_prime = generatedPrimes.last() + 2; !prime_found;
                    next_prime += 2) {
                if(next_prime >= topPrimeSquared) {
                    topPrime = generatedPrimes.tailSet(topPrime + 2).first();
                    topPrimeSquared = topPrime * topPrime;
                    primesToTest = generatedPrimes.subSet(3, topPrime);
                    next_prime += 2;

                } // if(next_prime >= topPrimeSquared)

                for(int prime_to_test : primesToTest) {
                    if(next_prime % prime_to_test == 0) {
                        continue PRIME_LOOP;

                    } // if(next_prime % prime_to_test == 0)

                } // for(int prime_to_test : primesToTest))

                generatedPrimes.add(next_prime);
                prime_found = true;

            } // for(int next_prime = generatedPrimes.last() + 2; !prime_found;
        //               next_prime += 2)

        } // if(generatedPrimes.last() == 2)

        return generatedPrimes.last();

    } // next()

    @Override
    public String toString() {
        return "prime numbers sequence";

    } // toString()

} // class PrimeGenerator
