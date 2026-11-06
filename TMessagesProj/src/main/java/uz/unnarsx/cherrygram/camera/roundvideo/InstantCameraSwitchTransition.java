package uz.unnarsx.cherrygram.camera.roundvideo;

/** The optional animated CameraX switch is disabled in the personal build. */
public final class InstantCameraSwitchTransition {
    public InstantCameraSwitchTransition(int width) {}
    public boolean isActive() { return false; }
    public boolean begin(int texture, boolean front) { return false; }
    public boolean onCameraFrame(int texture) { return false; }
    public boolean render(int texture) { return false; }
    public void cancel() {}
    public void destroy() {}
    public boolean isWaitingForCamera() { return false; }
    public long getNextFrameDelayMs() { return 16L; }
}
