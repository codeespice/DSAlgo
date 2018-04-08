package com.g.prepare.datastructure;

public class CustomHashMapShorterVersion<K,V> {

    int size;
    public CustomHashMapShorterVersion()
    {
        size=10;
    }
    static class Entry<K,V>{
        K key;
        V value;
        Entry next;
        public Entry(K key,V value)
        {
            this.key=key;
            this.value=value;
            this.next=next;
        }

    }
    Entry<K,V>[] entrees = new Entry[size];

    public void put(K key,V value)
    {
        int hash = getIndex(key);
        Entry entry = entrees[hash];
        // if no element create a element and place the element in array
        if(entry ==null)
        {
            entry=new Entry(key,value);
            entrees[hash]=entry;

        }
        else
        {
            /* if there is element  look for the element
            if there is collision replace the element
            else add the element at the end

             */
            Entry currentEntry = entry;
            while(currentEntry.next!=null)
            {
                //collison detected
                if(currentEntry.key.equals(key))
                {
                    //replace the value
                    currentEntry.value=value;
                    return;
                }

                currentEntry = currentEntry.next;
            }
            //add at the end of the linked list
            currentEntry.next= new Entry(key,value);
        }

    }
    /*
        find the hash value
        look if the element exists ot not
        if exits look through the linked list and get the value
        if not return null
     */
    public V getValue(K key)
    {
        int hash = getIndex(key);
        Entry entry = entrees[hash];

       if(entry!=null)
        {
            Entry currentEntry = entry;
            while(currentEntry.next!=null)
            {
                if(currentEntry.key.equals(key))
                {
                   return (V)currentEntry.value;
                }
                currentEntry = currentEntry.next;
            }
        }
        return null;
    }
    public int getIndex(K key)
    {
       return key.hashCode()%size;
    }

    public static void main(String[] args)
    {

    }
}
