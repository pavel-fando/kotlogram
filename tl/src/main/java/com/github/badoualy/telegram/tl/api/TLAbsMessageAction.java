package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLMessageActionChannelCreate}: messageActionChannelCreate#95d2ac92</li>
 * <li>{@link TLMessageActionChannelMigrateFrom}: messageActionChannelMigrateFrom#b055eaee</li>
 * <li>{@link TLMessageActionChatAddUser}: messageActionChatAddUser#15cefd00</li>
 * <li>{@link TLMessageActionChatCreate}: messageActionChatCreate#bd47cbad</li>
 * <li>{@link TLMessageActionChatDeletePhoto}: messageActionChatDeletePhoto#95e3fbef</li>
 * <li>{@link TLMessageActionChatDeleteUser}: messageActionChatDeleteUser#a43f30cc</li>
 * <li>{@link TLMessageActionChatEditPhoto}: messageActionChatEditPhoto#7fcb13a8</li>
 * <li>{@link TLMessageActionChatEditTitle}: messageActionChatEditTitle#b5a1ce5a</li>
 * <li>{@link TLMessageActionChatJoinedByLink}: messageActionChatJoinedByLink#31224c3</li>
 * <li>{@link TLMessageActionChatMigrateTo}: messageActionChatMigrateTo#51bdb021</li>
 * <li>{@link TLMessageActionEmpty}: messageActionEmpty#b6aef7b0</li>
 * <li>{@link TLMessageActionGameScore}: messageActionGameScore#92a72876</li>
 * <li>{@link TLMessageActionHistoryClear}: messageActionHistoryClear#9fbab604</li>
 * <li>{@link TLMessageActionPaymentSent}: messageActionPaymentSent#40699cd0</li>
 * <li>{@link TLMessageActionPaymentSentMe}: messageActionPaymentSentMe#8f31b327</li>
 * <li>{@link TLMessageActionPhoneCall}: messageActionPhoneCall#80e11a7f</li>
 * <li>{@link TLMessageActionPinMessage}: messageActionPinMessage#94bd38ed</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsMessageAction extends TLObject {

    public TLAbsMessageAction() {
    }
}
