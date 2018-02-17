package com.company;

import java.util.LinkedList;

public class СKing extends FigureAbstractClass {

    private boolean okLeft;
    private boolean okRight;
    private LinkedList<MyPars> hitList;

    /** во восех потомках кроме короля ниче не далет
     * определяет возможность ракировки*/
    @Override
    protected void posibleCastling()
    {
        // для людей
        if (!this.getColor())
        {
            if (okLeft && this.getmatr()[0][0] == null)
            {
                okLeft = false;
            }
            if (okRight && this.getmatr()[0][7] == null)
            {
                okRight = false;
            }
        }
        else // для нигеров
            {
                if (okLeft && this.getmatr()[7][0] == null)
                {
                    okLeft = false;
                }
                if (okRight && this.getmatr()[7][7] == null)
                {
                    okRight = false;
                }
            }

    }

    protected void setAllHit () {
        this.hitList = new LinkedList<MyPars>();
        int x = this.getCoordinates().getX();
        int y = this.getCoordinates().getY();
        boolean ok;
        boolean ok2;
        // как ладья
        // вправо
        x = x + 1;
        ok2 = MyPars.isNormal(x, y);
        if (ok2) {
            ok = this.getmatr()[x][y] == null;
        } else {
            ok = false;
        }
        if (ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor()))) {
            this.hitList.add(new MyPars(x, y));
        }

        // вниз
        x = this.getCoordinates().getX();
        y = y - 1;
        ok2 = MyPars.isNormal(x, y);
        if (ok2) {
            ok = this.getmatr()[x][y] == null;
        } else {
            ok = false;
        }
        if (ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor()))) {
            this.hitList.add(new MyPars(x, y));
        }

        // влево
        y = this.getCoordinates().getY();
        x = x - 1;
        ok2 = MyPars.isNormal(x, y);
        if (ok2) {
            ok = this.getmatr()[x][y] == null;
        } else {
            ok = false;
        }
        if (ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor()))) {
            this.hitList.add(new MyPars(x, y));
        }

        // вверх
        x = this.getCoordinates().getX();
        y = y + 1;
        ok2 = MyPars.isNormal(x, y);
        if (ok2) {
            ok = this.getmatr()[x][y] == null;
        } else {
            ok = false;
        }
        if (ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor()))) {
            this.hitList.add(new MyPars(x, y));
        }

        y = this.getCoordinates().getY();
        // как слон
        // верхний правый угол
        x = x + 1;
        y = y + 1;
        ok2 = MyPars.isNormal(x, y);
        if (ok2) {
            ok = this.getmatr()[x][y] == null;
        } else {
            ok = false;
        }
        if (ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor()))) {
            this.hitList.add(new MyPars(x, y));
        }

        // нижний правый угол
        x = this.getCoordinates().getX();
        y = this.getCoordinates().getY();
        x = x + 1;
        y = y - 1;
        ok2 = MyPars.isNormal(x, y);
        if (ok2) {
            ok = this.getmatr()[x][y] == null;
        } else {
            ok = false;
        }
        if (ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor()))) {
            this.hitList.add(new MyPars(x, y));
        }

        // нижний левый угол
        x = this.getCoordinates().getX();
        y = this.getCoordinates().getY();
        x = x - 1;
        y = y - 1;
        ok2 = MyPars.isNormal(x, y);
        if (ok2) {
            ok = this.getmatr()[x][y] == null;
        } else {
            ok = false;
        }
        if (ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor()))) {
            this.hitList.add(new MyPars(x, y));
        }

        // верхний левый угол
        x = this.getCoordinates().getX();
        y = this.getCoordinates().getY();
        x = x - 1;
        y = y + 1;
        ok2 = MyPars.isNormal(x, y);
        if (ok2) {
            ok = this.getmatr()[x][y] == null;
        } else {
            ok = false;
        }
        if (ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor()))) {
            this.hitList.add(new MyPars(x, y));
        }
    }

    protected void setAllT ()
    {
        this.tList = new LinkedList<MyPars>();
        int x = this.getCoordinates().getX();
        int y = this.getCoordinates().getY();
        boolean ok;
        boolean ok2;
        // как ладья
        // вправо
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

        // вниз
        x = this.getCoordinates().getX();
            y = y - 1;
            ok2 = MyPars.isNormal(x,y);
            if (ok2)
            {
               ok = this.getmatr()[x][y] == null;
            } else {ok = false;}
            if ( ok2 && (ok || (this.getmatr()[x][y].getColor() != this.getColor())))
            {
                this.tList.add(new MyPars(x,y));
            }

        // влево
        y = this.getCoordinates().getY();
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

        // вверх
        x = this.getCoordinates().getX();
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

        y = this.getCoordinates().getY();
        // как слон
        // верхний правый угол
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

        // нижний правый угол
        x = this.getCoordinates().getX();
        y = this.getCoordinates().getY();
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

        // нижний левый угол
        x = this.getCoordinates().getX();
        y = this.getCoordinates().getY();
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

        // верхний левый угол
        x = this.getCoordinates().getX();
        y = this.getCoordinates().getY();
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

        // рокировка
        x = this.getCoordinates().getX();
        y = this.getCoordinates().getY();
        if (this.okLeft && !this.checkTheKing())
        {
            ok = this.getmatr()[this.getCoordinates().getX() - 1][this.getCoordinates().getY()] == null &&
                    this.getmatr()[this.getCoordinates().getX() - 2][this.getCoordinates().getY()] == null &&
                    this.getmatr()[this.getCoordinates().getX() - 3][this.getCoordinates().getY()] == null;
            if (ok)
            {
                this.tList.add(new MyPars(this.getCoordinates().getX() - 2,this.getCoordinates().getY() ));
            }
        }

        if (this.okRight && !this.checkTheKing())
        {
            ok = this.getmatr()[this.getCoordinates().getX() + 1][this.getCoordinates().getY()] == null &&
                    this.getmatr()[this.getCoordinates().getX() + 2][this.getCoordinates().getY()] == null;
            if (ok)
            {
                this.tList.add(new MyPars(this.getCoordinates().getX() + 2,this.getCoordinates().getY() ));
            }
        }
    }

    /** проверяет бьет ли теперь фигура короля*/
    @Override
    protected boolean checkTheKingForThisFigure ()
    {
        setAllHit();
        int i = 0;
        boolean ok = false;
        while (!ok && i < this.hitList.size() )
        {
            if (this.hitList.get(i) != null && this.getmatr()[this.hitList.get(i).getX()][this.hitList.get(i).getY()] != null)
            {
                ok = this.getmatr()[this.hitList.get(i).getX()][this.hitList.get(i).getY()].color != this.color  &&
                        this.getmatr()[this.hitList.get(i).getX()][this.hitList.get(i).getY()].getFigureType() == eFigureType.king;
            }
            ++i;
        }
        return  ok;
    }

    @Override
    protected eAnswer move (int x, int y)
    {
        int ex = 0;
        int rx = 0;
        boolean ok = false;
        eAnswer answer = eAnswer.successfully;
        // выполняю ход
        if ( Math.abs(x - this.getCoordinates().getX()) > 1)
        {
            ok = true;
            // рокировка
            if (x < this.getCoordinates().getX())
            {
                ex = this.getCoordinates().getX() - 1;
                rx = this.getCoordinates().getX() - 4;
            }
            else
                {
                    ex = this.getCoordinates().getX() + 1;
                    rx = this.getCoordinates().getX() + 3;
                }
            this.getmatr()[ex][this.getCoordinates().getY()] = this.getmatr()[rx][this.getCoordinates().getY()];
            this.getmatr()[rx][this.getCoordinates().getY()] = null;
            this.getmatr()[ex][this.getCoordinates().getY()].SetCoordinates(ex,this.getCoordinates().getY());
            this.getmatr()[x][y] = this;
            this.getmatr()[this.getCoordinates().getX()][this.getCoordinates().getY()] = null;
        }
        else
            {
               // обычный ход
                this.getmatr()[x][y] = this;
                this.getmatr()[this.getCoordinates().getX()][this.getCoordinates().getY()] = null;
            }

        // чекаю есть ли шаг королю после хода игрока
        if (checkTheKing())
        {
            //если есть возвращаю все назад
            this.getmatr()[this.getCoordinates().getX()][this.getCoordinates().getY()] = this.getmatr()[x][y];
            this.getmatr()[x][y] = null;
            if (ok)
            {
                this.getmatr()[rx][this.getCoordinates().getY()] = this.getmatr()[ex][this.getCoordinates().getY()];
                this.getmatr()[ex][this.getCoordinates().getY()] = null;
                this.getmatr()[rx][this.getCoordinates().getY()].SetCoordinates(rx,this.getCoordinates().getY());
            }

            answer = eAnswer.checkTheKing;
        }else
        {
            // если все четко, заканчиваю ход
            this.okRight = false;
            this.okLeft = false;
            this.SetCoordinates(x,y);
        }
        return answer;
    }


    public СKing(int x, int y, boolean ok, FigureAbstractClass[][] m, FigureAbstractClass k,
                 LinkedList<FigureAbstractClass>  oL, LinkedList<FigureAbstractClass> eL )
    {
        super(x,y, ok,  m, k, oL,eL);
        this.setFigureType( eFigureType.king );
        this.okRight = true;
        this.okLeft = true;
    }
}
