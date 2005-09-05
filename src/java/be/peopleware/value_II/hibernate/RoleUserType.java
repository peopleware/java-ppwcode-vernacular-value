package be.peopleware.value_II.hibernate;


import be.peopleware.value_II.Role;
import be.peopleware.value_II.RoleEditor;


/**
 * Hibernate mapping for {@link Role}. A single letter code is stored in
 * a VARCHAR.
 *
 * @author    Jan Dockx
 * @author    David Van Keer
 * @author    Peopleware n.v.
 */
public final class RoleUserType extends AbstractEnumerationUserType {

  /*<section name="Meta Information">*/
  //  ------------------------------------------------------------------

  /** {@value} */
  public static final String CVS_REVISION = "$Revision$"; //$NON-NLS-1$
  /** {@value} */
  public static final String CVS_DATE = "$Date$"; //$NON-NLS-1$
  /** {@value} */
  public static final String CVS_STATE = "$State$"; //$NON-NLS-1$
  /** {@value} */
  public static final String CVS_TAG = "$Name$"; //$NON-NLS-1$

  /*</section>*/

  public RoleUserType() {
    super(new RoleEditor());
  }

}