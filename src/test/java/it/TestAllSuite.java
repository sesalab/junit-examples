package it;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Run all tests")
@SelectPackages("it")
@IncludeClassNamePatterns(".*Test")
public class TestAllSuite {
}
