package com.company;

import java.util.LinkedList;

// еееееееееееееееееее рРРООООООК!!!!!!!
public class CRook extends FigureAbstractClass {

    protected void setAllT ()
    {
        this.tList = new LinkedList<MyPars>();
        int x = this.getCoordinates().getX();
        int y = this.getCoordinates().getY();
        boolean ok;
        boolean ok2;
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
    }

    public CRook(int x, int y, boolean ok, FigureAbstractClass[][] m, FigureAbstractClass k ,
                 LinkedList<FigureAbstractClass>  oL, LinkedList<FigureAbstractClass> eL)
    {
        super(x,y,ok , m, k, oL, eL);
        this.setFigureType( eFigureType.rook );
    }

    @Override
    protected eAnswer move (int x, int y)
    {
        eAnswer answer = eAnswer.successfully;
        // выполняю ход
        this.getmatr()[x][y] = this;
        this.getmatr()[this.getCoordinates().getX()][this.getCoordinates().getY()] = null;

        // чекаю есть ли шаг королю после хода игрока
        if (checkTheKing())
        {
            //если есть возвращаю все назад
            this.getmatr()[this.getCoordinates().getX()][this.getCoordinates().getY()] = this.getmatr()[x][y];
            this.getmatr()[x][y] = null;
            answer = eAnswer.checkTheKing;
        }else
        {
            // если все четко, заканчиваю ход
            this.SetCoordinates(x,y);
            this.getKing().posibleCastling();
        }
        return answer;
    }

    @Override
    protected eAnswer hit (int x, int y)
    {
        // выполняю удар
        Object f = this.getmatr()[x][y];
        eAnswer answer = figureTypeToAnswer(this.getmatr()[x][y].figureType);
        // вот тут може быть интересный момент с удалением
        this.enemyList.remove(this.getmatr()[x][y]);
        this.getmatr()[x][y] = this;
        this.getmatr()[this.getCoordinates().getX()][this.getCoordinates().getY()] = null;

        // чекаю есть ли шаг королю после хода игрока
        if (checkTheKing())
        {
            //если есть возвращаю все назад
            this.getmatr()[this.getCoordinates().getX()][this.getCoordinates().getY()] = this.getmatr()[x][y];
            this.getmatr()[x][y] = (FigureAbstractClass)f;
            enemyList.add(this.getmatr()[x][y]);
            answer = eAnswer.checkTheKing;
        }else
        {
            // если все четко, заканчиваю ход
            this.SetCoordinates(x,y);
            this.getKing().posibleCastling();
        }
        return answer;
    }
}
