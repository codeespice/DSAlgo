package com.g.prepare.trivial;

public class CountLattice {


    public int countlattice(int radius)
    {
        if(radius==0)
        {
            return 0;
        }
        int r =4;
        int ysquare=0;

        for(int x=1;x< radius;x++)
        {
            ysquare =radius*radius-x*x;

            int y = (int)Math.sqrt(ysquare);
            if(y*y==ysquare)
            {
                r+=4;
            }

        }
    return r;
    }
    public static void main(String args[])
    {
        int r = 5;
        CountLattice countLattice = new CountLattice();
        System.out.println("Lattice Count:::"+countLattice.countlattice(r));

    }
}
