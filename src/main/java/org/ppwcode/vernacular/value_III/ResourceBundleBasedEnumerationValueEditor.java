/*<license>
Copyright 2004 - $Date$ by PeopleWare n.v..

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</license>*/

package org.ppwcode.vernacular.value_III;


import java.util.ResourceBundle;

import org.ppwcode.util.resourcebundle.DefaultResourceBundleLoadStrategy;
import org.ppwcode.util.resourcebundle.ResourceBundleLoadStrategy;
import org.ppwcode.util.resourcebundle.ResourceBundles;


/**
 * <p>This class provides an implementation for an
 *   {@link EnumerationValueEditor} that returns labels for enumeration
 *   type values defined in a resource bundle, normally backed by a
 *   properties file.</p>
 * <p>The implementation expects a properties file next to this class
 *   with as name
 *   <kbd><var>getEnumerationValue().getClass().getName()</var><var>_locale_identification</var>.properties</kbd>,
 *   The <kbd><var>_locale_identification</var></kbd> should
 *   follow the traditional rules (see {@link ResourceBundle}.
 *   In this file, there should be an entry with as key
 *   <code>label.<var>tag</var></code>, where <code><var>tag</var></code>
 *   is the programmatic string representation of an enumeration type
 *   value as returned by {@link #getAsText()}, for each value returned
 *   by {@link #getTags()}.</p>
 * <p>The resource bundle is located using the current
 *   {@link #getResourceBundleLoadStrategy() ResourceBundleLoadStrategy}.</p>
 *
 * @author    Jan Dockx
 * @author    PeopleWare n.v.
 */
public abstract class ResourceBundleBasedEnumerationValueEditor
    extends AbstractEnumerationValueEditor {

  /*<section name="Meta Information">*/
  //------------------------------------------------------------------

  /** {@value} */
  public static final String CVS_REVISION = "$Revision$"; //$NON-NLS-1$
  /** {@value} */
  public static final String CVS_DATE = "$Date$"; //$NON-NLS-1$
  /** {@value} */
  public static final String CVS_STATE = "$State$"; //$NON-NLS-1$
  /** {@value} */
  public static final String CVS_TAG = "$Name$"; //$NON-NLS-1$

  /*</section>*/


  /**
   * The string pre- and postpended to the {@link #getAsText()} String
   * for the label, if no matching entry was found in the resource bundle.
   *
   * <strong>value = {@value}</strong>
   */
  public static final String LABEL_NOT_FOUND_TOKEN = "???"; //$NON-NLS-1$

  /**
   * Return the a label from the {@link #getResourceBundleBasename()}
   * resource bundle, with key {@link #getLabelKey()}. If the resource
   * bundle is not found, or the key is not found in the resource
   * bundle, the String
   * <code>LABEL_NOT_FOUND_TOKEN + getAsText() + LABEL_NOT_FOUND_TOKEN</code>
   * is returned.
   */
  public final String getLabel() {
    String result = ResourceBundles.findKeyWithBasename(getResourceBundleBasename(),
                                                        new String[] {getLabelKey()},
                                                        getResourceBundleLoadStrategy());
    if (result == null) {
      result = LABEL_NOT_FOUND_TOKEN + getAsText() + LABEL_NOT_FOUND_TOKEN;
    }
    return result;
  }

  /*<property name="localizedMessageResourceBundleLoadStrategy">*/
  //------------------------------------------------------------------

  /**
   * @basic
   * @init result instanceof DefaultResourceBundleLoadStrategy;
   */
  public final ResourceBundleLoadStrategy getResourceBundleLoadStrategy() {
    return $resourceBundleLoadStrategy;
  }

  /**
   * @param     strategy
   *            The new resource bundle load strategy.
   * @post      getResourceBundleLoadStrategy() == strategy;
   */
  public final void setResourceBundleLoadStrategy(
                        final ResourceBundleLoadStrategy strategy) {
    $resourceBundleLoadStrategy = strategy;
  }

  ResourceBundleLoadStrategy $resourceBundleLoadStrategy =
      new DefaultResourceBundleLoadStrategy();

  /*</property>*/



  /*<property name="resourceBundleBasename">*/
  //------------------------------------------------------------------

  /**
   * @return    getEnumerationValue().getClass().getName();
   */
  public final String getResourceBundleBasename() {
    return getEnumerationValueType().getName();
  }

  /*</property>*/



  /*<property name="labelKey">*/
  //------------------------------------------------------------------

  /**
   * @return "label." + getAsText();
   */
  public final String getLabelKey() {
    return "label." + getAsText(); //$NON-NLS-1$
  }

  /*</property>*/

}
