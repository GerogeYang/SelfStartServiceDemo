// IMyAidlInterface.aidl
package com.tcl.selfstartservicedemo;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void setVal(int value);
    int getVal();
}
