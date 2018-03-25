package com.g.prepare.hash;

public class CustomHashMap {
    Employee key;
    String value;
    private final int SIZE = 16;
    private Entry table[] = new Entry[SIZE];

    private int getSupplementalHash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int getBucketNumber(int hash) {
        return hash & (SIZE - 1);
    }
    public void put(Employee key, String value) {
        int userHash = key.hashCode();
        int hash = getSupplementalHash(userHash);
        int bucket = getBucketNumber(hash);
        Entry existingElement = table[bucket];
        for(;existingElement!=null;existingElement=existingElement.next)
        {
            if(existingElement.key.equals(key))
            {
                System.out.println("duplicate key value pair ,replace existing key"+key+"with value"+value);
                existingElement.value=value;
                return;
            }
            else
            {
                System.out.println("Collision detected for key " + key
                        + ", adding element to the existing bucket");

            }

        }
        System.out.println("PUT adding key:" + key + ", value:" + value
                + " to the list");
        Entry entryInOldBucket = new Entry(key, value);
        entryInOldBucket.next=table[bucket];
        table[bucket]=entryInOldBucket;



    }

    public Entry get(Employee key)
    {
        int userHash = key.hashCode();
        int hash = getSupplementalHash(userHash);
        int bucket = getBucketNumber(hash);
        Entry existingElement = table[bucket];
        while (existingElement != null) {
            System.out
                    .println("Traversing the list inside the bucket for the key "
                            + existingElement.getKey());
            if (existingElement.key.equals(key)) {
                return existingElement;
            }
            existingElement = existingElement.next;
        }
        return null;
    }
}
