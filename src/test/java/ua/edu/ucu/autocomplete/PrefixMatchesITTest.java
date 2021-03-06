
package test.java.ua.edu.ucu.autocomplete;

import main.java.ua.edu.ucu.autocomplete.PrefixMatches;
import main.java.ua.edu.ucu.tries.TST;
// import org.hamcrest.Matchers.containsInAnyOrder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 *
 * @author Andrii_Rodionov
 */
public class PrefixMatchesITTest {

    private PrefixMatches pm;

    @Before
    public void init() {
        pm = new PrefixMatches(new TST());
        pm.load("abc", "abce", "abcd", "abcde", "abcdef");
    }

    @Test
    public void testWordsWithPrefix_String() {
        String pref = "ab";

        Iterable<String> result = pm.wordsWithPrefix(pref);

        String[] expResult = {"abc", "abce", "abcd", "abcde", "abcdef"};

        System.out.println(result.toString());

        // assertThat(result, containsInAnyOrder(expResult));
    }

    @Test
    public void testWordsWithPrefix_String_and_K() {
        String pref = "abc";
        int k = 3;

        Iterable<String> result = pm.wordsWithPrefix(pref, k);

        String[] expResult = {"abc", "abce", "abcd", "abcde"};

        System.out.println(result.toString());

        // assertThat(result, containsInAnyOrder(expResult));
    }

}
