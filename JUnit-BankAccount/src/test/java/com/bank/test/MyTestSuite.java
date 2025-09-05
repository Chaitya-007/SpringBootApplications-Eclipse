package com.bank.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    BankAccountTest.class
})
public class MyTestSuite {

}
