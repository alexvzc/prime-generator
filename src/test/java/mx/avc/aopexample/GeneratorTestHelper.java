/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.avc.aopexample;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author alexv
 */
public abstract class GeneratorTestHelper<T extends SequenceGenerator> {

    private static final int ITERATION_NUMBER = 10;

    protected T sequenceGenerator;

    public T getSequenceGenerator() {
        return sequenceGenerator;

    } // getSequenceGenerator()

    public void setSequenceGenerator(T sequence_generator) {
        sequenceGenerator = sequence_generator;

    } // setSequenceGenerator(T sequence_generator)

    protected void performTest(Iterable<Integer> expected_results) {

        for(int my_result : expected_results) {
            assertEquals(my_result, sequenceGenerator.next());

        } // for(int my_result : expected_results)

    } // performTest()

    @Test
    public void repeatableResults() {
        List<Integer> results = new ArrayList<Integer>(ITERATION_NUMBER);

        for(int i = 0; i < ITERATION_NUMBER; i++) {
            results.add(sequenceGenerator.next());

        } // for(int i = 0; i < ITERATION_NUMBER; i++)

        sequenceGenerator.reset();
        performTest(results);

    } // repeatableResults()

} // class GeneratorTester<T extends SequenceGenerator>
