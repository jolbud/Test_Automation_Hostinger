package listeners;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import abstractParameters.AbstractTestParameters;

public class TestNGListeners extends AbstractTestParameters implements ITestListener, IReporter{
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("*************Testcase started: " + result.getMethod().getDescription());
		try {
			resultsToFile("*************Testcase started:" + result.getMethod().getDescription(),
					"src/test/resources/results.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("*************Testcase success: " + result.getMethod().getDescription());
		try {
			resultsToFile("*************Testcase success:" + result.getMethod().getDescription(),
					"src/test/resources/results.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("*************Testcase failed:  " + result.getMethod().getDescription());
		try {
			resultsToFile("*************Testcase failed:" + result.getMethod().getDescription(),
					"src/test/resources/results.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("*************Testcase skipped:  " + result.getMethod().getDescription());
		try {
			resultsToFile("*************Testcase skipped:" + result.getMethod().getDescription(),
					"src/test/resources/results.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("*************Testing started: " + context.getName());
		try {
			resultsToFile("*************Testing started: " + context.getName(), "src/test/resources/results.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("*************Testing completed: " + context.getName());
		try {
			resultsToFile("*************Testing completed: " + context.getName(), "src/test/resources/results.txt");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		try {
	      //Iterate over every suite assigned for execution
	      for (ISuite suite : suites) {
	         String suiteName = suite.getName();
	         Map<String, ISuiteResult> suiteResults = suite.getResults();
	         for (ISuiteResult sr : suiteResults.values()) {
	            ITestContext tc = sr.getTestContext();
				resultsToFile("=========================================================================================================================", "src/test/resources/results.txt");
				resultsToFile("Test tag Name: " + tc.getName() +"  "+"Test start time: " + tc.getStartDate() +"  "+"Test end time: " + tc.getEndDate(), "src/test/resources/results.txt");
				resultsToFile("Test report output dir:  " + tc.getOutputDirectory(), "src/test/resources/results.txt");
				Collection<ITestNGMethod> failedMethods = tc.getFailedTests().getAllMethods();
				resultsToFile("Suite name: " + suiteName, "src/test/resources/results.txt");
	            float Totalcount = (tc.getFailedTests().size()+tc.getPassedTests().size()+tc.getSkippedTests().size());
	            float Passpercentage = (tc.getPassedTests().size()/Totalcount*100);
				resultsToFile("Total tests run:"+ Totalcount+"  "+"Pass percentage: "+Passpercentage+"%", "src/test/resources/results.txt");
				resultsToFile("====================================================", "src/test/resources/results.txt");
				resultsToFile("Total failed methods count: "+failedMethods.size(), "src/test/resources/results.txt");
				resultsToFile("Test methods are:  ", "src/test/resources/results.txt");
	            for(ITestNGMethod tm : failedMethods) {
					resultsToFile(tm.getMethodName()+"  "+ tm.getDescription(), "src/test/resources/results.txt");
	            }
				resultsToFile("Total passed methods count: " + tc.getPassedTests().getAllResults().size(), "src/test/resources/results.txt");
				resultsToFile("Total skipped methods count: " + tc.getSkippedTests().getAllResults().size(), "src/test/resources/results.txt");
	         }
	      }
			resultsToFile("=========================================================================================================================", "src/test/results.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	}

}
