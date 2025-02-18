package com.github.badoualy.telegram.tl.api.account;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

public class TLPasswordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow extends TLAbsPasswordKdfAlgo {

    public static final int CONSTRUCTOR_ID = 0x3a912d4a;

    protected TLBytes salt1;

    protected TLBytes salt2;

    protected int g;

    protected TLBytes p;

    private final String _constructor = "passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow#3a912d4a";

    public TLPasswordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow() {
    }

    public TLPasswordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow(TLBytes salt1, TLBytes salt2, int g, TLBytes p) {
        this.salt1 = salt1;
        this.salt2 = salt2;
        this.g = g;
        this.p = p;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(salt1, stream);
        writeTLBytes(salt2, stream);
        writeInt(g, stream);
        writeTLBytes(p, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        salt1 = readTLBytes(stream, context);
        salt2 = readTLBytes(stream, context);
        g = readInt(stream);
        p = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLBytesSerializedSize(salt1);
        size += computeTLBytesSerializedSize(salt2);
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(p);
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

    public TLBytes getSalt1() {
        return salt1;
    }

    public void setSalt1(TLBytes salt1) {
        this.salt1 = salt1;
    }

    public TLBytes getSalt2() {
        return salt2;
    }

    public void setSalt2(TLBytes salt2) {
        this.salt2 = salt2;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public TLBytes getP() {
        return p;
    }

    public void setP(TLBytes p) {
        this.p = p;
    }
}
