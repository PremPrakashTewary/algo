package com.general;

/**
 * Given a sequence of moves for a robot, check if the sequence is circular or not. A sequence of moves is circular if first and last positions of robot are same. A move can be on of the following.
 *
 *   G - Go one unit
 *   L - Turn left
 *   R - Turn right
 * Examples:
 *
 * Input: path[] = "GLGLGLG"
 * Output: Given sequence of moves is circular
 *
 * Input: path[] = "GLLG"
 * Output: Given sequence of moves is circular
 */
public class RobotDirection
{
    // Macros for East, North, South and West

    // This function returns true if
    // the given path is circular,
    // else false
    private static boolean isCircular(char path[])
    {
        // Initialize starting
        // point for robot as
        // (0, 0) and starting
        // direction as N North
        int x = 0, y = 0;
        int dir = 0;

        // Traverse the path given for robot
        for (int i=0; i < path.length; i++)
        {
            // Find current move
            char move = path[i];

            // If move is left or
            // right, then change direction
            if (move == 'R')
                dir = (dir + 1)%4;
            else if (move == 'L')
                dir = (4 + dir - 1) % 4;

                // If move is Go, then
                // change  x or y according to
                // current direction
            else // if (move == 'G')
            {
                if (dir == 0)
                    y++;
                else if (dir == 1)
                    x++;
                else if (dir == 2)
                    y--;
                else // dir == 3
                    x--;
            }
        }

        // If robot comes back to
        // (0, 0), then path is cyclic
        return (x == 0 && y == 0);
    }

    // Driver program
    public static void main(String[] args)
    {
        String path_ = "GLGLGLG";
        char path[] = path_.toCharArray();

        if (isCircular(path))
            System.out.println("Given sequence" +
                " of moves is circular");
        else
            System.out.println("Given sequence" +
                " of moves is NOT circular");
    }
}
