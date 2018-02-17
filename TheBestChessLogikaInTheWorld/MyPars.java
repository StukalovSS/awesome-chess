package com.company;
// координаты
public class MyPars {
    private int x;
    private int y;

    public int getX() { return this.x; }
    public int getY() { return this.y; }

    public void setX( int e ) { this.x = e; }
    public void setY( int e ) { this.y = e; }
    public void setXY (int xx, int yy)
    {
        this.x = xx;
        this.y = yy;
    }

    public MyPars( int x, int y )
    {
        this.x = x;
        this.y = y;
    }

    // Coordinate Comparison
    public boolean cCopison ( int x, int y )
    {
        return this.y == y && this.x == x;
    }

    public boolean myCompereTo (MyPars p)
    {
        return this.cCopison(p.getX(),p.getY());
    }

    public static boolean isNormal ( int x, int y )
    {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }

}
