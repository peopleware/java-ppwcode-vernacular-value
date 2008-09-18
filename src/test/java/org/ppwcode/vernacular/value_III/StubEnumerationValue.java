/*<license>
  Copyright 2008, PeopleWare n.v.
  NO RIGHTS ARE GRANTED FOR THE USE OF THIS SOFTWARE, EXCEPT, IN WRITING,
  TO SELECTED PARTIES.
</license>*/

package org.ppwcode.vernacular.value_III;


import static java.util.Collections.unmodifiableMap;

import java.util.HashMap;
import java.util.Map;

import org.toryt.annotations_I.Expression;
import org.toryt.annotations_I.MethodContract;


public class StubEnumerationValue extends EnumerationValue {

  /**
   * The string that is used internally to identify
   * value 1.
   *
   * = {@value}
   */
  public static final String VALUE_1_STRING = "DISCRIMINATING_STRING_1";

  /**
   * The string that is used internally to identify
   * value 2.
   *
   * = {@value}
   */
  public static final String VALUE_2_STRING = "DISCRIMINATING_STRING_2";

  /**
   * The string that is used internally to identify
   * value 3.
   *
   * = {@value}
   */
  public static final String VALUE_3_STRING = "DISCRIMINATING_STRING_3";


  /**
   * The string that is used internally to identify
   * default value.
   *
   * = {@value}
   */
  public static final String VALUE_DEFAULT_STRING = "DISCRIMINATING_STRING_DEFAULT";

  /**
   * The instance representing value 1.
   */
  public static final StubEnumerationValue VALUE_1 =
      new StubEnumerationValue(VALUE_1_STRING);

  /**
   * The instance representing value 2.
   */
  public static final StubEnumerationValue VALUE_2 =
      new StubEnumerationValue(VALUE_2_STRING);

  /**
   * The instance representing value 3.
   */
  public static final StubEnumerationValue VALUE_3 =
      new StubEnumerationValue(VALUE_3_STRING);

  /**
   * The instance representing default value.
   */
  public static final StubEnumerationValue VALUE_DEFAULT =
      new StubEnumerationValue(VALUE_DEFAULT_STRING);

  public static final Map<String, StubEnumerationValue> VALUES = generateValues();

  private static Map<String, StubEnumerationValue> generateValues() {
    Map<String, StubEnumerationValue> result = new HashMap<String, StubEnumerationValue>();
    result.put(VALUE_1.toString(), VALUE_1);
    result.put(VALUE_2.toString(), VALUE_2);
    result.put(VALUE_3.toString(), VALUE_3);
    result.put(VALUE_DEFAULT.toString(), VALUE_DEFAULT);
    return unmodifiableMap(result);
  }

  /**
   * @param     discriminator
   *            The string that discriminates this value.
   */
  @MethodContract(
    pre  = {
      @Expression("_discriminator != null"),
      @Expression("_discriminator.length > 0")
    },
    post = @Expression("result.toString().equals(_discriminator)")
  )
  private StubEnumerationValue(final String discriminator) {
    super(discriminator);
  }

  /**
   * Enumeration types require a default constructor for serializability.
   * It is ill-advised to use this default constructor yourself. Use the constants instead.
   */
  @MethodContract(post = @Expression("result.equals(VALUE_DEFAULT)"))
  public StubEnumerationValue() {
    this(VALUE_DEFAULT_STRING);
  }

}

