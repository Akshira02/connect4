//public class GameData
//{
//    private char[][] grid = {{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '},{' ',' ', ' ',' ',' ', ' '}};
//
//    public char[][] getGrid()
//    {
//        return grid;
//    }
//
//    public void reset()
//    {
//
//        grid = new char[3][3];
//        for(int r=0;r<grid.length; r++)
//            for(int c=0; c<grid[0].length; c++)
//                grid[r][c]=' ';
//    }
//
//
//    public boolean isCat()
//    {
//        if(grid[0][0] !=' ' && grid[0][1] !=' ' && grid[0][2] !=' '
//                && grid[1][0] !=' ' && grid[1][1] !=' ' && grid[1][2] !=' '
//                && grid[2][0] !=' ' && grid[2][1] !=' ' && grid[2][2] !=' '
//                && !isWinner('X') && !isWinner('O'))
//            return true;
//        else
//            return false;
//    }
//    // int x = moveX;
//    //        int y = moveY;
//    //        int piecesInLine = 0;
//    //        boolean edgeNotFound = true;
//    //        while(edgeNotFound){
//    //            if(y == 0 || x == 0){
//    //                edgeNotFound = false;
//    //            }else {
//    //                x = x - 1;
//    //                y = y - 1;
//    //            }
//    //        }
//    //        while((x < 7 && x > -1) && (y < 6 && y > -1)) {
//    //            if (board[x][y] == counter) {
//    //                piecesInLine = piecesInLine + 1;
//    //                if (piecesInLine == 4) {
//    //                    System.out.println("Player " + counter + " wins");
//    //                    return false;
//    //                }
//    //            } else {
//    //                piecesInLine = 0;
//    //            }
//    //            x = x + 1;
//    //            y = y + 1;
//    //        }
//    //        x = moveX;
//    //        y = moveY;
//    //        edgeNotFound = true;
//    //        piecesInLine = 0;
//    //        while(edgeNotFound){
//    //            if(y == 5 || x == 0){
//    //                edgeNotFound = false;
//    //            }else {
//    //                x = x - 1;
//    //                y = y + 1;
//    //            }
//    //        }
//    //        while((x < 7 && x > -1) && (y < 6 && y > -1)) {
//    //            if (board[x][y] == counter) {
//    //                piecesInLine = piecesInLine + 1;
//    //                if (piecesInLine == 4) {
//    //                    System.out.println("Player " + counter + " wins");
//    //                    return false;
//    //                }
//    //            } else {
//    //                piecesInLine = 0;
//    //            }
//    //            x = x + 1;
//    //            y = y - 1;
//    //        }
//    //        return true;
//    //    }
//
//    public boolean isWinner(char letter, int counter, int moveX, int moveY)
//    {
//        int x = moveX;
//        int y = moveY;
//        int piecesInLine = 0;
//        boolean edgeNotFound = true;
//        while(edgeNotFound){
//            if(y == 0 || x == 0){
//                edgeNotFound = false;
//            }else {
//                x = x - 1;
//                y = y - 1;
//            }
//        }
//        while((x < 7 && x > -1) && (y < 6 && y > -1)) {
//            if (grid[x][y] == counter) {
//                piecesInLine = piecesInLine + 1;
//                if (piecesInLine == 4) {
//                    System.out.println("Player " + counter + " wins");
//                    return false;
//                }
//            } else {
//                piecesInLine = 0;
//            }
//            x = x + 1;
//            y = y + 1;
//        }
//        x = moveX;
//        y = moveY;
//        edgeNotFound = true;
//        piecesInLine = 0;
//        while(edgeNotFound){
//            if(y == 5 || x == 0){
//                edgeNotFound = false;
//            }else {
//                x = x - 1;
//                y = y + 1;
//            }
//        }
//        while((x < 7 && x > -1) && (y < 6 && y > -1)) {
//            if (grid[x][y] == counter) {
//                piecesInLine = piecesInLine + 1;
//                if (piecesInLine == 4) {
//                    System.out.println("Player " + counter + " wins");
//                    return false;
//                }
//            } else {
//                piecesInLine = 0;
//            }
//            x = x + 1;
//            y = y - 1;
//        }
//        return true;
//    }
//
//
//}
