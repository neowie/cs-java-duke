
/**
 * Write a description of class Tester here.
 *
 * @author Seokhyun Wie
 * @version 11/02/2020
 */

import java.util.*;

public class Tester {
  public void testLogEntry() {
    LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
    System.out.println(le);
    LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
    System.out.println(le2);

  }

  public void testLogAnalyzer() {
    // complete method
    LogAnalyzer la = new LogAnalyzer();
    la.readFile("short-test_log");
    la.countUniqueIPs();
  }
}