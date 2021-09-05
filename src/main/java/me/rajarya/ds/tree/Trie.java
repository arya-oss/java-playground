package me.rajarya.ds.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }



    public static void main(String[] args) {
        String[] words = {"ram", "raj", "rajesh", "rajmani", "rakesh", "mani", "manish", "arya", "aryan", "mohini", "mohan"};

        Trie trie = new Trie();

        for (String word: words) {
            trie.insertWord(word);
        }

//        String[] searchTerms =  {"raj", "rajeesh", "ramesh"};
//        for (String term: searchTerms) {
//            System.out.println(term + " is present: " + trie.search(term));
//        }
        String prefix = "ra";
        List<String> prefixSearch = trie.getPrefixSearch(prefix);
        for(String search: prefixSearch) {
            System.out.println(search);
        }
    }

    private void getPrefixSearchUtil(TrieNode node, String prefix, List<String> words) {
        if (node.isEnd) words.add(prefix);
        if (node.children.size() == 0) return;
        for(Map.Entry<Character, TrieNode> child: node.children.entrySet()) {
            getPrefixSearchUtil(child.getValue(), prefix + child.getKey(), words);
        }
    }

    public List<String> getPrefixSearch(String prefix) {
        List<String> ans = new ArrayList<>();
        TrieNode node = root;
        int i;
        for (i = 0; i < prefix.length(); i++) {
            if (!node.children.containsKey(prefix.charAt(i))) break;
            node = node.children.get(prefix.charAt(i));
        }
        if (i == prefix.length()) {
            getPrefixSearchUtil(node, prefix, ans);
        }
        return ans;
    }

    public boolean search(String term) {
        TrieNode node = root;
        for(int i = 0; i < term.length(); i++) {
            if (!node.children.containsKey(term.charAt(i))) return false;
            node = node.children.get(term.charAt(i));
            if (i == term.length() - 1) {
                return node.isEnd;
            }
        }
        return false;
    }

    public void insertWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children.containsKey(word.charAt(i))) {
                if (i == word.length() - 1) {
                    node.isEnd = true;
                }
                node = node.children.get(word.charAt(i));
            } else {
                TrieNode trieNode = new TrieNode();
                if (i == word.length() - 1) {
                    trieNode.isEnd = true;
                }
                node.children.put(word.charAt(i), trieNode);
                node = trieNode;
            }
        }
    }
}
