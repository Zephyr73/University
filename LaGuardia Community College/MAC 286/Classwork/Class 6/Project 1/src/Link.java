class Link
{
    public int iData;              // data item
    public Link next;              // next link in list
    //-------------------------------------------------------------
    public Link(int id) // constructor
    {
        iData = id;                 // initialize data                // ('next' is automatically
    }                           //  set to null
    //-------------------------------------------------------------
    public void displayLink()      // display ourselves
    {
        System.out.print("(" + iData + ")");
    }
}  // end class Link