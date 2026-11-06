package uz.unnarsx.cherrygram.chats.ui;

import android.content.Context;
import android.widget.LinearLayout;
import org.telegram.messenger.MessageObject;
import org.telegram.ui.ActionBar.Theme;

/** Compatibility for Cherrygram's missing optional menu implementation. Use the classic menu. */
public final class MessageMenuHelper {
    private static final MessageMenuHelper INSTANCE = new MessageMenuHelper();

    public static MessageMenuHelper getInstance(int account) { return INSTANCE; }
    public static int getMessageMenuGapColor(Theme.ResourcesProvider provider) {
        return Theme.getColor(Theme.key_windowBackgroundGrayShadow, provider);
    }
    public static int getMessageMenuBackgroundColor(Theme.ResourcesProvider provider) {
        return Theme.getColor(Theme.key_actionBarDefaultSubmenuBackground, provider);
    }
    public static boolean isMenuOnRight(Object view, MessageObject message) { return false; }

    public boolean allowNewMessageMenu() { return false; }
    public boolean allowNewMessageMenu(MessageObject message) { return false; }
    public boolean showDivider() { return true; }
    public boolean showCustomDivider(boolean enabled) { return false; }
    public int getCloseAnimationDuration() { return 220; }
    public void drawCopyInChat(Object canvas, Object view) { }
    public void createMenu(Object... args) { }
    public void hideMessageView(Object... args) { }
    public void checkBlur(Object... args) { }
    public void runAfterMenuClosed(Runnable action) { action.run(); }

    public static class MaxHeightLinearLayout extends LinearLayout {
        private int maxHeight = Integer.MAX_VALUE;
        public MaxHeightLinearLayout(Context context) { super(context); }
        public void setMaxHeight(int height) { maxHeight = height; requestLayout(); }
        @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            if (getMeasuredHeight() > maxHeight) {
                super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST));
            }
        }
    }
}
