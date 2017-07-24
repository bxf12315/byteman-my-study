package com.redhat.study;

public class ThreadOne implements Runnable
{
    private InterfaceOne interfaceOne;

    public void setInterfaceOne( InterfaceOne interfaceOne)
    {
        this.interfaceOne = interfaceOne;
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
        interfaceOne.methodOne();
    }
}