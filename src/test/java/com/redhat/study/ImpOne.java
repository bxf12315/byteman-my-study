package com.redhat.study;

import java.util.Date;
import java.util.HashMap;

public class ImpOne implements InterfaceOne ,InerfaceTwo
{
    public void methodOne ()
    {
        Date date = new Date(  );
        System.out.println( "One is running time stamp == " +date.toLocaleString());
    }

    public void methodTwo(HashMap map)
    {
        Date date = new Date(  );
        System.out.println( "One is running time stamp == " +date.toLocaleString());
        map.put( "1","1" );
    }
}