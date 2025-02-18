package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageMediaDocument extends TLAbsMessageMedia {

    public static final int CONSTRUCTOR_ID = 0x9cb070d7;

    protected int flags;

    protected TLAbsDocument document;

    protected Integer ttlSeconds;

    private final String _constructor = "messageMediaDocument#9cb070d7";

    public TLMessageMediaDocument() {
    }

    public TLMessageMediaDocument(TLAbsDocument document, Integer ttlSeconds) {
        this.document = document;
        this.ttlSeconds = ttlSeconds;
    }

    private void computeFlags() {
        flags = 0;
        flags = document != null ? (flags | 1) : (flags & ~1);
        flags = ttlSeconds != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            writeTLObject(document, stream);
        }
        if ((flags & 4) != 0) {
            if (ttlSeconds == null) throwNullFieldException("ttlSeconds", flags);
            writeInt(ttlSeconds, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        document = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsDocument.class, -1) : null;
        ttlSeconds = (flags & 4) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            size += document.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (ttlSeconds == null) throwNullFieldException("ttlSeconds", flags);
            size += SIZE_INT32;
        }
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

    public TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsDocument document) {
        this.document = document;
    }

    public Integer getTtlSeconds() {
        return ttlSeconds;
    }

    public void setTtlSeconds(Integer ttlSeconds) {
        this.ttlSeconds = ttlSeconds;
    }
}
