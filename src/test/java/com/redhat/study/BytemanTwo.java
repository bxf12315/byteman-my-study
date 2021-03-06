package com.redhat.study;

import org.jboss.byteman.contrib.bmunit.BMScript;
import org.jboss.byteman.contrib.bmunit.BMUnitConfig;
import org.jboss.byteman.contrib.bmunit.BMUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

@RunWith(BMUnitRunner.class)
@BMScript(value="config.btm")
@BMUnitConfig( debug = true )
public class BytemanTwo
{
    @Test
    public void multiRunning()
    {
        ThreadOne threadOne = new ThreadOne();
        threadOne.setInterfaceOne( new ImpOne() );
        Thread t1 = new Thread( threadOne );

        t1.start();
        try
        {
            Thread.sleep( 1500 );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
        ThreadOne threadTwo = new ThreadOne();
        threadTwo.setInterfaceOne( new ImpTwo() );
        Thread t2 = new Thread( threadTwo );
        t2.start();
        Date date = new Date(  );
        System.out.println( "mutilbeRunning is running time stamp == " +date.toLocaleString());

        try
        {
            Thread.sleep( 1500 );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
    }
}
