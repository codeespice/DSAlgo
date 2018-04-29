package com.g.ds.trivial;

public class DictionaryValidWords {
    static final int SIZE = 26;

    // trie Node
    static class TrieNode
    {
        TrieNode[] Child = new TrieNode[SIZE];

        // isLeaf is true if the node represents
        // end of a word
        boolean leaf;

        // Constructor
        public TrieNode() {
            leaf = false;
            for (int i =0 ; i< SIZE ; i++)
                Child[i] = null;
        }
    }
    public void insert(TrieNode root, String Key)
    {
        int n = Key.length();
        TrieNode pChild = root;

        for (int i=0; i<n; i++)
        {
            int index = Key.charAt(i) - 'a';

            if (pChild.Child[index] == null)
                pChild.Child[index] = new TrieNode();

            pChild = pChild.Child[index];
        }

        // make last node as leaf node
        pChild.leaf = true;
    }

    // A recursive function to print all possible valid
    // words present in array
    public void searchWord(TrieNode root, boolean Hash[],
                           String str)
    {
        // if we found word in trie / dictionary
        if (root.leaf == true)
            System.out.println(str);

        // traverse all child's of current root
        for (int K =0; K < SIZE; K++)
        {
            if (Hash[K] == true && root.Child[K] != null )
            {
                // add current character
                char c = (char) (K + 'a');

                // Recursively search reaming character
                // of word in trie
                searchWord(root.Child[K], Hash, str + c);
            }
        }
    }

    // Prints all words present in dictionary.
    public void PrintAllWords(char Arr[], TrieNode root,
                              int n)
    {
        // create a 'has' array that will store all
        // present character in Arr[]
        boolean[] Hash = new boolean[SIZE];

        for (int i = 0 ; i < n; i++)
            Hash[Arr[i] - 'a'] = true;

        // tempary node
        TrieNode pChild = root ;

        // string to hold output words
        String str = "";

        // Traverse all matrix elements. There are only
        // 26 character possible in char array
        for (int i = 0 ; i < SIZE ; i++)
        {
            // we start searching for word in dictionary
            // if we found a character which is child
            // of Trie root
            if (Hash[i] == true && pChild.Child[i] != null )
            {
                str = str+(char)(i + 'a');
                searchWord(pChild.Child[i], Hash, str);
                str = "";
            }
        }
    }

    public static void main(String[] args)
    {
        String Dict[] = {"go", "bat", "me", "eat",
                "goal", "boy", "run"} ;
        DictionaryValidWords dictionaryValidWords = new DictionaryValidWords();

        // Root Node of Trie
        TrieNode root = new TrieNode();

        // insert all words of dictionary into trie
        int n = Dict.length;
        for (int i=0; i<n; i++)
            dictionaryValidWords.insert(root, Dict[i]);

        char arr[] = {'e', 'o', 'b', 'a', 'm', 'g', 'l'} ;
        int N = arr.length;

        dictionaryValidWords.PrintAllWords(arr, root, N);
    }
}
