package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class CPawn extends FigureAbstractClass{

    //region Все для создания листа из возможных точек хода

    private boolean aM (int x, int y)
    {
        // this.getCoordinates().getY() == 1 - для прыжка пешки
        if ( this.getColor() == false )
        {
            int y2 = this.getCoordinates().getY() + 1;
            if ( y == y2 )
            {
                return true;
            }

            if ( this.getCoordinates().getY() == 1 )
            {
                if ( this.getmatr() [x][y2] == null && y == this.getCoordinates().getY() + 2)
                {
                    return true;
                }
            }
        }

        if ( this.getColor() == true )
        {
            int y2 = this.getCoordinates().getY() - 1;
            if ( y == y2 )
            {
                return true;
            }

            if ( this.getCoordinates().getY() == 6 )
            {
                if ( this.getmatr() [x][y2] == null && y == this.getCoordinates().getY() - 2)
                {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean aH (int x, int y)
    {
        if ( this.getColor() == false )
        {
            if ( x == this.getCoordinates().getX() + 1 && y == this.getCoordinates().getY() + 1 )
            {
                return true;
            }

            if ( x == this.getCoordinates().getX() - 1 && y == this.getCoordinates().getY() + 1 )
            {
                return true;
            }
        }

        if ( this.getColor() == true)
        {
            if ( x == this.getCoordinates().getX() + 1 && y == this.getCoordinates().getY() - 1 )
            {
                return true;
            }

            if ( x == this.getCoordinates().getX() - 1 && y == this.getCoordinates().getY() - 1 )
            {
                return true;
            }
        }
        return false;
    }
    /**вспомогательная для getStepList*/
    private void gSL (int e)
    {
        this.tList = new LinkedList<MyPars>() ;
        int tx = this.getCoordinates().getX();
        int ty = this.getCoordinates().getY() + e;
        if (MyPars.isNormal(tx,ty) && aM(tx,ty))
        {
            this.tList.add(new MyPars(tx, ty));
        }

        tx = this.getCoordinates().getX();
        ty = this.getCoordinates().getY() + 2 * e;
        if (MyPars.isNormal(tx,ty) && aM(tx,ty))
        {
            this.tList.add(new MyPars(tx, ty));
        }

        tx = this.getCoordinates().getX() - 1;
        ty = this.getCoordinates().getY() + e;
        if (MyPars.isNormal(tx,ty) && aH(tx,ty))
        {
            this.tList.add(new MyPars(tx, ty));
        }

        tx = this.getCoordinates().getX() + 1;
        ty = this.getCoordinates().getY() + e;
        if (MyPars.isNormal(tx,ty) && aH(tx,ty))
        {
            this.tList.add(new MyPars(tx, ty));
        }
    }

    /**возвращает все точки хода*/
    protected void setAllT ()
    {
        if ( this.getColor() == false )
        {
            gSL(1);
        } else
        {
            gSL(-1);
        }
    }
    //endregion

    public CPawn( int x, int y,boolean ok, FigureAbstractClass[][] m, FigureAbstractClass k ,
                  LinkedList<FigureAbstractClass>  oL, LinkedList<FigureAbstractClass> eL )
    {
        super(x, y, ok , m, k, oL , eL);
        this.setFigureType( eFigureType.pawn );
    }

    /**чекает удары пешки в разные стороны
     * e если пешка белая то +1, если черная то -1*/
    private boolean cTHFTF ( int e )
    {
        int x = this.getCoordinates().getX() + 1;
        int y = this.getCoordinates().getY() + e;
        if (MyPars.isNormal(x,y) && this.getmatr()[x][y]!= null && this.getmatr()[x][y] != null && this.getmatr()[x][y].getColor() != this.getColor()
                && this.getmatr()[x][y].getFigureType() == eFigureType.king)
        {
            return true;
        }

        x = this.getCoordinates().getX() - 1;
        y = this.getCoordinates().getY() + e;
        if (MyPars.isNormal(x,y) && this.getmatr()[x][y]!= null && this.getmatr()[x][y].getColor() != this.getColor()
                && this.getmatr()[x][y].getFigureType() == eFigureType.king)
        {
            return true;
        }
        return false;
    }

    /**вызвается в главной программе после step
     * trye - моет втащить королю*/
    @Override
    protected boolean checkTheKingForThisFigure ()
    {
        if ( this.getColor() == false )
        {
            cTHFTF(1);
        }

        if ( this.getColor() == true )
        {
            cTHFTF(-1);
        }
        return false;
    }

    /** ход фигуры */
    @Override
    public eAnswer step (int x, int y)
    {
        setAllT();
        eAnswer result;
        if ( this.getmatr()[x][y] == null )
        {
            if (ability(x, y))
            {
                result =  this.move(x,y);
                if ((this.getCoordinates().getY() == 0 ||  this.getCoordinates().getY() == 7) && result != eAnswer.checkTheKing)
                {
                    result = eAnswer.swap;
                }
                return result;
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
                    result =  this.hit(x,y);
                    if ((this.getCoordinates().getY() == 0 ||  this.getCoordinates().getY() == 7) && result != eAnswer.checkTheKing)
                    {
                        result = eAnswer.swap;
                    }
                    return result;
                }
                else
                {
                    return eAnswer.canNotCut;
                }
            }
        }
        return  eAnswer.successfully;
    }

    @Override
    public eAnswer pseudoStep ( int x, int y )
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
}
