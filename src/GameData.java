public class GameData
{
    private char[][] grid = {{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '}};

    public char[][] getGrid()
    {
        return grid;
    }

    public boolean restartR = false;
    public boolean restartB = false;

    private char next = 'R';

    public void reset()
    {
        System.out.println("Reset data");
        for(int r=0;r<grid.length; r++)
            for(int c=0; c<grid[0].length; c++)
                grid[r][c]=' ';
    }

    public void setNext(char next){
        this.next = next;
    }

    public char getNext(){
        return  this.next ;
    }

   
    public boolean isCat()
    {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i] == null) {
                return false;
            }
        }
        return true;
    }

    public boolean isWinner(char letter, int r, int c)
    {
        System.out.println("r:" + r + "c:" +c);
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<6;j++)
                System.out.print("i:" +i + "j:" + j + " " + grid[i][j] + "  ");
            System.out.println();
        }
        System.out.println();
        System.out.println("Grid" + grid.length); //7
        System.out.println("Grid 0" + grid[0].length); //6

        //Find left
        System.out.println("Checking for win for " + letter + " r:" + r + " c:" + c + "Grid" + grid[r][c]);
        int leftCount = 0;
        int rightCount = 0;
        for(int i=1;i<=3;i++)
        {
            if(c-i >= 0) {
                if (grid[r][c - i] == letter) {
                    leftCount = leftCount + 1;
                    System.out.println(" grid[ " + (r) + "][" + (c - i) + "]" + grid[r][c - i] + " for letter " + letter + " leftCount " + leftCount);
                } else
                    break;
            }
        }
        //Find right
        System.out.println("Find right");
        for(int i=1;i<=3;i++)
        {
            if(c+i < grid[0].length) {
                if (grid[r][c + i] == letter) {
                    rightCount = rightCount + 1;
                    System.out.println(" grid[ " + (r) + "][" + (c + i) + "]" + grid[r][c + i] + " for letter " + letter + " rightCount " + rightCount);
                } else
                    break;
            }
        }

        System.out.println("Checking for win for " + letter + " leftCount:" + leftCount + " rightCount:" + rightCount);
        if(leftCount + rightCount >= 3 && grid[r][c] ==letter) {
            System.out.println(">3 for " + letter);
            return true;
        }

        System.out.println("Find upper");
        //find upper
        int up = 0;
        int low =0;
        for(int i=1;i<=3;i++)
        {
            if(r-i >= 0) {
                if (grid[r - i][c] == letter) {
                    up = up + 1;
                    System.out.println(" grid[ " + (r - i) + "][" + c + "]" + grid[r - i][c] + " for letter " + letter + " up " + up);
                }
                else
                    break;
            }

        }
        //Find lower
        System.out.println("Find lower");
        for(int i=1;i<=3;i++) {
            if (r + i < grid.length) {
                if (grid[r + i][c] == letter) {
                    low = low + 1;
                    System.out.println(" grid[ " + (r + i) + "][" + (c) + "]" + grid[r + i][c] + " for letter " + letter + " low " + low);
                } else
                    break;
            }
        }
        System.out.println("Checking for win for up to down " +  letter + " up" + up + " lw" + low);;
        if(up + low >= 3 && grid[r][c] ==letter) {
            System.out.println(">3 for up to down " + letter + " up" + up + " lw" + low);
            return true;
        }


        //find diagonal \
        System.out.println("Find diagonam 1");
        int upd = 0;
        int lowd =0;
        for(int i=1;i<=3;i++)
        {
            if((c-i >= 0) &&(r-i >=0) && (grid[r-i][c-i] ==letter)) {
                upd = upd + 1;
                System.out.println(" grid[ " + (r-i) + "][" + (c-i) +"]" +  grid[r-i][c-i] + " for letter " + letter + " upd " +upd );
            }
            else
                break;
        }
        System.out.println("Find diagonam 2");
        //Find lower
        for(int i=1;i<=3;i++)
        {
            if((c+i < grid[0].length) &&(r+i < grid.length) && (grid[r+i][c+i] ==letter)) {
                lowd = lowd + 1;
                System.out.println(" grid[ " + (r+i) + "][" + (c+i) +"]" +  grid[r+i][c+i] + " for letter " + letter + " lowd " +lowd );
            }
            else
                break;
        }
        System.out.println("Checking for win for  diagonal up to low, left to right " +  letter + " upd" + upd + " lowd" + lowd);
        if(upd + lowd >= 3 && grid[r][c] ==letter) {
            System.out.println(">3 for up to diagonal up to low, left to right " + letter + " upd" + upd + " lowd" + lowd);
            return true;
        }

        System.out.println("Find diagonam 3");
        //Find Diagonal (right to left) /
        upd = 0;
        lowd =0;
        for(int i=1;i<=3;i++)
        {
            if((c+i <grid[0].length)  && (r-i >=0) && (grid[r-i][c+i] ==letter)) {
                upd = upd + 1;
                System.out.println(" grid[ " + (r-i) + "][" + (c+i) +"]" +  grid[r-i][c+i] + " for letter " + letter + " upd " +upd );
            }
            else
                break;
        }
        //Find lower
        System.out.println("Find diagonam 4");
        for(int i=1;i<=3;i++)
        {
            if((c-i >= 0 ) &&(r+i < grid.length) && (grid[r+i][c-i] ==letter)) {
                lowd = lowd + 1;
                System.out.println(" grid[ " + (r+i) + "][" + (c-i) +"]" +  grid[r+i][c-i] + " for letter " + letter + " upd " +lowd );
            }
            else
                break;
        }
        System.out.println("Checking for win for  diagonal up to low, right to left " + letter + " upd" + upd + " lowd" + lowd);
        if(upd + lowd >= 3 && grid[r][c] ==letter) {
            System.out.println(">3 for up to diagonal up to low, right to left " + letter + " upd" + upd + " lowd" + lowd);
            return true;
        }

        return false;
    }


}
