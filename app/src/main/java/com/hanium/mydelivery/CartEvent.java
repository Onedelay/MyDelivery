package com.hanium.mydelivery;

import com.hanium.mydelivery.data.CartItem;

/**
 * Created by su_me on 2017-09-10.
 */

public interface CartEvent {
    void addToCart(int index);
    void removeToCart(int index);
}
