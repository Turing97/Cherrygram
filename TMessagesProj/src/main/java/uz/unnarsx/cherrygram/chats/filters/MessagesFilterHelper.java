package uz.unnarsx.cherrygram.chats.filters;

import java.util.ArrayList;
import org.telegram.messenger.MessageObject;
import org.telegram.tgnet.TLRPC;

/** Chat filtering is removed. Existing Telegram spoiler entities are preserved. */
public final class MessagesFilterHelper {
    public static final MessagesFilterHelper INSTANCE = new MessagesFilterHelper();
    private MessagesFilterHelper() {}
    public boolean shouldBlockMessage(MessageObject message) { return false; }
    public boolean shouldCollapseMessage(MessageObject message) { return false; }
    public ArrayList<TLRPC.MessageEntity> addSpoilerEntities(MessageObject message) {
        return message == null ? new ArrayList<>() : message.getEntities();
    }
    public ArrayList<TLRPC.MessageEntity> addSpoilerEntities(MessageObject message, ArrayList<TLRPC.MessageEntity> original, CharSequence text) { return original; }
    public String spoilerText(MessageObject message, String text) { return text; }
    public String getExcludedList() { return "disabled_message_filter_exclusions"; }
    public ArrayList<String> getArrayList(String key) { return new ArrayList<>(); }
    public void saveArrayList(ArrayList<String> values, String key) {}
    public int getExcludedChatsCount() { return 0; }
}
