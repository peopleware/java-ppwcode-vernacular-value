/*<license>
Copyright 2004 - $Date: 2008-08-01 00:47:01 +0200 (Fri, 01 Aug 2008) $ by PeopleWare n.v.

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

package org.ppwcode.util.resourcebundle;


import java.util.Locale;
import static org.ppwcode.metainfo_I.License.Type.APACHE_V2;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.ppwcode.metainfo_I.Copyright;
import org.ppwcode.metainfo_I.License;
import org.ppwcode.metainfo_I.vcs.SvnInfo;
import org.toryt.annotations_I.Basic;
import org.toryt.annotations_I.Expression;
import org.toryt.annotations_I.MethodContract;


/**
 * NOT GOOD VERSION; LATEST WORK IS IN SEMANTICS
 */
@Copyright("2004 - $Date: 2008-08-01 00:47:01 +0200 (Fri, 01 Aug 2008) $, PeopleWare n.v.")
@License(APACHE_V2)
@SvnInfo(revision = "$Revision: 2005 $",
         date     = "$Date: 2008-08-01 00:47:01 +0200 (Fri, 01 Aug 2008) $")
public class DefaultResourceBundleLoadStrategy
    implements ResourceBundleLoadStrategy {

  /* <property name="locale"> */
  //------------------------------------------------------------------

  @Basic(
    init = @Expression("null")
  )
  public final Locale getLocale() {
    return $locale;
  }

  /**
   * @param     locale
   *            The new value for the locale.
   */
  @MethodContract(post = @Expression("locale == _locale"))
  public final void setLocale(final Locale locale) {
    $locale = locale;
  }

  private Locale $locale;

  /* </property> */



  private static final String EMPTY = "";

  /**
   * <p>Load a resource bundle with the given <code>basename</code>,
   *   according to this strategy.</p>
   * <p>If the {@ink #getLocale()} is not {@code null}, we try to retrieve
   *   the {@link ResourceBundle}-tree for the resource
   *   <code><var>basename</var> + &quot;_&quot; + {@link #getLocale()}.toString()</code>.
   *   If the {@ink #getLocale()} is {@code null}, we try to retrieve
   *   the {@link ResourceBundle}-tree for the resource
   *   <code><var>basename</var> + &quot;_&quot; + {@link Locale#getDefault()}.toString()</code>.
   *   The method returns <code>null</code> if no resource bundle was found.</p>
   */
  @MethodContract(
    post = {
      @Expression("_basename == null || _basename == EMPTY ? null"),
      @Expression("locale != null ? ResourceBundle.getBundle(_basename, locale)"),
      @Expression("locale == null ? ResourceBundle.getBundle(_basename, Locale.default)")
    }
  )
  public ResourceBundle loadResourceBundle(final String basename) {
    ResourceBundle result = null;
    if ((basename != null) && (!basename.equals(EMPTY))) {
      Locale locale = null;
      if (getLocale() != null) {
        locale = getLocale();
      }
      else {
        locale = Locale.getDefault();
      }
      try {
        result = ResourceBundle.getBundle(basename, locale);
        // throws MissingResourceException
      }
      catch (MissingResourceException mrExc) {
        // NOP we will return null
      }
    }
    return result;
  }



  @Override
  public String toString() {
    return super.toString() + "[" + getLocale() + "]";
  }

}
