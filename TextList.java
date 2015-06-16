class TextList
{
    /**
  
   *Class constructor.
   */
  
    WordNode _head;
   /**
    * empty constractor
    */    
    public TextList ()
    {
       _head=null;
    }        
    /**
     * constractor for the textList
     * @param String as a text 
     */
    public TextList(String text)  //creating a linked list from a given text
    {
      if(text==null)
      {
          return;
      }
       int x= text.length();     
      int i=0;
      while (i!=-1)
      {

        
        i= text.indexOf(" ") ;
        if( i!=-1)
        {
          String t=text.substring(0,i);
          this.addToData(t);
          t= "  ";
          text=text.substring(i+1);
        }
        else
        {
           this.addToData(text);
        }
    }       
   }
   /**
    *adding a string to the List
    *@param  a string
    */ 
   public void addToData( String word)  // adding a wordNod to the linkedList
    {
       
      if (_head==null)
       {
           
          _head=new WordNode( word,1,null);   
           if(_head!=null)
           {
               return; 
            }
        }
        
       WordNode current=_head;
       WordNode prev=_head;
       int x=current.getString().compareTo(word);
       
        while (x<0) 
        {  
           
                   
            if (current.getNext()==null)    //if  we have got to the last node at the linked list
            {
               WordNode w= new WordNode( word,0,null);
               current.setNext(w);
               w.setNext(null);
               
            }   
                                    
            prev=current;
            current=current.getNext();
            x=current.getString().compareTo(word);
            
        }
    
        if(x==0)
        {
            current.addNum();
            return;
        }
        else
        {
           
            WordNode w=new WordNode(word,1,null);
            if (current==_head)      //if "word" is going to enter to the head of the linkedlist.
            {
                _head=w;
                w.setNext(current);
                return;
            }
           prev.setNext(w);       //if we are not at the edges of the linkes List.
           w.setNext(current);           
           return;
        }
          
    
    }
    
     /**
      * returns how many words exist in the linked list
      * 
      */
     public int howManyWords()     //counts how many words exist in the linked list
     {
       WordNode current=_head;
       int count=0;
       if(current==null)
       {
         return count;
       } 
       
       while( current.getNext()!=null )
       {
        count=count+ current.getNum();
        current=current.getNext();
       }
       if(current.getNext()==null)
       {
          count=count+current.getNum();
          return count;
       }
    
       else
       {
           return count;
        }
    }

    /**
     * return how many diffrent words exist in the linked list
     */ 
    public int howManyDifferentWords ()   //count how many diffrents word  exist in the linked list
     {
       WordNode current=_head;
       int count=0;
       while( current.getNext()!=null )
       {
        count=count+1;
        current=current.getNext();
       }
       if(current.getNext()==null)
       {
          count=count+1;
          return count;
       }
       else
       {
           return count;
        }
    }  
    /**
     * return the most frequent word in the linked list
     */
    public String mostFrequentWord ()     //return the most frequent word in the linked list
    {
        String s;
        int count;
        int big;
        WordNode current=_head;
        big=current.getNum();
        s= current.getString(); 
        while (current !=null)       
        {
            if (current.getNum()>big)
            {
                big=current.getNum();
                s=current.getString();
            }
            current=current.getNext();
        }
        return s;
    }
    
   /**
    * buid a new list with num of chars of first Strings for each node from a givven list of strings
    * @param WordNod, wordNode, String
    */      
    public void buildNewList( WordNode w,WordNode s,String p)
    {
       if(w==null)
      {
            return;
      }
          
      if( w.getString().substring(0,1).equals(p) )
      {            
          s.addNum();
          buildNewList(w.getNext(),s,p);
        }                       
      else  
      {
          WordNode another=new WordNode (w.getString().substring(0,1),1,null);
          s.setNext(another);
          buildNewList(w.getNext(), another, w.getString().substring(0,1));
      }         
    }       
                                                       
    /**
     * return the wordNode with the highest number of String
     * @param WordNode  and natural number
     * 
     */
     public WordNode mostFrequentChar( WordNode w, int i) //return the wordNode with the highest number of Strings
    {
       WordNode big;
        if (w.getNext()==null)
       {
           return w;
       }
       
       big=mostFrequentChar( w.getNext(),i+1);
       {
           if (w.getNum()<big.getNum() )           
           {
               return big;
           }
            else
            {
                return w;
            }
        }
    }
    
     /**
      * return the most frequent starting char in the linked list
      * 
      */   
     public char mostFrequentStartingLetter ()     //return the most frequent starting char in the linked list
    {
       WordNode first=new WordNode( _head.getString().substring(0,1),0,null);
       buildNewList(_head,first,_head.getString().substring(0,1));
       WordNode a=mostFrequentChar(first,0);
       return a.getString().charAt(0);
    }
    
   /**
    * return the number  of letters , that starting with a given char
    * @param char
    */
    public int howManyStarting (char letter)    //return the number  of letters , that starting with a given char
   {
     if(_head==null)
     {
         return 0;
     }
     WordNode first=new WordNode( _head.getString().substring(0,1),0,null);
     this.buildNewList(_head,first,_head.getString().substring(0,1));
     WordNode searchNode=first;
     while(searchNode!=null)
     {
        if(searchNode.getString().charAt(0)==letter)
        {
            return searchNode.getNum();
        }
       else
       {
           searchNode=searchNode.getNext();
       }
    
     }
        
         return 0;
     
    }
    
   /**
    * return return  all the strings in the linked List and the amount for each one
    */
   public String toString()  // return  all the strings in the linked List and the amount for each one
    {
       WordNode searchNode=_head;
       String s="";
       if( searchNode==null)
       {
           s="the list is empty";
           return s;
       }
           while (searchNode!=null)
       {
          String t=searchNode.getString();
          int x=searchNode.getNum();
          s+= t +"\t" +x + "\n" ;
          searchNode=searchNode.getNext();
        }
      return s;
    }
}    
        
        
        
        
        
        
        
         
         
         
         
         
         
         
         
         
         
         
         
        
