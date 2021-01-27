package org.jetbrains.scala.samples;

import com.intellij.DynamicBundle;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

public class SamplePluginBundle extends DynamicBundle {
    @NonNls
    private static final String BUNDLE = "messages.SamplePluginBundle";

    private static final SamplePluginBundle INSTANCE = new SamplePluginBundle();

    private SamplePluginBundle() {
        super(BUNDLE);
    }

    @Nls
    public static String message(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, @NotNull Object... params) {
        return INSTANCE.getMessage(key, params);
    }
}