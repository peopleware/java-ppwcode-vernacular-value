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


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


@SuppressWarnings("unchecked")
public class _Contract_MutableValue extends _Contract_<MutableValue> {

  public _Contract_MutableValue() {
    super(MutableValue.class);
  }

  @Override
  public void assertInvariants(MutableValue mv) {
    super.assertInvariants(mv);
  }

  public void assertClone(MutableValue mv, MutableValue result) {
    assertNotSame(mv, result);
    assertEquals(mv, result);
  }

}

