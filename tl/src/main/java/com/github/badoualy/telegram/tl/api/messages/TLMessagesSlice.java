package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsMessage;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessagesSlice extends TLAbsMessages {

    public static final int CONSTRUCTOR_ID = 0x3a54685e;

    protected int flags;

    protected boolean inexact;

    protected int count;

    protected Integer nextRate;

    protected Integer offsetIdOffset;

    private final String _constructor = "messages.messagesSlice#3a54685e";

    public TLMessagesSlice() {
    }

    public TLMessagesSlice(boolean inexact, int count, Integer nextRate, Integer offsetIdOffset,
                           TLVector<TLAbsMessage> messages, TLVector<TLAbsChat> chats,
                           TLVector<TLAbsUser> users) {
        this.inexact = inexact;
        this.count = count;
        this.nextRate = nextRate;
        this.offsetIdOffset = offsetIdOffset;
        this.messages = messages;
        this.chats = chats;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = inexact ? (flags | 2) : (flags & ~2);
        flags = nextRate != null ? (flags | 1) : (flags & ~1);
        flags = offsetIdOffset != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(count, stream);
        if ((flags & 1) != 0) {
            if (nextRate == null) throwNullFieldException("nextRate", flags);
            writeInt(nextRate, stream);
        }
        if ((flags & 4) != 0) {
            if (offsetIdOffset == null) throwNullFieldException("offsetIdOffset", flags);
            writeInt(offsetIdOffset, stream);
        }
        writeTLVector(messages, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        inexact = (flags & 2) != 0;
        count = readInt(stream);
        nextRate = (flags & 1) != 0 ? readInt(stream) : null;
        offsetIdOffset = (flags & 4) != 0 ? readInt(stream) : null;
        messages = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (nextRate == null) throwNullFieldException("nextRate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4) != 0) {
            if (offsetIdOffset == null) throwNullFieldException("offsetIdOffset", flags);
            size += SIZE_INT32;
        }
        size += messages.computeSerializedSize();
        size += chats.computeSerializedSize();
        size += users.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TLVector<TLAbsMessage> getMessages() {
        return messages;
    }

    public void setMessages(TLVector<TLAbsMessage> messages) {
        this.messages = messages;
    }

    public TLVector<TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(TLVector<TLAbsChat> chats) {
        this.chats = chats;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
