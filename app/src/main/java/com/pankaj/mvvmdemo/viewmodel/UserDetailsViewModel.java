/**
 * Copyright 2018 Pankaj Kushwaha
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pankaj.mvvmdemo.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.pankaj.mvvmdemo.BR;
import com.pankaj.mvvmdemo.model.UserDetails;

public class UserDetailsViewModel extends BaseObservable {

    private UserDetails userDetails;

    @Bindable
    public String message = null;

    public UserDetailsViewModel() {
        userDetails = new UserDetails();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyPropertyChanged(BR.message);
    }

    public void afterNameTextChanged(CharSequence s) {
        userDetails.setName(s.toString());
    }

    public void afterEmailTextChanged(CharSequence s) {
        userDetails.setEmail(s.toString());
    }

    public void onSubmitClicked() {
        if (userDetails.getName() != null && userDetails.getName().length() > 0 && userDetails.getEmail() != null && userDetails.getEmail().length() > 0) {
            setMessage("Below Details Submitted:\n" + userDetails.getName() + "\n" + userDetails.getEmail());
        } else {
            setMessage("Fill up details");
        }
    }
}
