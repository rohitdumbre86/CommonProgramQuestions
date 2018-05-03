package com.datastructures.queue;

class TrieNode
{

    public Trie root;

    public TrieNode()
    {
        root = new Trie();
    }

    public void create(String s)
    {
        char[] letters = s.toCharArray();

        Trie temp = root;

        for (int i = 0; i < letters.length; i++)
        {
            char c = letters[i];

            if (temp.nodes[c - 'a'] == null)
            {
                final Trie node = new Trie(c);
                temp.nodes[c - 'a'] = node;
                temp = node;
            }
            else
            {
                final Trie node = temp.nodes[c - 'a'];
                temp = node;
            }

            if (i == letters.length - 1)
            {
                temp.isLeaf = true;
            }

        }

    }

    
    public boolean search(String words)
    {
      Trie node = searchNode(words);
      if(node!=null && node.isLeaf)
      {
        return true;
      }
      
      return false;
    }
    
    public boolean startsWith(String prefix)
    {
      if(searchNode(prefix)==null){
         return false;
      }
      return true;
    }
    
    
    public Trie searchNode(String s)
    { 
      Trie temp = root;
      char[] words = s.toCharArray();
      
      for(int i=0; i<words.length; i++)
      {
        if(temp.nodes[words[i]-'a'] == null){
        
          return null;
        
        }
        temp = temp.nodes[words[i]-'a'];
      
      }
      
      if(temp==root)
      {
        return null;
      }
      
      return temp;
    
    }
    
    
    public static void main(String[] args)
    {
        final String word_1 = "tasmanian";
        final String word_2 = "tasmaniandevil";
        final String word_3 = "tasmaniantarzan";
        
        final TrieNode dictionary = new TrieNode();

        dictionary.create(word_1);
        dictionary.create(word_2);
        
        String printString = "";
        for(int i=0; i<word_2.length(); i++)
        {
            printString += word_2.charAt(i);
           System.out.println("Word "+printString+": is present "+dictionary.startsWith(printString));
            
        }
        
        System.out.println("Word "+word_3+": is present "+dictionary.search(word_3));

    }

    class Trie
    {
        public Trie[]  nodes;
        public char    c;
        public boolean isLeaf;

        public Trie(char c)
        {
            this.nodes = new Trie[26];
            this.c = c;
        }

        public Trie()
        {
            this.nodes = new Trie[26];
        }
    }

}
