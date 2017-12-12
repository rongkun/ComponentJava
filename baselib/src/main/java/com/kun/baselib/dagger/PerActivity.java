package com.kun.baselib.dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Created by kun on 2017/1/17
 * Explain:
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
