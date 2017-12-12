package com.kun.moduleb.dagger;

import com.kun.baselib.dagger.AppComponent;
import com.kun.baselib.dagger.PerActivity;
import com.kun.moduleb.btest.BTestActivity;

import dagger.Component;

/**
 * @author kun
 * @date 2017/12/7
 */

@PerActivity
@Component(dependencies = AppComponent.class,modules = {BmoduleModule.class})
public interface BmoduleComponent {
    void inject(BTestActivity bTestActivity);
}
