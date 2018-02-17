package com.company;
// у каждой фигуры хранится ссылка на лист с вражескими фигурами, бля удаления (когда фигура съедает другую фигуру)
// а вот зачем  я храню короля, я хз если честно
import java.util.LinkedList;

public abstract class FigureAbstractClass {

    /** 0 - успешно, 1 - не может так ходить, 2 - не может так рубить, 3 - шаг королю!!!, 4 - успешно, шаг королю!*/
    enum  eAnswer {successfully, canNotWalk, canNotCut, checkTheKing,
        hitPawn, hitHorse, hitElephant, hitRook, hitQueen, swap}
    /** 0 - пешка, 1 - конь, 2 - слон, 3 - ладья, 4 - королева, 5 - король */
    enum eFigureType { pawn, horse, elephant, rook, queen, king }

    private MyPars coordinates;

    // 0 - пешка, 1 - конь, 2 - слон, 3 - ладья, 4 - королева, 5 - король
    protected eFigureType figureType;
    // false - свет, true - тьма
    protected boolean color;
    /**шахматная доска*/
    private FigureAbstractClass[][] matr;
    private FigureAbstractClass king;
    protected LinkedList<FigureAbstractClass> enemyList;
    protected LinkedList<FigureAbstractClass> ourList;
    // координаты точек возможного хода
    protected LinkedList<MyPars> tList;

    public MyPars getCoordinates(){ return  this.coordinates; }
    public void SetCoordinates(int x, int y)
    {
        this.coordinates.setXY(x, y);
        setAllT();
    }
    public eFigureType getFigureType() { return this.figureType; }
    public void setFigureType( eFigureType t) { this.figureType = t; }
    public boolean getColor() { return this.color; }
    public FigureAbstractClass[][] getmatr() { return this.matr; }
    public FigureAbstractClass getKing() { return this.king; }
    public void setKing(FigureAbstractClass f) { this.king = f; }
    /** возвращает список возможных ходов */
    public LinkedList<MyPars> getStepList()
    {
        return this.tList;
    }

    public FigureAbstractClass( int x, int y, boolean ok,  FigureAbstractClass[][] m, FigureAbstractClass k,
                                LinkedList<FigureAbstractClass>  oL, LinkedList<FigureAbstractClass> eL)
    {
        coordinates = new MyPars(x, y);
        this.color = ok;
        this.matr = m;
        king = k;
        this.ourList = oL;
        this.enemyList = eL;
    }

    protected static eAnswer figureTypeToAnswer ( eFigureType f )
    {
        switch(f.ordinal()) {
            case 0:
                return eAnswer.hitPawn;
            case 1:
                return eAnswer.hitHorse;
            case 2:
                return eAnswer.hitElephant;
            case 3:
                return eAnswer.hitRook;
            default:
                return eAnswer.hitQueen;
        }
    }

    protected eAnswer hit (int x, int y)
    {
        // выполняю удар
        Object f = this.matr[x][y];
        eAnswer answer = figureTypeToAnswer(this.matr[x][y].figureType);
        // вот тут може быть интересный момент с удалением
        this.enemyList.remove(this.matr[x][y]);
        this.matr[x][y] = this;
        this.matr[this.coordinates.getX()][this.coordinates.getY()] = null;

        // чекаю есть ли шаг королю после хода игрока
        if (checkTheKing())
        {
            //если есть возвращаю все назад
            this.matr[this.coordinates.getX()][this.coordinates.getY()] = this.matr[x][y];
            this.matr[x][y] = (FigureAbstractClass)f;
            enemyList.add(this.matr[x][y]);
            answer = eAnswer.checkTheKing;
        }else
            {
                // если все четко, заканчиваю ход
                this.SetCoordinates(x,y);
            }
        return answer;
    }

    /** совершает сруб фигруы, возвращает инфу о том аходится ли свой короь опд ударом после этого, возвращает фигуру назад*/
    protected eAnswer pseudoHit (int x, int y)
    {
        // выполняю удар
        Object f = this.matr[x][y];
        eAnswer answer = figureTypeToAnswer(this.matr[x][y].figureType);
        // вот тут може быть интересный момент с удалением
        this.enemyList.remove(this.matr[x][y]);
        this.matr[x][y] = this;
        this.matr[this.coordinates.getX()][this.coordinates.getY()] = null;

        // чекаю есть ли шаг королю после хода игрока
        if (checkTheKing())
        {
            //если есть возвращаю все назад
            this.matr[this.coordinates.getX()][this.coordinates.getY()] = this.matr[x][y];
            this.matr[x][y] = (FigureAbstractClass)f;
            enemyList.add(this.matr[x][y]);
            answer = eAnswer.checkTheKing;
        }else
        {
            // если все четко, ВСЕРАВНО ОТКАТЫВАЮ ВСЕ НАЗАД!!!
            this.matr[this.coordinates.getX()][this.coordinates.getY()] = this.matr[x][y];
            this.matr[x][y] = (FigureAbstractClass)f;
            enemyList.add(this.matr[x][y]);
        }
        return answer;
    }

