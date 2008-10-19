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

package org.ppwcode.vernacular.value_III.stubs;

import org.ppwcode.vernacular.value_III.AbstractValueEditor;


public class StubAbstractValueEditor extends AbstractValueEditor<StubAbstractValue> {

  private final static StubAbstractValue DUMMY = new StubAbstractValue();

  @Override
  public void setAsText(String text) {
    if (text == null) {
      setValue(null);
    }
    else {
      setValue(DUMMY);
    }
  }


  @Override
  public String getAsText() {
    if (getValue() == null) {
      return null;
    }
    else {
      return "DUMMY";
    }
  }

}

