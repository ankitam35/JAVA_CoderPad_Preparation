
/**
 * Implement addFractions() correctly.
 */

import java.util.*;

public class Solution
{
  /**
   * Implement the method that provided numerator and denominator will return a string representing fraction's decimal form.
   * Some fractions in decimal form have cyclic decimal points.
   *
   * Examples:
   * 1/2 = 0.5
   * 1/3 = 0.(3)
   */
  public static String vulgarToDecimal(Long numerator, Long denominator)
  {
    if(denominator <= 0) throw new IllegalArgumentException("denominator must be a positive number");

    boolean isNegative = numerator < 0;
    numerator = Math.abs(numerator);

    Long integer = numerator / denominator;
    numerator = numerator % denominator;

    Set<Long> reminders = new LinkedHashSet<>();
    Long cycleBeginsAtReminder = -1l;

    while(numerator != 0) {
      numerator *= 10;

      Long reminder = numerator % denominator;

      if(reminders.contains(numerator)) {
        cycleBeginsAtReminder = numerator;
        break;
      }

      reminders.add(numerator);
      numerator = reminder;
    }

    StringBuffer buffer =  new StringBuffer();
    if(isNegative) buffer.append('-');
    buffer.append(integer);

    if(!reminders.isEmpty()) {
      buffer.append('.');

      for(Long reminder : reminders) {
        if(Objects.equals(reminder, cycleBeginsAtReminder)) {
          buffer.append('(');
        }

        buffer.append(reminder / denominator);
      }

      if(cycleBeginsAtReminder != -1l)
      {
        buffer.append(')');
      }
    }

    return buffer.toString();
  }

  /**
   * boolean doTestsPass()
   * Returns true if all tests pass. Otherwise false
   */
  public static boolean doTestsPass()
  {
    boolean testsPassed = true;

    testsPassed &= vulgarToDecimal(1l, 2l).equals("0.5");
    testsPassed &= vulgarToDecimal(1l, 3l).equals("0.(3)");
    testsPassed &= vulgarToDecimal(1l, 30l).equals("0.0(3)");
    testsPassed &= vulgarToDecimal(1l, 75l).equals("0.01(3)");
    testsPassed &= vulgarToDecimal(4l, 7l).equals("0.(571428)");
    testsPassed &= vulgarToDecimal(1l, 56l).equals("0.017(857142)");

    if(testsPassed) {
      System.out.println("Tests passes");
    } else {
      System.out.println("Tests failed");
    }
    return testsPassed;
  }

  public static void main(String[] args) {
    doTestsPass();
  }
}
