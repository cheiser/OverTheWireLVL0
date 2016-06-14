///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package temp;
//
//import java.awt.Color;
//import java.util.BitSet;
//
///**
// *
// * @author Mattis
// */
//public class ProblemSolverFW extends TetrisAI {
//
//    private double[] weights;
//
//    public ProblemSolverFW(double[] weights) {
//        this.weights = weights;
//    }
//
//    @Override
//    double rateBoard(Color[][] board) {
//        // insert value functions and weights here
//        int mH = getMaxHeight(board);
//        return ((weights[0] * mH)
//                + (weights[1] * getHoles(board, mH))
//                + (weights[2] * getNonFullLines(board, mH))
//                + (weights[3] * cleardRows(board))
//                + (weights[4] * rowHeight(board))
//                + (weights[5] * loneClosedHoles(board))
//                + (weights[6] * unevenness(board)));
//    }
//
//    public int getMaxHeight(Color[][] board) {
//        int height = board.length;
//        int maxHeight = 0;
//        for (int w = 0; w < board[0].length; w++) {
//            for (int h = 0; h < board.length; h++) {
//                if (board[h][w] != null) {
//                    if (height - h > maxHeight) {
//                        maxHeight = height - h;
//                    }
//                    break;
//                }
//            }
//        }
//
//        return maxHeight;
//    }
//
//    public int getHoles(Color[][] board, int maxHeight) {
//        int nrOfWholes = 0;
//        for (int h = board.length - maxHeight; h < board.length; h++) {
//            for (int w = 0; w < board[0].length && h > 0; w++) {
//                if (board[h][w] == null) {//&& board[h-1][w]!=null) {
//                    for (int y = h - 1; y >= 0; y--) {
//                        if (board[y][w] != null) {
//                            nrOfWholes++;
//                            break;
//                        }
//                    }
//
//                }
//                //nrOfWholes += 1;//Math.pow((h - (board.length - maxHeight) + 1),2);
//
//            }
//        }
//        //  System.out.println("whoels "+nrOfWholes);
//        return nrOfWholes;
//    }
//
//    public int getNonFullLines(Color[][] board, int maxHeight) {
//        int nrOfLines = 0;
//        for (int h = board.length - maxHeight; h < board.length; h++) {
//            for (int w = 0; w < board[0].length; w++) {
//                if (board[h][w] == null) {
//                    nrOfLines++;
//                    break;
//                }
//            }
//        }
//
//        return nrOfLines;
//    }
//
//    public int getFullLines(Color[][] board, int maxHeight) {
//        int nrOfLines = 0;
//        for (int h = board.length - maxHeight; h < board.length; h++) {
//            for (int w = 0; w < board[0].length; w++) {
//                if (board[h][w] != null) {
//                    nrOfLines++;
//                    break;
//                }
//
//            }
//        }
//
//        return nrOfLines;
//    }
//
//    /*
//     * CUSTOM STUFF
//     */
//    /*
//     * Dessa kan ersätta de gamla med om det är så..
//     */
//    // Antalet fria rader.
//    public int cleardRows(Color[][] b) {
//        int nrOfClear = 0;
//        boolean isClear;
//
//        for (int h = 0; h < b.length; h++) {
//            isClear = true;
//            for (int w = 0; w < b[0].length; w++) {
//                if (b[h][w] != null) {
//                    isClear = false;
//                }
//            }
//            if (isClear == true) {
//                nrOfClear++;
//            }
//        }
//        return nrOfClear;
//    }
//
//    // Högsta punkten
//    public int rowHeight(Color[][] b) {
//        for (int h = 0; h < b.length; h++) {
//            for (int w = 0; w < b[0].length; w++) {
//                if (b[h][w] != null) {
//                    return b.length - h;
//                }
//            }
//        }
//        return 0;
//    }
//
//    // Räkna antalet inlåsta singel hål.
//    public int loneClosedHoles(Color[][] b) {
//        int nrHoles = 0;
//        for (int h = 0; h < b.length; h++) {
//            for (int w = 0; w < b[0].length - 1; w++) {
//                if (b[h][w] == null && h < 19 && h > 0) {
//                    if (b[h + 1][w] != null && b[h - 1][w] != null) {
//                        if (w > 0 && b[h][w + 1] != null && b[h][w - 1] != null) {
//                            nrHoles++;
//                        }
//                    }
//                }
//            }
//        }
//        return nrHoles;
//    }
//
//    //Ojämnhet
//    public int unevenness(Color[][] board) {
//        int[] tips = new int[board[0].length];
//        int totalDiff = 0;
//
//        for (int w = 0; w < board[0].length; w++) {
//            for (int h = 0; h < board.length; h++) {
//                if (board[h][w] != null) {
//                    tips[w] = board.length - h;
//                    try {
//                        totalDiff += Math.abs(tips[w] - tips[w - 1]);
//                    } catch (ArrayIndexOutOfBoundsException ex) {
//                        break;
//                    }
//                    break;
//                }
//            }
//        }
//        return totalDiff;
//    }
//}