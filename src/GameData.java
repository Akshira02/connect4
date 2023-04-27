public class GameData
{
    private char[][] grid = {{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '}};

    public char[][] getGrid()
    {
        return grid;
    }

    public void reset()
    {

        grid = new char[3][3];
        for(int r=0;r<grid.length; r++)
            for(int c=0; c<grid[0].length; c++)
                grid[r][c]=' ';
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

//add boolean, made it give an error to see uses
//shows wether anyone has won; not a specific character- change serverlistener usage or this method
    public boolean isWinner()
    {
        // horizontalCheck
        for (int j = 0 ; j< 9-4 ; j++){//column
            for (int i = 0 ; i < 48 ; i+=8){//row
                if (    grid[i + j]!= null && grid[i +j]== grid[i +j+1] && grid[i +j] == grid[i+j+2] && grid[i +j] ==  grid[i+j+3]){
                    return true;
                }
            }
        }
        // verticalCheck
        for (int i = 0 ; i< 24 ; i+=8){
            for (int j = 0 ; j < 9 ; j++){
                if (    grid[i  + j]== null && grid[i +j]== grid[i+8 +j] && grid[i +j] == grid[i+(16) +j] && grid[i +j] ==  grid[i+(24) +j]){
                    return true;
                }
            }
        }
        // ascendingDiagonalCheck
        for (int i = 24 ; i< 48 ; i+=8){
            for (int j = 0 ; j <4 ; j++){
                if (    grid[i + j]!= null && grid[i +j]== grid[(i-8) +j+1] && grid[(i-8) +j+1] == grid[i-16 +j+2] && grid[(i-16) +j+2] ==  grid[(i-24) +j+3]){
                    return true;
                }
            }
        }
        // descendingDiagonalCheck
        for (int i = 24 ; i< 48 ; i+=8){
            for (int j = 3 ; j < 8; j++){
                if (    grid[i  + j]!= null && grid[i +j]== grid[(i-8) +j-1 ] && grid[(i-8) +j-1 ] == grid[(i-16) +j-2] && grid[(i-16) +j-2] ==  grid[(i-24) +j-3]){
                    return true;
                }
            }
        }

        return false;
    }


}
