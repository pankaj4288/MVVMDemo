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

package com.pankaj.mvvmdemo;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pankaj.mvvmdemo.databinding.ActivityMainBinding;
import com.pankaj.mvvmdemo.viewmodel.UserDetailsViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new UserDetailsViewModel());
        binding.executePendingBindings();
    }

    @BindingAdapter({"showToast"})
    public static void showToast(View view, String message) {
        if(message!=null) {
            Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
        }
    }
}
