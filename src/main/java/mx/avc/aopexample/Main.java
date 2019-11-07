/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.avc.aopexample;

import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;

/**
 *
 * @author alexv
 */
public class Main {

    private static final Logger LOGGER = getLogger(Main.class);

    private static final int PRIMES_TO_CONSUME = 1000000;

    public static void main(String[] args) {
        SequenceGenerator primeGen = new PrimeGenerator();

        LOGGER.info("Consuming {} prime numbers", PRIMES_TO_CONSUME);
        for(int i = 1; i < PRIMES_TO_CONSUME; i++) {
          primeGen.next();
        }
        int lastPrime = primeGen.next();

        LOGGER.info("Completed. {}th prime number is {}", PRIMES_TO_CONSUME,
                    lastPrime);

    } // main(String[] args)

} // class Main
