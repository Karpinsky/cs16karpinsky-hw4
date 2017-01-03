package main.java.ua.edu.ucu.tries;

public class RWayTrie implements Trie {

    private static final Integer R = 26 * 26;
    private Integer trieSize;
    private Node<Tuple> root;

    @Override
    public void add(Tuple tuple) {
        this.root = add(this.root, tuple, 0);
    }

    private Node<Tuple> add(Node<Tuple> node, Tuple tuple, Integer d)
    {
        if (node == null){
            this.trieSize++;
            node = new Node<>();
        }
        if (d == tuple.term.length()){
            node.value = tuple;
            return node;
        }
        char c = tuple.term.charAt(d);
        node.nextNodes[c] = add(node.nextNodes[c], tuple, d + 1);
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
        if (word.length() == d) return node;
        char c = word.charAt(d);
        return get(node.nextNodes[c], word, d + 1);
    }

    @Override
    public boolean delete(String word) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<String> words() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size() {
        return this.trieSize;
    }


    private static class Node<T>
    {
        private T value;
        private Node<T>[] nextNodes = (Node<T>[])new Node[R];
    }
}
