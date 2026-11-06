package uz.unnarsx.cherrygram.camera;

import android.content.Context;
import android.view.View;
import org.telegram.ui.ActionBar.Theme;
import org.telegram.ui.Components.blur3.BlurredBackgroundDrawableViewFactory;
import org.telegram.ui.Components.blur3.drawable.color.BlurredBackgroundColorProvider;
import java.util.function.Consumer;

/** Compatibility view: advanced camera zoom UI is removed in the personal build. */
public class CherryZoomSliderView extends View {
    public interface ZoomController {}
    public CherryZoomSliderView(Context context, Theme.ResourcesProvider provider, boolean story) { super(context); setVisibility(GONE); }
    public void hideImmediately() { setVisibility(GONE); }
    public void collapse() { setVisibility(GONE); }
    public void bindCamera(ZoomController camera) {}
    public void unbindCamera() {}
    public void prepareForCameraChange() {}
    public void scaleZoom(float value) {}
    public void setOnPresetSelectedListener(Consumer<Float> listener) {}
    public void setLiquidGlassBackground(BlurredBackgroundDrawableViewFactory factory, BlurredBackgroundColorProvider provider) {}
}
