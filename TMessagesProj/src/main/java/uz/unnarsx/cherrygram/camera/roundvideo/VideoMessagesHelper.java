package uz.unnarsx.cherrygram.camera.roundvideo;

import android.graphics.SurfaceTexture;
import android.util.Range;
import org.telegram.ui.Components.InstantCameraView;
import org.telegram.ui.Components.InstantCameraView2;
import uz.unnarsx.cherrygram.camera.CameraXController;

/** Optional CameraX round-video controls are disabled; standard camera path remains. */
public final class VideoMessagesHelper {
    public CameraXController cameraXController;
    public static boolean isCamera60Fps() { return false; }
    public static Range<Integer> getCameraXFpsRange() { return new Range<>(30, 30); }
    public void showExposureControls(InstantCameraView view, boolean show) {}
    public void showExposureControls(InstantCameraView2 view, boolean show) {}
    public void switchCameraX(InstantCameraView view) {}
    public void checkFlash(InstantCameraView view) {}
    public void checkFlash(InstantCameraView2 view) {}
    public boolean createFlashConfigurator(InstantCameraView view) { return false; }
    public boolean createFlashConfigurator(InstantCameraView2 view) { return false; }
    public void destroyCameraX(InstantCameraView view) { cameraXController = null; }
    public void updateCameraXFlash(InstantCameraView view) {}
    public void createSingleCameraX(InstantCameraView view, SurfaceTexture texture) {}
    public void createDualCameraX(InstantCameraView view, SurfaceTexture[] textures) {}
    public void prepareCameraSwitch(InstantCameraView2 view) {}
}
