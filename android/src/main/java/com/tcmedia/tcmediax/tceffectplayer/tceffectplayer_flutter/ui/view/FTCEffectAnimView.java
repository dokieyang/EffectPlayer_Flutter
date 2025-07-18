package com.tcmedia.tcmediax.tceffectplayer.tceffectplayer_flutter.ui.view;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tencent.tcmediax.tceffectplayer.api.TCEffectAnimView;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformView;

public class FTCEffectAnimView implements PlatformView {

    private final FTCEffectAnimController mController;
    private final FTCEffectAnimViewLifecycle mLifecycle;

    public FTCEffectAnimView(@NonNull Context context, int id, @Nullable Map<String, Object> creationParams,
                             BinaryMessenger messenger) {
        this(context, id, creationParams, messenger, null);
    }

    public FTCEffectAnimView(@NonNull Context context, int id, @Nullable Map<String, Object> creationParams,
                             BinaryMessenger messenger, FTCEffectAnimViewLifecycle lifecycle) {
        this.mLifecycle = lifecycle;
        TCEffectAnimView effectView = new TCEffectAnimView(context);
        mController = new FTCEffectAnimController(id, messenger, effectView);
        if (mLifecycle != null) {
            mLifecycle.onCreate(this, id);
        }
    }

    @Nullable
    @Override
    public View getView() {
        return mController.getEffectView();
    }

    @Override
    public void dispose() {
        if (mLifecycle != null) {
            mLifecycle.onDispose(this, mController.getViewId());
        }
        mController.onDestroy();
    }

    @Override
    public void onFlutterViewAttached(@NonNull View flutterView) {
        if (mLifecycle != null) {
            mLifecycle.onFlutterViewAttached(this, mController.getViewId(), flutterView);
        }
    }

    @Override
    public void onFlutterViewDetached() {
        if (mLifecycle != null) {
            mLifecycle.onFlutterViewDetached(this, mController.getViewId());
        }
    }


    @Override
    public void onInputConnectionLocked() {
    }

    @Override
    public void onInputConnectionUnlocked() {
    }

    public interface FTCEffectAnimViewLifecycle {
        default void onCreate(FTCEffectAnimView animView, int viewId) {
        }

        default void onFlutterViewAttached(FTCEffectAnimView animView, int viewId, View flutterView) {
        }

        default void onFlutterViewDetached(FTCEffectAnimView animView, int viewId) {
        }

        default void onDispose(FTCEffectAnimView animView, int viewId) {
        }
    }
}
