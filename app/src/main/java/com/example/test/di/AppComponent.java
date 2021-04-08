package com.example.test.di;

import com.example.test.viewmodel.MyViewModel;

import dagger.Component;

@Component(modules = {DaggerModule.class})
public interface AppComponent {

    void inject(MyViewModel myViewModel);

}
