/*<license>
Copyright 2004 - $Date: 2008-11-12 21:00:43 +0100 (wo, 12 nov 2008) $ by PeopleWare n.v..

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

package org.ppwcode.vernacular.value_III.hibernate3;


import static org.ppwcode.metainfo_I.License.Type.APACHE_V2;

import org.hibernate.HibernateException;
import org.ppwcode.metainfo_I.Copyright;
import org.ppwcode.metainfo_I.License;
import org.ppwcode.metainfo_I.vcs.SvnInfo;
import org.ppwcode.vernacular.value_III.ImmutableValue;
import org.toryt.annotations_I.Basic;
import org.toryt.annotations_I.Expression;
import org.toryt.annotations_I.MethodContract;


/**
 * <p>Hibernate 3 user type support for immutable value types implemented with respect to the ppwcode value vernacular.</p>
 *
 * @author    Jan Dockx
 * @author    PeopleWare NV
 */
@Copyright("2008 - $Date: 2008-11-12 21:00:43 +0100 (wo, 12 nov 2008) $, PeopleWare n.v.")
@License(APACHE_V2)
@SvnInfo(revision = "$Revision: 3517 $",
         date     = "$Date: 2008-11-12 21:00:43 +0100 (wo, 12 nov 2008) $")
public abstract class AbstractImmutableValueCompositeUserType extends AbstractValueUserType {

  @Override
  @Basic
  public abstract Class<? extends ImmutableValue> returnedClass();

  /**
   * Returns {@code value}, because this is an immutable value type.
   */
  @MethodContract(post = @Expression("_value"))
  public final Object deepCopy(Object value) throws HibernateException {
    return value;
  }

  public final void setPropertyValue(Object object, int property, Object value) {
    throw new UnsupportedOperationException(returnedClass() + " is immutable");
  }

}
