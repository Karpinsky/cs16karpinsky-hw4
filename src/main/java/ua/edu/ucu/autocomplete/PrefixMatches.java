package main.java.ua.edu.ucu.autocomplete;

import main.java.ua.edu.ucu.tries.Trie;

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

    }

    public boolean contains(String word) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean delete(String word) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterable<String> wordsWithPrefix(String pref) {
        throw new UnsupportedOperationException("Not supported yet.");        
    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {
        throw new UnsupportedOperationException("Not supported yet.");        
    }

    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
