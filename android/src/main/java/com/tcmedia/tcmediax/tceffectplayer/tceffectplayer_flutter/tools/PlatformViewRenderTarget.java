package com.tcmedia.tcmediax.tceffectplayer.tceffectplayer_flutter.tools;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import java.lang.reflect.Field;

/**
 * 关于 io.flutter.plugin.platform.PlatformViewsController 类中的 RenderTarget 开关属性统计
 * -
 * flutter 3.16.0 : 只有 enableHardwareBufferRenderingTarget 开关，默认是 false，因此只会走 SurfaceTexturePlatformViewRenderTarget
 * -  source link : <a href="https://github.com/flutter/engine/blob/3.16.0/shell/platform/android/io/flutter/plugin/platform/PlatformViewsController.java">...</a>
 * -
 * flutter 3.16.9 : 同上
 * -  source link : <a href="https://github.com/flutter/engine/blob/3.16.9/shell/platform/android/io/flutter/plugin/platform/PlatformViewsController.java">...</a>
 * -
 * flutter 3.19.0 : 增加为 enableImageRenderTarget(默认true) & enableSurfaceProducerRenderTarget(默认false) 属性，分别用来控制 ImageReaderPlatformViewRenderTarget 和 SurfaceProducerPlatformViewRenderTarget
 * -  source link : <a href="https://github.com/flutter/engine/blob/3.19.0/shell/platform/android/io/flutter/plugin/platform/PlatformViewsController.java">...</a>
 * -
 * flutter 3.19.6 : 同上
 * -  source link : <a href="https://github.com/flutter/engine/blob/3.19.6/shell/platform/android/io/flutter/plugin/platform/PlatformViewsController.java">...</a>
 * -
 * flutter 3.22.0 : 将默认值修改：enableImageRenderTarget(默认true) & enableSurfaceProducerRenderTarget(默认true)
 * -  source link : <a href="https://github.com/flutter/engine/blob/3.22.0/shell/platform/android/io/flutter/plugin/platform/PlatformViewsController.java">...</a>
 * -
 * flutter 3.22.3 : 同上
 * -  source link : <a href="https://github.com/flutter/engine/blob/3.22.3/shell/platform/android/io/flutter/plugin/platform/PlatformViewsController.java">...</a>
 * -
 * flutter 3.24.0 : 同上
 * -  source link : <a href="https://github.com/flutter/engine/blob/3.24.0/shell/platform/android/io/flutter/plugin/platform/PlatformViewsController.java">...</a>
 * -
 * flutter 3.24.5 : 同上
 * -  source link : <a href="https://github.com/flutter/engine/blob/3.24.5/shell/platform/android/io/flutter/plugin/platform/PlatformViewsController.java">...</a>
 * -
 * flutter 3.27.0 : 同上
 * -  source link : <a href="https://github.com/flutter/engine/blob/3.27.0/shell/platform/android/io/flutter/plugin/platform/PlatformViewsController.java">...</a>
 * -
 * flutter 3.27.4 : 同上
 * -  source link : <a href="https://github.com/flutter/engine/blob/3.27.4/shell/platform/android/io/flutter/plugin/platform/PlatformViewsController.java">...</a>
 * -
 * flutter 3.29.0 : 同上
 * -  source link : <a href="https://github.com/flutter/flutter/blob/3.29.0/engine/src/flutter/shell/platform/android/io/flutter/plugin/platform/PlatformViewsController.java">...</a>
 * -
 * flutter 3.29.3 : 同上
 * -  source link : <a href="https://github.com/flutter/flutter/blob/3.29.3/engine/src/flutter/shell/platform/android/io/flutter/plugin/platform/PlatformViewsController.java">...</a>
 * -
 * flutter 3.32.0 : 同上
 * -  source link : <a href="https://github.com/flutter/flutter/blob/3.32.0/engine/src/flutter/shell/platform/android/io/flutter/plugin/platform/PlatformViewsController.java">...</a>
 * -
 * flutter 3.32.7 : 同上
 * -  source link : <a href="https://github.com/flutter/flutter/blob/3.32.7/engine/src/flutter/shell/platform/android/io/flutter/plugin/platform/PlatformViewsController.java">...</a>
 *
 */
public class PlatformViewRenderTarget {
    public static Boolean oriEnableImageRenderTarget;
    public static Boolean oriEnableSurfaceProducerRenderTarget;

    public static EnableResult enableSurfaceTexturePlatformViewRenderTarget() {
        return enablePlatformViewRenderTarget(false, false);
    }

    public static EnableResult restorePlatformViewRenderTarget() {
        if (oriEnableImageRenderTarget != null && oriEnableSurfaceProducerRenderTarget != null) {
            return enablePlatformViewRenderTarget(oriEnableImageRenderTarget, oriEnableSurfaceProducerRenderTarget);
        } else {
            return new EnableResult(EnableResult.UNKNOWN, "restorePlatformViewRenderTarget failed because no ori-value");
        }
    }

    private static EnableResult enablePlatformViewRenderTarget(boolean enableImageRenderTarget, boolean enableSurfaceProducerRenderTarget) {
        try {
            Class<?> clazz = Class.forName("io.flutter.plugin.platform.PlatformViewsController");
            Field fieldeImageRenderTarget = clazz.getDeclaredField("enableImageRenderTarget");
            fieldeImageRenderTarget.setAccessible(true);
            if (oriEnableImageRenderTarget == null) {
                Object value = fieldeImageRenderTarget.get(null);
                if (value instanceof Boolean) {
                    oriEnableImageRenderTarget = (boolean) value;
                }
            }
            fieldeImageRenderTarget.set(null, enableImageRenderTarget);

            Field fieldSurfaceProducerRenderTarget = clazz.getDeclaredField("enableSurfaceProducerRenderTarget");
            fieldSurfaceProducerRenderTarget.setAccessible(true);
            if (oriEnableSurfaceProducerRenderTarget == null) {
                Object value = fieldSurfaceProducerRenderTarget.get(null);
                if (value instanceof Boolean) {
                    oriEnableSurfaceProducerRenderTarget = (boolean) value;
                }
            }
            fieldSurfaceProducerRenderTarget.set(null, enableSurfaceProducerRenderTarget);
            return EnableResult.success();
        } catch (NoSuchFieldException e) {
            // 没有这俩属性的话，就是3.19.0版本之前的sdk
            return new EnableResult(EnableResult.NO_SUCH_FILED, e.toString());
        } catch (Exception e) {
            return new EnableResult(EnableResult.UNKNOWN, e.toString());
        }
    }

    public static final class EnableResult {
        public static final String SUCCESS = "SUCCESS";
        public static final String NO_SUCH_FILED = "NO_SUCH_FILED";
        public static final String UNKNOWN = "UNKNOWN";

        public final String result;
        public final String msg;

        public EnableResult(String result, String msg) {
            this.result = result;
            this.msg = msg;
        }

        @NonNull
        @Override
        public String toString() {
            return result + (TextUtils.isEmpty(msg) ? "" : " : " + msg);
        }

        public static EnableResult success() {
            return new EnableResult(SUCCESS, "");
        }
    }
}
