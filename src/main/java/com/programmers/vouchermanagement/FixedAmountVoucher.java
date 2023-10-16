package com.programmers.vouchermanagement;

import java.util.UUID;

public class FixedAmountVoucher implements Voucher {
    private final UUID voucherID;
    private final long discountAmount;

    public FixedAmountVoucher(UUID voucherID, long discountAmount) {
        this.voucherID = voucherID;
        this.discountAmount = discountAmount;
    }

    @Override
    public UUID getVoucherId() {
        return voucherID;
    }

    @Override
    public long discount(long priceBeforeDiscount) {
        return priceBeforeDiscount - discountAmount;
    }
}
