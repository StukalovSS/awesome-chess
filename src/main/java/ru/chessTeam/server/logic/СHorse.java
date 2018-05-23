package ru.chessTeam.server.logic;
import java.util.LinkedList;

public class СHorse extends FigureAbstractClass {


    /** задает точку хода */
    private MyPars setT (int dx, int dy)
    {
        MyPars t = null;
        int tx = this.getCoordinates().getX() + dx;
        int ty = this.getCoordinates().getY() + dy;
        if ( MyPars.isNormal(tx, ty) && (this.getmatr()[tx][ty] == null || this.getmatr()[tx][ty].getColor() != this.getColor()) )
        {
            t = new MyPars(tx, ty);
        }
        return  t;
    }

    public void setAllT ()
    {
        this.tList = new LinkedList<MyPars>();
        this.tList.add(setT( - 1, + 2 ));
        this.tList.add(setT( + 1, + 2 ));
        this.tList.add(setT( + 2, + 1 ));
        this.tList.add(setT( - 2, + 1 ));
        this.tList.add(setT( - 2, - 1 ));
        this.tList.add(setT( + 2, - 1 ));
        this.tList.add(setT( - 1, - 2 ));
        this.tList.add(setT( + 1, - 2 ));
    }
    public СHorse( int x, int y ,boolean ok, FigureAbstractClass[][] m, FigureAbstractClass k,
                   LinkedList<FigureAbstractClass>  oL, LinkedList<FigureAbstractClass> eL )
    {
        super(x,y,ok, m, k, oL, eL);
        this.setFigureType( eFigureType.horse );
    }
}
