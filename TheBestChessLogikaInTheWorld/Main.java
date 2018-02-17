package com.company;

import java.util.LinkedList;

// в методе step фигуры возможно надо добавить проверку на то не поступает ли своя фигура вторым кликом
//Взятие на проходе.
// предпологается разна реакция на разное событие
// при каждом успешном ходе проверять
public class Main {

    private static LinkedList<FigureAbstractClass> whiteList = new LinkedList<FigureAbstractClass>();
    private static LinkedList<FigureAbstractClass> niggaList = new LinkedList<FigureAbstractClass>();
    private static FigureAbstractClass [][] matr = new FigureAbstractClass[8][8];
    private static void fullTheMatr ()
    {
        //region свет
        whiteList.add(new СKing(4,0, false ,matr, null, whiteList, niggaList));
        whiteList.getFirst().setKing(whiteList.getFirst());
        matr[4][0] = whiteList.getFirst();
        whiteList.add(new CRook(0,0,false ,matr, matr[4][0], whiteList, niggaList));
        matr[0][0] = whiteList.getLast();
        whiteList.add(new СHorse(1,0,false ,matr, matr[4][0], whiteList, niggaList));
        matr[1][0] = whiteList.getLast();
        whiteList.add(new CElephant(2,0,false ,matr, matr[4][0], whiteList, niggaList));
        matr[2][0] = whiteList.getLast();
        whiteList.add(new CQueen(3,0,false ,matr, matr[4][0], whiteList, niggaList));
        matr[3][0] = whiteList.getLast();
        whiteList.add(new CElephant(5,0,false,  matr, matr[4][0], whiteList, niggaList));
        matr[5][0] = whiteList.getLast();
        whiteList.add(new СHorse(6,0,false ,matr, matr[4][0], whiteList, niggaList));
        matr[6][0] = whiteList.getLast();
        whiteList.add(new CRook(7,0,false ,matr, matr[4][0], whiteList, niggaList));
        matr[7][0] = whiteList.getLast();
        for ( int x = 0; x < 8; ++x )
        {
            matr[x][1] = new CPawn(x,1,false ,matr, matr[4][0], whiteList, niggaList);
            whiteList.add(matr[x][1]);
        }
        //endregion

        //region пустота
        for ( int x = 2; x < 5; ++x )
        {
            for (int y = 0; y < 8; ++y)
            {
                matr[y][x] = null;
            }
        }
        //endregion

        //region тьма
        niggaList.add(new СKing(4,7, true ,matr, null, niggaList, whiteList));
        niggaList.getFirst().setKing(niggaList.getFirst());
        matr[4][7] = niggaList.getFirst();
        niggaList.add(new CRook(0,7,true ,matr, matr[4][7], niggaList, whiteList));
        matr[0][7] = niggaList.getLast();
        niggaList.add(new СHorse(1,7,true ,matr, matr[4][7], niggaList, whiteList));
        matr[1][7] = niggaList.getLast();
        niggaList.add(new CElephant(2,7,true ,matr, matr[4][7], niggaList, whiteList));
        matr[2][7] = niggaList.getLast();
        niggaList.add(new CQueen(3,7,true ,matr, matr[4][7], niggaList, whiteList));
        matr[3][7] = niggaList.getLast();
        niggaList.add(new CElephant(5,7,true ,matr, matr[4][7], niggaList, whiteList));
        matr[5][7] = niggaList.getLast();
        niggaList.add(new СHorse(6,7,true ,matr, matr[4][7], niggaList, whiteList));
        matr[6][7] = niggaList.getLast();
        niggaList.add(new CRook(7,7,true ,matr, matr[4][7], niggaList, whiteList));
        matr[7][7] = niggaList.getLast();
        for ( int x = 0; x < 8; ++x )
        {
            matr[x][6] = new CPawn(x,6,true ,matr, matr[4][7], niggaList, whiteList);
            niggaList.add(matr[x][6]);
        }
        //endregion
    }

    private static void printMatr()
    {


        for (int y = 0; y < 8; ++y)
        {
            for ( int x = 0; x < 8; ++x )
            {
                System.out.print(printSimbol(matr[x][y]) + x + y + " ");
            }
            System.out.println();
        }
    }

    private static String printSimbol (FigureAbstractClass f )
    {
        if (f != null)
        {
            if (!f.getColor())
            {
                switch(f.getFigureType().ordinal()) {
                    case 0:
                        return "P";
                    case 1:
                        return "H";
                    case 2:
                        return "E";
                    case 3:
                        return "R";
                    case 4:
                        return "Q";
                    default:
                        return "K";
                }
            }else
            {
                switch(f.getFigureType().ordinal()) {
                    case 0:
                        return "П";
                    case 1:
                        return "Ъ";
                    case 2:
                        return "С";
                    case 3:
                        return "Л";
                    case 4:
                        return "Б";
                    default:
                        return "Ц";
                }
            }
        }else
            {
                return " ";
            }


    }

    public static void main(String[] args) {
        fullTheMatr ();
        matr[1][0].setAllT();
        for (MyPars x:matr[1][0].getStepList()
             ) {
            if (x != null)
            {
                System.out.println(x.getX() + " " +x.getY());
            }

        }
        System.out.println();
        System.out.println(matr[1][0].getCoordinates().getX() + " " + matr[1][0].getCoordinates().getY());
        System.out.println(matr[1][0].getFigureType());
        System.out.println(matr[1][0].step(2,2));
        System.out.println(matr[1][1].step(1,2));
        System.out.println(matr[2][0].step(0,2));
        System.out.println(matr[3][1].step(3,3));
        System.out.println(matr[3][0].step(3,2));
        System.out.println(matr[4][0].step(2,0));
        System.out.println(matr[1][6].step(1,4));
        System.out.println(matr[1][4].step(1,3));
        System.out.println(matr[2][2].step(0,4));
        System.out.println(matr[0][2].step(1,3));
        System.out.println(matr[1][3].step(3,5));
        System.out.println(matr[4][6].step(3,5));
        printMatr();
    }
}
