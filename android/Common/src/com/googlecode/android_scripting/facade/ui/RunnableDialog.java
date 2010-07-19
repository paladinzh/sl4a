/*
 * Copyright (C) 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.googlecode.android_scripting.facade.ui;

import android.app.Dialog;

import com.googlecode.android_scripting.activity.ScriptingLayerServiceHelper;
import com.googlecode.android_scripting.future.FutureActivityTask;
import com.googlecode.android_scripting.future.FutureResult;

import java.util.concurrent.CountDownLatch;

abstract class RunnableDialog extends FutureActivityTask<Object> {

  protected ScriptingLayerServiceHelper mActivity;
  protected Dialog mDialog;
  protected FutureResult<Object> mFutureResult;
  protected final CountDownLatch mShowLatch = new CountDownLatch(1);

  /**
   * Returns the wrapped {@link Dialog}.
   */
  public Dialog getDialog() {
    return mDialog;
  }

  /**
   * Dismiss the {@link Dialog} and close {@link Sl4aActivity}.
   */
  public void dismissDialog() {
    if (mDialog != null) {
      mDialog.dismiss();
      mActivity.taskDone(getTaskId());
    }
    mDialog = null;
  }

  /**
   * Returns the {@link CountDownLatch} that is counted down when the dialog is shown.
   */
  public CountDownLatch getShowLatch() {
    return mShowLatch;
  }
}
