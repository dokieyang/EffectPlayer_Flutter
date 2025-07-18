package com.tcmedia.tcmediax.tceffectplayer.tceffectplayer_flutter.ui.view;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tcmedia.tcmediax.tceffectplayer.tceffectplayer_flutter.tools.PlatformViewRenderTarget;
import com.tencent.tcmediax.utils.Log;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class FTCEffectViewFactory extends PlatformViewFactory {
    private static final String TAG = "FTCEffectViewFactory";

    private final Map<Integer, WeakReference<FTCEffectAnimView>> mRenderViewCache = new HashMap<>();
    private final BinaryMessenger mBinaryMessenger;

    public FTCEffectViewFactory(BinaryMessenger binaryMessenger) {
        super(StandardMessageCodec.INSTANCE);
        mBinaryMessenger = binaryMessenger;
    }

    @NonNull
    @Override
    public PlatformView create(Context context, int viewId, @Nullable Object args) {
        final Map<String, Object> creationParams = (Map<String, Object>) args;
        return new FTCEffectAnimView(context, viewId, creationParams, mBinaryMessenger, ftcEffectAnimViewLifecycle);
    }

    private final FTCEffectAnimView.FTCEffectAnimViewLifecycle ftcEffectAnimViewLifecycle = new FTCEffectAnimView.FTCEffectAnimViewLifecycle() {
        @Override
        public void onCreate(FTCEffectAnimView animView, int viewId) {
            if(mRenderViewCache.isEmpty()){
                PlatformViewRenderTarget.EnableResult result = PlatformViewRenderTarget.enableSurfaceTexturePlatformViewRenderTarget();
                Log.d(TAG, "try to enable SurfaceTextureRenderTarget with result:" + result);
            }
            mRenderViewCache.put(viewId, new WeakReference<>(animView));
        }

        @Override
        public void onDispose(FTCEffectAnimView animView, int viewId) {
            mRenderViewCache.remove(viewId);
            if (mRenderViewCache.isEmpty()) {
                PlatformViewRenderTarget.EnableResult result = PlatformViewRenderTarget.restorePlatformViewRenderTarget();
                Log.d(TAG, "try to restore PlatformViewRenderTarget with result:" + result);
            }
        }
    };
}
