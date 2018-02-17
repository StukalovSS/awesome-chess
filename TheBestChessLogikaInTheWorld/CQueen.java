package com.company;

import java.util.LinkedList;

public class CQueen extends FigureAbstractClass {
    protected void setAllT ()
    {
        this.tList = new LinkedList<MyPars>();
        int x = this.getCoordinates().getX();
        int y = this.getCoordinates().getY();
        boolean ok;
        boolean ok2;
        // как ладья
        // вправо
        do
        {
            x = x + 1;
            ok2 = MyPars.isNormal(x,y);
            if (ok2)
            {
                ok = this.getmatr()[x][y] == null;
            }else {ok = false;}
            if ( ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor())))
            {
                this.tList.add(new MyPars(x,y));
            }
        }
        while (ok && ok2);

        // вниз
        x = this.getCoordinates().getX();
        do
        {
            y = y - 1;
            ok2 = MyPars.isNormal(x,y);
            if (ok2)
            {
                ok = this.getmatr()[x][y] == null;
            }else {ok = false;}
            if ( ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor())))
            {
                this.tList.add(new MyPars(x,y));
            }
        }
        while (ok && MyPars.isNormal(x,y));
        // влево
        y = this.getCoordinates().getY();
        do
        {
            x = x - 1;
            ok2 = MyPars.isNormal(x,y);
            if (ok2)
            {
                ok = this.getmatr()[x][y] == null;
            }else {ok = false;}
            if ( ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor())))
            {
                this.tList.add(new MyPars(x,y));
            }
        }
        while (ok && MyPars.isNormal(x,y));
        // вверх
        x = this.getCoordinates().getX();
        do
        {
            y = y + 1;
            ok2 = MyPars.isNormal(x,y);
            if (ok2)
            {
                ok = this.getmatr()[x][y] == null;
            }else {ok = false;}
            if ( ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor())))
            {
                this.tList.add(new MyPars(x,y));
            }
        }
        while (ok && MyPars.isNormal(x,y));
        y = this.getCoordinates().getY();

        // как слон
        // верхний правый угол
        do
        {
            x = x + 1;
            y = y + 1;
            ok2 = MyPars.isNormal(x,y);
            if (ok2)
            {
                ok = this.getmatr()[x][y] == null;
            }else {ok = false;}
            if ( ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor())))
            {
                this.tList.add(new MyPars(x,y));
            }
        }
        while (ok && ok2);

        // нижний правый угол
        x = this.getCoordinates().getX();
        y = this.getCoordinates().getY();
        do
        {
            x = x + 1;
            y = y - 1;
            ok2 = MyPars.isNormal(x,y);
            if (ok2)
            {
                ok = this.getmatr()[x][y] == null;
            }else {ok = false;}
            if ( ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor())))
            {
                this.tList.add(new MyPars(x,y));
            }
        }
        while (ok && MyPars.isNormal(x,y));
        // нижний левый угол
        x = this.getCoordinates().getX();
        y = this.getCoordinates().getY();
        do
        {
            x = x - 1;
            y = y - 1;
            ok2 = MyPars.isNormal(x,y);
            if (ok2)
            {
                ok = this.getmatr()[x][y] == null;
            }else {ok = false;}
            if ( ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor())))
            {
                this.tList.add(new MyPars(x,y));
            }
        }
        while (ok && MyPars.isNormal(x,y));
        // верхний левый угол
        x = this.getCoordinates().getX();
        y = this.getCoordinates().getY();
        do
        {
            x = x - 1;
            y = y + 1;
            ok2 = MyPars.isNormal(x,y);
            if (ok2)
            {
                ok = this.getmatr()[x][y] == null;
            }else {ok = false;}
            if ( ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor())))
            {
                this.tList.add(new MyPars(x,y));
            }
        }
        while (ok && MyPars.isNormal(x,y));
    }

    public CQueen(int x, int y, boolean ok, FigureAbstractClass[][] m, FigureAbstractClass k,
                  LinkedList<FigureAbstractClass>  oL, LinkedList<FigureAbstractClass> eL)
    {
        super(x,y, ok, m, k, oL, eL);
        this.setFigureType( eFigureType.queen );
    }
}