    protected eAnswer move (int x, int y)
    {
        eAnswer answer = eAnswer.successfully;
        // выполняю ход
        this.matr[x][y] = this;
        this.matr[this.coordinates.getX()][this.coordinates.getY()] = null;

        // чекаю есть ли шаг королю после хода игрока
        if (checkTheKing())
        {
            //если есть возвращаю все назад
            this.matr[this.coordinates.getX()][this.coordinates.getY()] = this.matr[x][y];
            this.matr[x][y] = null;
            answer = eAnswer.checkTheKing;
        }else
        {
            // если все четко, заканчиваю ход
            this.SetCoordinates(x,y);
        }
        return answer;
    }

    protected eAnswer pseudoMove (int x, int y)
    {
        eAnswer answer = eAnswer.successfully;
        // выполняю ход
        this.matr[x][y] = this;
        this.matr[this.coordinates.getX()][this.coordinates.getY()] = null;

        // чекаю есть ли шаг королю после хода игрока
        if (checkTheKing())
        {
            //если есть возвращаю все назад
            this.matr[this.coordinates.getX()][this.coordinates.getY()] = this.matr[x][y];
            this.matr[x][y] = null;
            answer = eAnswer.checkTheKing;
        }else
        {
            // если все четко, ВСЕРАВНО ОТКАТЫВАЮ ВСЕ НАЗАД!!!
            this.matr[this.coordinates.getX()][this.coordinates.getY()] = this.matr[x][y];
        }
        return answer;
    }

    /** проверяет находится ли король под ударом
     * эту сссаную проверку нужно делать перед каждым ходом
     * это жесть*/
    protected boolean checkTheKing ()
    {
        boolean ok = false;
        int i = 0;
        while (!ok && i < this.enemyList.size())
        {
            ok = enemyList.get(i).checkTheKingForThisFigure();
            ++i;
        }
        return ok;
    }

    /** проверяет возможность спасти короля*/
    protected boolean checkTheMAT ()
    {
        boolean ok = false;
        int i = 0;
        while (!ok && i < ourList.size() )
        {
            LinkedList<MyPars> stepList = new LinkedList<MyPars>();
            stepList = ourList.get(i).getStepList();
            int j = 0;
            while (!ok && j < stepList.size() )
            {
                ok = ourList.get(i).pseudoStep(stepList.get(j).getX(),stepList.get(j).getY()) != eAnswer.checkTheKing;
                ++j;
            }
            ++i;
        }
        return ok;
    }

    protected  boolean ability ( int x, int y)
    {
        int i = 0;
        boolean ok = false;
        while ( !ok && i < this.tList.size() )
        {
            if (this.tList.get(i) != null)
            {
                ok = this.tList.get(i).cCopison(x,y);
            }
            ++i;
        }
        return ok;
    }

    /** ход */
    public eAnswer step ( int x, int y)
    {
        setAllT();
        if ( this.getmatr()[x][y] == null )
        {
            if (ability(x, y))
            {
                return this.move(x,y);
            }
            else
            {
                return eAnswer.canNotWalk;
            }
        }
        else
        {
            if ( this.getmatr()[x][y].getColor() != this.getColor() )
            {
                if (ability(x, y))
                {
                    // выполнение удара
                    return this.hit(x,y);
                }
                else
                {
                    return eAnswer.canNotCut;
                }
            }
        }
        return  eAnswer.successfully;
    }
    /** используется для проверки checkTheMAT (в случае успеха не делает ход)*/
    public eAnswer pseudoStep ( int x, int y)
    {
        setAllT();
        if ( this.getmatr()[x][y] == null )
        {
            if (ability(x, y))
            {
                return this.pseudoMove(x,y);
            }
            else
            {
                return eAnswer.canNotWalk;
            }
        }
        else
        {
            if ( this.getmatr()[x][y].getColor() != this.getColor() )
            {
                if (ability(x, y))
                {
                    // выполнение удара
                    return this.pseudoHit(x,y);
                }
                else
                {
                    return eAnswer.canNotCut;
                }
            }
        }
        return  eAnswer.successfully;
    }

    /** проверяет бьет ли теперь фигура короля*/
    protected boolean checkTheKingForThisFigure ()
    {
        setAllT();
        int i = 0;
        boolean ok = false;
        while (!ok && i < this.tList.size() )
        {
            if (this.tList.get(i) != null && this.getmatr()[this.tList.get(i).getX()][this.tList.get(i).getY()] != null)
            {
                ok = this.getmatr()[this.tList.get(i).getX()][this.tList.get(i).getY()].color != this.color  &&
                        this.getmatr()[this.tList.get(i).getX()][this.tList.get(i).getY()].getFigureType() == eFigureType.king;
            }
            ++i;
        }
        return  ok;
    }

    /** во восех потомках кроме короля ниче не далет
     * определяет возможность ракировки*/
    protected void posibleCastling() {}

    // абстрактные методы ----------------------------------------------------------------------------------------------
    /**возвращает все точки хода*/
    protected abstract void setAllT ();
}
