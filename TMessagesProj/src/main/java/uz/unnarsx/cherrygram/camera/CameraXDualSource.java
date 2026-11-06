package uz.unnarsx.cherrygram.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import org.telegram.messenger.camera.CameraSessionWrapper;
import org.telegram.messenger.camera.Size;
import java.util.function.Consumer;

/** Disabled dual CameraX integration; regular Telegram camera remains available. */
public final class CameraXDualSource {
    public CameraXDualSource(Context context, boolean front) {}
    public static boolean isDualSupported(Context context) { return false; }
    public static Size estimateDisplaySize() { return new Size(720, 1280); }
    public Session open(boolean front, SurfaceTexture texture, Consumer<Session> onSizeChanged) { return null; }
    public void setMainFront(boolean front) {}
    public void release() {}
    public CameraXController getController() { return null; }
    public void setOnMainCameraChanged(Runnable listener) {}
    public void setOnError(Runnable listener) {}
    public float getMainExposureValue() { return 0.5f; }
    public static final class Session extends CameraSessionWrapper {
        public Size getDisplaySize() { return new Size(720, 1280); }
        public android.util.Size getResolution() { return null; }
    }
}
