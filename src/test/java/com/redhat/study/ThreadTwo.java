package com.redhat.study;

import java.util.HashMap;

public class ThreadTwo implements Runnable
{
    private InerfaceTwo interfaceTwo;

    private HashMap map;
    public void setInterfaceOne( InerfaceTwo interfaceOne)
    {
        this.interfaceTwo = interfaceOne;
    }

    public void setMap(HashMap map)
    {
        this.map = map;
    }
    public void run()
    {
        try
        {
            Thread.sleep( 50 );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
        interfaceTwo.methodTwo(map);
    }
}
