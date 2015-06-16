public class WordNode
{
    String _word;
    WordNode _next;
    int _num;
    public WordNode ( String word,int num ,WordNode next)
    {
        _word=word;
        _num=num;
        _next=next;
        
    }
    
    public String getString()    //return String
    {
        return _word;
    }
    public WordNode getNext () 
    {
        return _next;
    }
    public void setNext ( WordNode other)
    {
        _next=other;
    }
    public int getNum()
    {
        return _num;
    }
    public void addNums( int add)
    {
        _num=_num+add;
    }
    public void addNum ()
    {
        _num++;
    }
    

}
