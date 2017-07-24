package com.redhat.study;

import org.jboss.byteman.contrib.bmunit.BMRule;
import org.jboss.byteman.contrib.bmunit.BMRules;
import org.jboss.byteman.contrib.bmunit.BMUnitConfig;
import org.jboss.byteman.contrib.bmunit.BMUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.HashMap;

@RunWith(BMUnitRunner.class)
@BMUnitConfig( debug = true )
public class ByteManMapTest
{
    @Test

    @BMRules( rules = { @BMRule(name = "ThreadOne is running",
                    targetClass = "java.util.HashMap",
                targetMethod = "put(\"1\",\"1\")",
                    targetLocation = "ENTRY",
                    action = "debug(\"Hello world ThreadOne!!!\"); waitFor(\"waiting thread tow\");  debug(\"Hello world ThreadOne!\")" ),
                    @BMRule(name = "ThreadTwo is running",
                                    targetClass = "java.util.HashMap",
                                    targetMethod = "clear",
                                    targetLocation = "ENTRY",
                                    action = " debug(\"Hello world ThreadTwo!!!\"); signalWake(\"waiting thread tow\", true); debug(\"Hello world ThreadTwo!\")" )})
    public void two()
    {
        ThreadTwo threadOne = new ThreadTwo();
        threadOne.setInterfaceOne( new ImpOne() );

        HashMap map = new HashMap(  );
        threadOne.setMap( map );
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
        ThreadTwo threadTwo = new ThreadTwo();
        threadTwo.setInterfaceOne( new ImpTwo() );
        threadTwo.setMap( map );
        Thread t2 = new Thread( threadTwo );
        t2.start();
        Date date = new Date(  );
        System.out.println( "two is running time stamp == " +date.toLocaleString());

        try
        {
            Thread.sleep( 1500 );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
    }

    @Test
    @BMRules( rules = { @BMRule(name = "ThreadOne is running",
                    targetClass = "ImpOne",
                    targetMethod = "methodTwo",
                    targetLocation = "ENTRY",
                    action = "debug(\"Hello world ThreadOne!!!\"); waitFor(\"waiting thread tow\");  debug(\"Hello world ThreadOne!\")" ),
                    @BMRule(name = "ThreadTwo is running",
                                    targetClass = "ImpTwo",
                                    targetMethod = "methodTwo",
                                    targetLocation = "ENTRY",
                                    action = " debug(\"Hello world ThreadTwo!!!\"); signalWake(\"waiting thread tow\", true); debug(\"Hello world ThreadTwo!\")" )})
    public void test()
    {
        ThreadTwo threadOne = new ThreadTwo();
        threadOne.setInterfaceOne( new ImpOne() );

        HashMap map = new HashMap(  );
        threadOne.setMap( map );
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
        ThreadTwo threadTwo = new ThreadTwo();
        threadTwo.setInterfaceOne( new ImpTwo() );
        threadTwo.setMap( map );
        Thread t2 = new Thread( threadTwo );
        t2.start();
        Date date = new Date(  );
        System.out.println( " is running time stamp == " +date.toLocaleString());

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
