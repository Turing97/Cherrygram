package uz.unnarsx.cherrygram.camera;

import android.content.Context;
import android.util.Range;
import androidx.annotation.IntDef;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import org.telegram.messenger.camera.Size;
import java.io.File;
import uz.unnarsx.cherrygram.camera.CameraXView.VideoSavedCallback;

/** Compatibility surface for the unpublished optional CameraX implementation.
 * CameraX is disabled; Telegram's standard camera is used instead. */
public final class CameraXController implements CherryZoomSliderView.ZoomController {
    public static final int CAMERA_NONE = 0, CAMERA_HDR = 1, CAMERA_NIGHT = 2,
        CAMERA_AUTO = 3, CAMERA_WIDE = 4, CAMERA_ASPECT_RATIO_SELECTOR = 5;
    @IntDef({CAMERA_NONE, CAMERA_HDR, CAMERA_NIGHT, CAMERA_AUTO, CAMERA_WIDE, CAMERA_ASPECT_RATIO_SELECTOR})
    public @interface EffectFacing {}
    public static final class CameraLifecycle implements LifecycleOwner {
        private final LifecycleRegistry registry = new LifecycleRegistry(this);
        @Override public Lifecycle getLifecycle() { return registry; }
        public void start() { registry.setCurrentState(Lifecycle.State.STARTED); }
        public void pause() { registry.setCurrentState(Lifecycle.State.CREATED); }
        public boolean isDestroyed() { return registry.getCurrentState() == Lifecycle.State.DESTROYED; }
    }
    private boolean front;
    public CameraXController(CameraLifecycle lifecycle, MeteringPointFactory metering, Preview.SurfaceProvider provider) {}
    public static boolean hasGoodCamera(Context context) { return false; }
    public static Range<Float> getZoomRatioRange(CameraInfo info) { return new Range<>(1f, 1f); }
    public void setPreviewRotation(int rotation) {}
    public void setCaptureRotation(int rotation) {}
    public void setFrontFace(boolean front) { this.front = front; }
    public boolean isFrontface() { return front; }
    public void initCamera(Context context, boolean front, Runnable ready) {}
    public boolean isInitiated() { return false; }
    public boolean isCameraReady() { return false; }
    public void closeCamera() {}
    public void bindUseCasesKeepingZoom() {}
    public void switchCamera() {}
    public void setCameraEffect(int effect) {}
    public int getCameraEffect() { return CAMERA_NONE; }
    public boolean hasFrontFaceCamera() { return false; }
    public int setNextFlashMode() { return 0; }
    public int getCurrentFlashMode() { return 0; }
    public void setZoom(float value) {}
    public float resetZoom() { return 1f; }
    public float getZoomRatio() { return 1f; }
    public float getMaxZoomRatio() { return 1f; }
    public void setZoomRatio(float value) {}
    public boolean isAvailableHdrMode() { return false; }
    public boolean isAvailableWideMode() { return false; }
    public boolean isAvailableNightMode() { return false; }
    public boolean isAvailableAutoMode() { return false; }
    public boolean isExposureCompensationSupported() { return false; }
    public void setExposureCompensation(float value) {}
    public void focusToPoint(int x, int y, boolean focus) {}
    public Size getPreviewSize() { return new Size(720, 1280); }
    public int getDisplayOrientation() { return 0; }
    public void recordVideo(File path, boolean mirrorThumb, VideoSavedCallback callback) {}
    public void stopVideoRecording(boolean abandon) {}
    public void takePicture(File file, Runnable callback) {}
    public void setTorchEnabled(boolean enabled) {}
    public void setUltraWideStartAllowed(boolean enabled) {}
}
