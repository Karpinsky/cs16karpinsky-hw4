package main.java.ua.edu.ucu.autocomplete;

import main.java.ua.edu.ucu.tries.Trie;
import main.java.ua.edu.ucu.tries.Tuple;

/**
 *
 * @author andrii
 */
public class PrefixMatches {

    private Trie trie;

    public PrefixMatches(Trie trie) {
        this.trie = trie;
    }

    public int load(String... strings) {
        for (String word : strings)
        {
            if (word.length() > 2)
            {
                this.trie.add(new Tuple(word, 0));
            }
        }

        return this.trie.size();
    }

    public boolean contains(String word)
    {
        return this.trie.contains(word);
    }

    public boolean delete(String word)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterable<String> wordsWithPrefix(String pref) {
        return this.trie.wordsWithPrefix(pref);
    }

    public Iterable<String> wordsWithPrefix(String pref, int k)
    {
        return this.trie.wordsWithPrefix(pref, k);
    }

    public int size()
    {
        return this.trie.size();
    }
}
