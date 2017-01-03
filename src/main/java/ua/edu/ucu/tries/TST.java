package main.java.ua.edu.ucu.tries;

import java.util.ArrayList;
import java.util.List;

public class TST implements Trie {

    private Integer trieSize;
    private Node<Tuple> root;

    public TST(){
        this.trieSize = 0;
        this.add(new Tuple("m", 0));
    }

    @Override
    public void add(Tuple tuple) {
        this.root = add(this.root, tuple, 0);
    }

    private Node<Tuple> add(Node<Tuple> node, Tuple tuple, Integer d)
    {
        char c = tuple.term.charAt(d);
        if (node == null)
        {
            this.trieSize++;
            node = new Node<>();
            node.c = c;
        }

        if (c < node.c) {
            node.left = add(node.left, tuple, d);
        } else if (c > node.c){
            node.right = add(node.right, tuple, d);
        } else if (d < tuple.term.length() - 1){
            node.mid = add(node.mid, tuple, d + 1);
        } else {
            node.value = tuple;
        }

        return node;
    }

    @Override
    public boolean contains(String word) {
        return get(word) != null;
    }

    public Tuple get(String word)
    {
        Node<Tuple> node = get(this.root, word, 0);
        if (node == null) return null;
        return node.value;
    }

    private Node<Tuple> get(Node<Tuple> node, String word, Integer d)
    {
        if (node == null) return null;
        char c = word.charAt(d);

        if (c < node.c) {
            return get(node.left, word, d);
        } else if (c > node.c){
            return get(node.right, word, d);
        } else if (d < word.length() - 1){
            return get(node.mid, word, d + 1);
        } else {
            return node;
        }
    }

    @Override
    public boolean delete(String word) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void traverseTST(Node<Tuple> root_, char[] buffer, int depth, List<String> words)
    {
        if (root_ != null)
        {
            // Traverse left sub tree
            traverseTST(root_.left, buffer, depth, words);

            buffer[depth] = root_.c;
            if (root_.value != null)
            {
                words.add(root_.value.term);
            }

            // Traverse mid sub tree
            traverseTST(root_.mid, buffer, depth + 1, words);

            // Traverse right sub tree
            traverseTST(root_.right, buffer, depth, words);
        }
    }

    private void traverseTST(Node<Tuple> root_, List<String> words)
    {
        char[] buffer = new char[64];
        this.traverseTST(this.root, buffer, 0, words);
    }

    @Override
    public Iterable<String> words() {
        List<String> words_ = new ArrayList<>(this.trieSize);

        this.traverseTST(this.root, words_);

        return words_;
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        List<String> words_ = new ArrayList<>(this.trieSize);

        this.traverseTST(this.get(this.root, s, 0), words_);

        return words_;
    }

    @Override
    public int size() {
        return this.trieSize;
    }


    private static class Node<T>
    {
        private T value;
        private char c;
        private Node<T> left, mid, right;
    }
}
