package uz.unnarsx.cherrygram.chats;

import android.content.Context;
import android.content.SharedPreferences;

import org.telegram.messenger.ApplicationLoader;
import org.telegram.messenger.MessageObject;
import org.telegram.messenger.Utilities;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class GroupAdFilter {
    private static final Pattern WHITESPACE = Pattern.compile("[\\s\\p{Z}]+");

    private GroupAdFilter() {
    }

    public static String fingerprint(MessageObject message) {
        if (message == null || message.messageOwner == null || message.getId() <= 0
                || message.messageOwner.action != null || message.isSponsored()) {
            return null;
        }
        String text = message.messageOwner.message;
        if (text == null || text.isEmpty()) {
            return null;
        }
        String normalized = WHITESPACE.matcher(text).replaceAll(" ").trim();
        if (normalized.isEmpty()) {
            return null;
        }
        return Utilities.bytesToHex(Utilities.computeSHA256(normalized.getBytes(StandardCharsets.UTF_8)));
    }

    private static SharedPreferences preferences() {
        return ApplicationLoader.applicationContext.getSharedPreferences("personal_group_ads", Context.MODE_PRIVATE);
    }

    public static Set<String> getRules(long userId, long dialogId) {
        return preferences().getStringSet(userId + ":" + dialogId, Collections.emptySet());
    }

    public static Set<String> setRule(long userId, long dialogId, String fingerprint, boolean hide) {
        Set<String> rules = new HashSet<>(getRules(userId, dialogId));
        if (hide) {
            rules.add(fingerprint);
        } else {
            rules.remove(fingerprint);
        }
        preferences().edit().putStringSet(userId + ":" + dialogId, rules).apply();
        return rules;
    }
}
