package uz.unnarsx.cherrygram.chats.ui;

import android.widget.FrameLayout;
import org.telegram.messenger.MessageObject;
import org.telegram.ui.ChatActivity;

/** The optional compact menu is absent from the published source. */
public final class MessageMenuCompactView extends FrameLayout {
    public static boolean allowCompactStyle() { return false; }
    public MessageMenuCompactView(ChatActivity chat, MessageObject message, int size,
                                  boolean reply, boolean edit, boolean forward, boolean copy,
                                  boolean copyPhoto, boolean copyLink, boolean delete) {
        super(chat.getParentActivity());
    }
}
