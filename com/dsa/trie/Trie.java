package com.dsa.trie;

import com.dsa.custom_class.TrieNode;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("cat");

    }

    private int getIndex(char letter) {
        return letter - 'a';
    }

    public void insert(String word) {
        word = word.toLowerCase();
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int index = getIndex(letter);
            if (current.children[index] == null) {
                TrieNode newNode = new TrieNode();
                current.children[index] = newNode;
                current = newNode;
            } else {
                current = current.children[index];
            }
        }
        current.isWord = true;
    }
}
