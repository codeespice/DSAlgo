package com.g.prepare.trivial;

public class RoboticMovement {

    String move;

    RoboticMovement(String move)
    {
        this.move=move;

    }

    public void predictMove()
    {
        int countUp = 0, countDown = 0;
        int countLeft = 0, countRight = 0;

        for(int i=0;i<move.length();i++)
        {
            System.out.println(move.charAt(i));

            switch(move.charAt(i))
            {
                case 'U': countUp++;
                            break;
                case 'D': countDown++;
                        break;
                case 'R':countRight++;
                        break;
                case 'L' : countLeft++;
                        break;

            }
        }

        System.out.println("Final position:::"+(countUp-countDown) + ":"+(countRight-countLeft));
    }



    public static void main(String args[])
    {
        String move = "UDDLLRUUUDUURUDDUULLDRRRR";
        RoboticMovement rb = new RoboticMovement(move);
        rb.predictMove();
    }
}
