package com.kun.modulea.dagger;

import com.kun.baselib.dagger.AppComponent;
import com.kun.baselib.dagger.PerActivity;
import com.kun.modulea.atest.ATestActivity;

import dagger.Component;

/**
 * @author kun
 * @date 2017/12/7
 */

@PerActivity
@Component(dependencies = AppComponent.class,modules = {AmoduleModule.class})
public interface AmoduleComponent {
    void inject(ATestActivity aTestActivity);
}
